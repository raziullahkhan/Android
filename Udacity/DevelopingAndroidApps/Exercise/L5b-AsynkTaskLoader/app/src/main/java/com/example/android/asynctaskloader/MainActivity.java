package com.example.android.asynctaskloader;


import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import com.example.android.asynctaskloader.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
    private static final String SEARCH_QUERY_URL_EXTRA = "query";
    private static final String SEARCH_RESULTS_RAW_JSON = "results";
    private static final int GITHUB_SEARCH_LOADER=22;
    EditText etSearchBox;
    TextView tvUrlDisplay;
    TextView tvSearchResult;
    TextView tvErrorMessage;
    ProgressBar pbLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSearchBox=(EditText)findViewById(R.id.et_search_box);
        tvUrlDisplay=(TextView)findViewById(R.id.tv_url_display);
        tvSearchResult=(TextView)findViewById(R.id.tv_github_search_results_json);
        tvErrorMessage=(TextView)findViewById(R.id.tv_error_message_display);
        pbLoading=(ProgressBar)findViewById(R.id.pb_loading_indicator);
        if (savedInstanceState != null) {
            String queryUrl = savedInstanceState.getString(SEARCH_QUERY_URL_EXTRA);
            tvUrlDisplay.setText(queryUrl);
        }
        getSupportLoaderManager().initLoader(GITHUB_SEARCH_LOADER,null,this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main,menu);
       return true;
    }
    private void makeGithubSearchQuery() {
        String githubQuery = etSearchBox.getText().toString();
        if (TextUtils.isEmpty(githubQuery)) {
            tvUrlDisplay.setText("No query entered, nothing to search for.");
            return;
        }
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
        tvUrlDisplay.setText(githubSearchUrl.toString());
        Bundle queryBundle=new Bundle();
        queryBundle.putString(SEARCH_QUERY_URL_EXTRA,githubSearchUrl.toString());
        LoaderManager loaderManager=getSupportLoaderManager();
        Loader<String> githubSearchLoader=loaderManager.getLoader(GITHUB_SEARCH_LOADER);
        if (githubSearchLoader == null) {
            loaderManager.initLoader(GITHUB_SEARCH_LOADER,queryBundle,this);
        }else{
            loaderManager.restartLoader(GITHUB_SEARCH_LOADER,queryBundle,this);
        }
    }
    private void showErrorMessage(){
        tvSearchResult.setVisibility(View.INVISIBLE);
        tvErrorMessage.setVisibility(View.VISIBLE);
    }
    private void showJsonDataView(){
        tvErrorMessage.setVisibility(View.INVISIBLE);
        tvSearchResult.setVisibility(View.VISIBLE);
    }

    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            String mGithunJson;
            @Override
            public String loadInBackground() {
                String searhQueryUrlString = args.getString((SEARCH_QUERY_URL_EXTRA));
                if (TextUtils.isEmpty(searhQueryUrlString)) {
                    return null;
                }
                try {
                    URL githubUrl = new URL(searhQueryUrlString);
                    return NetworkUtils.getResponseFromHttpUrl(githubUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }


            @Override
            protected void onStartLoading() {

                if (args == null) {
                    return;
                }
                if(mGithunJson!=null){
                    deliverResult(mGithunJson);
                }else {
                    pbLoading.setVisibility(View.VISIBLE);
                    forceLoad();
                }
            }

            @Override
            public void deliverResult(String githubJson) {
                mGithunJson=githubJson;
                super.deliverResult(githubJson);
            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        pbLoading.setVisibility(View.INVISIBLE);
        if(data !=null&&!data.equals("")){
            showJsonDataView();
            tvSearchResult.setText(data);
        }else
            showErrorMessage();
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menuItemThatWasSelected=item.getItemId();
        if(menuItemThatWasSelected==R.id.action_search){
            makeGithubSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String queryUrl=tvUrlDisplay.getText().toString();
        outState.putString(SEARCH_QUERY_URL_EXTRA,queryUrl);

    }
}