package com.example.ratetheapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppRate.with(this).setInstallDays(0).setLaunchTimes(1)
                .setRemindInterval(1).monitor();
        AppRate.showRateDialogIfMeetsConditions(this);
    }
}