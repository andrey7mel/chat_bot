package com.andrey7mel.test_app.other;

import com.andrey7mel.test_app.other.di.AppComponent;

public class TestApplication extends App {

    @Override
    protected AppComponent buildComponent() {
        return DaggerTestComponent.builder()
                .build();
    }
}
