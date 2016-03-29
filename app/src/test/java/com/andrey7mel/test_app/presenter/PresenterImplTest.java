package com.andrey7mel.test_app.presenter;

import com.andrey7mel.test_app.model.Model;
import com.andrey7mel.test_app.other.BaseTest;
import com.andrey7mel.test_app.other.TestConst;
import com.andrey7mel.test_app.view.View;

import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PresenterImplTest extends BaseTest {

    PresenterImpl presenter;

    @Inject
    Model model;

    View view;

    @Before
    public void setUp() throws Exception {
        presenter = new PresenterImpl();
        component.inject(this);
        View view = mock(View.class);
        presenter.onCreate(view, null);
    }

    @Test
    public void testInject() {
        assertNotNull(presenter.model);
    }

    @Test
    public void testClickEnter() {
        presenter.clickEnter(TestConst.TEST_STRING);
        verify(model, times(2)).getAnswer(TestConst.TEST_STRING); // times(2) for setUp()
    }

    @Test
    public void testOnCreate() {
        View view = mock(View.class);
        presenter.onCreate(view, null);
        assertEquals(view, presenter.view);
    }

    @Test
    public void testOnStartWithoutHistory() {

    }

    @Test
    public void testOnStop() {

    }
}