package com.example.lab5;

import android.app.Application;
import android.content.res.Resources;

//Used for string resource access in the whole project
public class App extends Application {
    private static App mInstance;
    private static Resources res;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        res = getResources();
    }

    public static App getInstance() {
        return mInstance;
    }

    public static Resources getRes() {
        return res;
    }

}