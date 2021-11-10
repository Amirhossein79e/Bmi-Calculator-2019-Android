package com.amirhosseinemadi.bmi.common;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class Application extends android.app.Application {

    public static Component component;
    public static Context context;

    @Override
    public void onCreate() {
        component = DaggerComponent.builder().module(new Module(getApplicationContext())).build();
        context = component.context();
        super.onCreate();
    }
}
