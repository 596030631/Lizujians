package com.lizujian.qrcode;

import android.app.Application;

import com.lizujian.qrcode.sql.PreferencesService;

public class APP extends Application {
    public static final String USER = "user";
    public static final String PASSWORD = "password";

    public static APP instance;
    private static PreferencesService preferencesService;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;//获取myApp单li

        preferencesService = new PreferencesService(this);//初始化sp工具类
    }

    public static PreferencesService getPreferencesService() {
        if (preferencesService == null) {
            preferencesService = new PreferencesService();
        }
        return preferencesService;
    }

}

