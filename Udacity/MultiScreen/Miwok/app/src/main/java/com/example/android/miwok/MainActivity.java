package com.example.android.miwok;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView numbers,family,colors,phrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager=(ViewPager)findViewById(R.id.viepager);
        CategoryAdapter adapter=new CategoryAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tab=(TabLayout)findViewById(R.id.tabs);
        tab.setupWithViewPager(viewPager);
    }

}



