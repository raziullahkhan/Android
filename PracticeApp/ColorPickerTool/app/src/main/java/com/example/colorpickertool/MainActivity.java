package com.example.colorpickertool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
    private TextView welcomeTextView;
    private Button mSetColorButton, mPickColorButton;
    private View mColorPreview;
    private int mDefaultColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomeTextView=findViewById(R.id.gfg_heading);
        mPickColorButton=findViewById(R.id.pick_color_button);
        mSetColorButton=findViewById(R.id.set_color_button);
        mColorPreview=findViewById(R.id.preview_selected_color);
        mDefaultColor=0;
        mPickColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPickerDialogue();
            }
        });
        mSetColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcomeTextView.setTextColor(mDefaultColor);
            }
        });
    }
    public void openColorPickerDialogue(){
        final AmbilWarnaDialog colorPickerDialog=
                new AmbilWarnaDialog(this, mDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
                    @Override
                    public void onCancel(AmbilWarnaDialog dialog) {

                    }

                    @Override
                    public void onOk(AmbilWarnaDialog dialog, int color) {
                        mDefaultColor=color;
                        mColorPreview.setBackgroundColor(mDefaultColor);
                    }
                });
        colorPickerDialog.show();
    }
}