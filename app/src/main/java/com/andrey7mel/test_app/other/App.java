package com.andrey7mel.test_app.other;

import android.app.Application;

import com.andrey7mel.test_app.other.di.AppComponent;
import com.andrey7mel.test_app.other.di.DaggerAppComponent;


public class App extends Application {

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.builder()
                .build();
    }


}
