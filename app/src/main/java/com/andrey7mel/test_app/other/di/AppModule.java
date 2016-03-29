package com.andrey7mel.test_app.other.di;

import com.andrey7mel.test_app.model.Model;
import com.andrey7mel.test_app.model.ModelImpl;
import com.andrey7mel.test_app.other.Const;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class AppModule {

    @Provides
    @Singleton
    @Named(Const.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named(Const.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    Model provideApiInterface() {
        return new ModelImpl();
    }

}
