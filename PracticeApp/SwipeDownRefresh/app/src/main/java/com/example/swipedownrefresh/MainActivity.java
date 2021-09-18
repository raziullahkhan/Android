package com.example.swipedownrefresh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwipeRefreshLayout swipeRefreshLayout=(SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        TextView textView=(TextView)findViewById(R.id.tv1);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                textView.setText("Refreshed");
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}