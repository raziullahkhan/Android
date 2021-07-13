package com.example.android.githubreposearch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.githubreposearch.utilities.NetworkUtils;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.main,menu);
       return true;
    }
    private void makeGithubSearchQuery() {
        String githubQuery = etSearchBox.getText().toString();
        URL githubSearchUrl = NetworkUtils.buildUrl(githubQuery);
        tvUrlDisplay.setText(githubSearchUrl.toString());
        String githubSearchResults=null;
        new GithubQueryTask().execute(githubSearchUrl);
    }
    private void showErrorMessage(){
        tvSearchResult.setVisibility(View.INVISIBLE);
        tvErrorMessage.setVisibility(View.VISIBLE);
    }
    private void showJsonDataView(){
        tvErrorMessage.setVisibility(View.INVISIBLE);
        tvSearchResult.setVisibility(View.VISIBLE);
    }
    public class GithubQueryTask extends AsyncTask<URL,Void,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pbLoading.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl=urls[0];
            String githubSearchResults=null;
            try{
                githubSearchResults=NetworkUtils.getResponseFromHttpUrl(searchUrl);
            }catch(IOException e){
                e.printStackTrace();
            }
            return githubSearchResults;
        }

        @Override
        protected void onPostExecute(String githubSearchResults) {
            pbLoading.setVisibility(View.INVISIBLE);
            if(githubSearchResults !=null&&!githubSearchResults.equals("")){
                showJsonDataView();
            }else
                showErrorMessage();
        }
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
}