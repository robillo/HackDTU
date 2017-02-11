package com.appbusters.robinkamboj.hackdtu;

import android.util.Log;

import com.firebase.client.Firebase;

/**
 *
 *
 * Initialize Firebase with the application context. This must happen before the client is used.
 */
public class ChatApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        Log.e("Joey doesnt ","share food");

    }
}
