package com.andrey7mel.test_app.other.di;

import com.andrey7mel.test_app.presenter.PresenterImplTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent extends AppComponent {

    void inject(PresenterImplTest presenterImplTest);
}
