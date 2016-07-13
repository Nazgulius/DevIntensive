package com.softdesign.devintensive.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class DevintensiveApplication extends Application {
    private static SharedPreferences sSharedPreferencec;
    private static Context mContext;

    public static Context getContext() {
        return mContext;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        sSharedPreferencec = PreferenceManager.getDefaultSharedPreferences(this);
        mContext = this;
    }

    public static SharedPreferences getSharedPreferencec() {
        return sSharedPreferencec;
    }
}
