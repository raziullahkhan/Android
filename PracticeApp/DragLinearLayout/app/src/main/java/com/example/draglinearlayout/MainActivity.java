package com.example.draglinearlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DragLinearLayout dragLinearLayout=findViewById(R.id.container);
        for(int i=0;i<dragLinearLayout.getChildCount();i++){
            View child=dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child,child);
        }
    }
}