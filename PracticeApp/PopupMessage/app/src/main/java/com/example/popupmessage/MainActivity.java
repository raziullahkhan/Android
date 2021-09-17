package com.example.popupmessage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tapadoo.alerter.Alerter;
import com.tapadoo.alerter.OnHideAlertListener;
import com.tapadoo.alerter.OnShowAlertListener;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
    }
    public void showAlerter(View v){
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert Text")
                .setIcon(R.drawable.alerter_ic_notifications)
                .setBackgroundColorRes(R.color.alerter_default_success_background)
                .setDuration(3000)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //do Something
                    }
                }).setOnShowListener(new OnShowAlertListener() {
            @Override
            public void onShow() {
                //do Something
            }
        }).setOnHideListener(new OnHideAlertListener() {
            @Override
            public void onHide() {
                //do Something
            }
        }).show();
    }
}