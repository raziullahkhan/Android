package com.example.typingindicater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qifan.library.ChatTypingIndicatorView;

public class MainActivity extends AppCompatActivity {
    Button message;
    ChatTypingIndicatorView indicatorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message=(Button) findViewById(R.id.button);
        indicatorView=(ChatTypingIndicatorView) findViewById(R.id.indicatorView);

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                indicatorView.setVisibility(View.INVISIBLE);
            }
        });
    }
}