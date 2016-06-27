package com.softdesign.devintensive.utils;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class DevintensiveApplication extends Application{
    public static SharedPreferences sSharedPreferencec;


    @Override
    public void onCreate() {
        super.onCreate();

        sSharedPreferencec = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public static SharedPreferences getSharedPreferencec() {
        return sSharedPreferencec;
    }
}
