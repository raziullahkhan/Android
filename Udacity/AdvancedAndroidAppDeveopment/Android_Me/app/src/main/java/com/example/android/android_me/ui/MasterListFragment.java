package com.example.android.android_me.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {

    public MasterListFragment(){
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView=inflater.inflate(R.layout.fragment_master_list,container,false);
        GridView gridView=(GridView)rootView.findViewById(R.id.images_grid_view);
        MasterListAdapter mAdapter=new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridView.setAdapter(mAdapter);
        return rootView;
    }
}
