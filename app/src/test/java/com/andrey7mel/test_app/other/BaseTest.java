package com.andrey7mel.test_app.other;


import com.andrey7mel.test_app.BuildConfig;
import com.andrey7mel.test_app.other.di.TestComponent;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(application = TestApplication.class,
        constants = BuildConfig.class,
        sdk = 21)
@Ignore
public class BaseTest extends Assert {

    public TestComponent component;
    public TestUtils testUtils;

    @Before
    public void prepare() {
        component = (TestComponent) App.getComponent();
        testUtils = new TestUtils();
    }

}
