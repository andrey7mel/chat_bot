package com.andrey7mel.test_app.other.di;

import com.andrey7mel.test_app.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MainActivity in);

}
