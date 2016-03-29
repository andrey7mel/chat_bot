package com.andrey7mel.test_app.presenter;

import com.andrey7mel.test_app.model.Model;
import com.andrey7mel.test_app.other.BaseTest;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

public class PresenterImplTest extends BaseTest {

    PresenterImpl presenter;

    @Inject
    Model model;

    @Before
    public void setUp() throws Exception {
        presenter = new PresenterImpl();
    }

    @Test
    public void testInject(){
        assertNotNull(presenter.model);
    }

    @Test
    public void testClickEnter() {
    }

    @Test
    public void testOnCreate() {

    }

    @Test
    public void testOnStart() {

    }

    @Test
    public void testOnStop() {

    }
}