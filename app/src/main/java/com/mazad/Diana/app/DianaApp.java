package com.mazad.Diana.app;

import android.app.Application;
import android.content.Context;

public class DianaApp extends Application {
    private static Context appContext;
    private static DianaApp mInstance;
    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;
        // setLocalenew();
        mInstance = this;

    }
    public static Context getAppContext() {
        return appContext;
    }
}
