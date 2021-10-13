package com.example.circularfillableloader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class MainActivity extends AppCompatActivity {

    CircularFillableLoaders circularFillableLoaders;
    SeekBar seekBar;
    int progress = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circularFillableLoaders = (CircularFillableLoaders) findViewById(R.id.circularFillableLoaders);

        circularFillableLoaders.setProgress(progress);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setProgress(progress);
        seekBar.setMax(100);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                circularFillableLoaders.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}