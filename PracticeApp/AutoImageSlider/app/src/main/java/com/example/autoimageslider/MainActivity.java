package com.example.autoimageslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        SliderView sliderView = findViewById(R.id.slider);

        sliderDataArrayList.add(new SliderData(R.drawable.a1));
        sliderDataArrayList.add(new SliderData(R.drawable.a2));
        sliderDataArrayList.add(new SliderData(R.drawable.a3));

        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        sliderView.setSliderAdapter(adapter);

        sliderView.setScrollTimeInSec(3);

        sliderView.setAutoCycle(true);

        sliderView.startAutoCycle();
    }
}