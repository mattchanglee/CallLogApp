package com.homework.calllogapp;

import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;

public class CallLogContentObserver extends ContentObserver {
    final String LOG_TAG = "CallLogContentObserver";
    public static boolean updateCallList;
    public CallLogContentObserver(Handler h) {
        super (h);
    }

    @Override
    public boolean deliverSelfNotifications() {
        return true;
    }

    @Override
    public void onChange(boolean selfChange) {
        updateCallList = true;
        Log.d(LOG_TAG, "CallLogContentObserver.onChange("+selfChange+")");
        super.onChange(selfChange);
    }


}
