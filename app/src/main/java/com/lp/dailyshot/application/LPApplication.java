package com.lp.dailyshot.application;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.lp.dailyshot.util.AppUtil;

/**
 * Created by Patrick on 2017/10/22.
 */

public class LPApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        AppUtil.setAppContext(base);
        super.attachBaseContext(base);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
