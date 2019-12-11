package com.wd.mvp.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 *@describe(描述)：App
 *@data（日期）: 2019/11/11
 *@time（时间）: 16:06
 *@author（作者）: xin
 **/
public class App extends Application {
    private static App sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
        Fresco.initialize(this);
    }

    public static App getAppContext(){
        return sContext;
    }
}
