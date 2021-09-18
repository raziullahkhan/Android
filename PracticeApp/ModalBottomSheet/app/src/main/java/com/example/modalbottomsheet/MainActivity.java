package com.example.modalbottomsheet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button openBottomSheet=findViewById(R.id.open_bottom_sheet);
        openBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheet=new BottomSheetDialog();
                bottomSheet.show(getSupportFragmentManager(),"ModalBottomSheet");
            }
        });
    }
}