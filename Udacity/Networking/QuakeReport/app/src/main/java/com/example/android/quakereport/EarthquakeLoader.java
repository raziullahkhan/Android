package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;


import java.util.ArrayList;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {
    private static final String LOG_TAG=EarthquakeLoader.class.getName();
    private String url;
    public EarthquakeLoader(Context context,String url) {
        super(context);
        this.url=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        if(url==null){
            return null;
        }
        ArrayList<Earthquake> earthquakes=QueryUtils.fetchEarthquakeData(url);
        return earthquakes;
    }
}
