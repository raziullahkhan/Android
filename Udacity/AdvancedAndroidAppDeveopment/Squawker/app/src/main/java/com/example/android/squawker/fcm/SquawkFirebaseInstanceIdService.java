package com.example.android.squawker.fcm;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;

public class SquawkFirebaseInstanceIdService extends FirebaseMessagingService {
    private static String LOG_TAG = SquawkFirebaseInstanceIdService.class.getSimpleName();

    @Override
    public void onNewToken(String s) {
        Log.d(LOG_TAG,"Refreshed TOKEN: "+s);
        sendRegistrationToServer(s);
    }

    private void sendRegistrationToServer(String s) {
    }
}
