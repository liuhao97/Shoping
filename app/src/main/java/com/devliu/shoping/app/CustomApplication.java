package com.devliu.shoping.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by liuhao
 * on 2017/4/2
 * use to :
 */

public class CustomApplication extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = getApplicationContext();
    }

    public static Context getAppContext(){
        return appContext;
    }

}
