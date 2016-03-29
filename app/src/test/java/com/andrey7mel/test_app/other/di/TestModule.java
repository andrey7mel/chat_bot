package com.andrey7mel.test_app.other.di;

import com.andrey7mel.test_app.model.Model;
import com.andrey7mel.test_app.model.ModelImpl;
import com.andrey7mel.test_app.other.Const;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.mock;

@Module
public class TestModule {


    @Provides
    @Singleton
    @Named(Const.UI_THREAD)
    Scheduler provideSchedulerUI() {
        return Schedulers.immediate();
    }

    @Provides
    @Singleton
    @Named(Const.IO_THREAD)
    Scheduler provideSchedulerIO() {
        return Schedulers.immediate();
    }

    @Provides
    @Singleton
    Model provideApiInterface() {
        return mock(ModelImpl.class);
    }

}
