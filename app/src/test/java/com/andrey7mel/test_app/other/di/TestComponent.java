package com.andrey7mel.test_app.other.di;

import com.andrey7mel.test_app.other.TestConst;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent extends AppComponent {

    void inject(TestConst testConst);

}
