package com.andrey7mel.test_app;

import android.os.Bundle;

import com.andrey7mel.test_app.other.BaseTest;
import com.andrey7mel.test_app.presenter.Presenter;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.util.ActivityController;

import javax.inject.Inject;

import static org.mockito.Mockito.verify;

public class MainActivityTest extends BaseTest {

    private MainActivity mainActivity;

    private ActivityController controller;

    @Inject
    Presenter presenter;

    @Before
    public void setUp() throws Exception {
        component.inject(this);
        controller = Robolectric.buildActivity(MainActivity.class);
        mainActivity = (MainActivity) controller.get();

    }

    @Test
    public void testOnCreateNull() {
        controller.create(null);
        verify(presenter).onCreate(mainActivity,null);
    }

    @Test
    public void testOnCreate() {
        Bundle bundle = Bundle.EMPTY;
        controller.create(bundle);

        verify(presenter).onCreate(mainActivity,bundle);
    }

    @Test
    public void testOnStart() {
        controller.create(null);
        controller.start();

        verify(presenter).onStart();
    }


}