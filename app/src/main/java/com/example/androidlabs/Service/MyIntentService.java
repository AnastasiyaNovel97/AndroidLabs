package com.example.androidlabs.Service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import java.util.concurrent.TimeUnit;

public class MyIntentService extends IntentService {

    private final String TAG = "IntentServiceLogs";

    public MyIntentService() {
        super("myname");
    }

    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int tm = intent.getIntExtra("time", 0);
        String label = intent.getStringExtra("task");
        Log.d(TAG, "onHandleIntent start: " + label);
        try {
            TimeUnit.SECONDS.sleep(tm);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "onHandleIntent end: " + label);
    }
}