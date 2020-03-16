package com.homework.calllogapp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

public class CallLogApplication extends Application {
    private static Context context;
    private static String TAG = CallLogApplication.class.getSimpleName();
    public void onCreate() {
        super.onCreate();
        CallLogApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        Log.d(TAG, "getAppContext " + CallLogApplication.context);
        return CallLogApplication.context;
    }
}
