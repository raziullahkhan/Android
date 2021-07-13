package com.example.android.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    TextView mDisplayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        mDisplayText=(TextView)findViewById(R.id.tv_display);
        Intent intent=getIntent();
        if(intent.hasExtra(Intent.EXTRA_TEXT)){
            String data=intent.getStringExtra(Intent.EXTRA_TEXT);
            mDisplayText.setText(data);
        }
    }
}