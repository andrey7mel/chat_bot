package com.andrey7mel.test_app.presenter;

import com.andrey7mel.test_app.model.Model;
import com.andrey7mel.test_app.other.BaseTest;
import com.andrey7mel.test_app.other.TestConst;
import com.andrey7mel.test_app.view.Message;
import com.andrey7mel.test_app.view.View;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PresenterImplTest extends BaseTest {

    private PresenterImpl presenter;

    @Inject
    Model model;

    private View view;

    private ArgumentCaptor<Message> argument;

    @Before
    public void setUp() throws Exception {
        presenter = new PresenterImpl();
        component.inject(this);
        view = mock(View.class);
        argument = ArgumentCaptor.forClass(Message.class);
    }

    @Test
    public void testInject() {
        assertNotNull(presenter.model);
    }

    @Test
    public void testClickEnter() {
        mockModelGetAnswer();
        presenter.onCreate(view, null);
        presenter.clickEnter(TestConst.TEST_INPUT);

        verify(model).getAnswer(TestConst.TEST_INPUT);
        verify(view).showMessage(argument.capture());

        assertEquals(3, argument.getAllValues().size());
        assertEquals(TestConst.TEST_INPUT, argument.getAllValues().get(0).getText());
        assertEquals(Message.TYPE.USER, argument.getAllValues().get(0).getType());

        assertEquals(TestConst.TEST_ANSWER1, argument.getAllValues().get(1).getText());
        assertEquals(Message.TYPE.BOT, argument.getAllValues().get(1).getType());

        assertEquals(TestConst.TEST_ANSWER2, argument.getAllValues().get(2).getText());
        assertEquals(Message.TYPE.BOT, argument.getAllValues().get(2).getType());

    }

    @Test
    public void testOnCreate() {
        View view = mock(View.class);
        presenter.onCreate(view, null);
        assertEquals(view, presenter.view);
    }

    @Test
    public void testOnStartWithoutHistory() {
        mockModelGetMessages();
        presenter.onCreate(view, null);
        presenter.onStart();
        mockModelGetMessages();

        verify(view, times(2)).showMessage(argument.capture());
        assertEquals(2, argument.getAllValues().size());

        assertEquals(TestConst.TEST_ANSWER1, argument.getAllValues().get(0).getText());
        assertEquals(Message.TYPE.BOT, argument.getAllValues().get(0).getType());

        assertEquals(TestConst.TEST_ANSWER2, argument.getAllValues().get(1).getText());
        assertEquals(Message.TYPE.BOT, argument.getAllValues().get(1).getType());

    }

    @Test
    public void testOnStop() {

    }

    private void mockModelGetMessages() {
        ArrayList<Message> list = new ArrayList<>();
        list.add(new Message(TestConst.TEST_ANSWER1, Message.TYPE.BOT));
        list.add(new Message(TestConst.TEST_ANSWER2, Message.TYPE.BOT));
        doAnswer(invocation -> Observable.from(list))
                .when(model)
                .getMessages();

    }

    private void mockModelGetAnswer() {
        ArrayList<Message> list = new ArrayList<>();
        list.add(new Message(TestConst.TEST_ANSWER1, Message.TYPE.BOT));
        list.add(new Message(TestConst.TEST_ANSWER2, Message.TYPE.BOT));
        doAnswer(invocation -> Observable.from(list))
                .when(model)
                .getAnswer(TestConst.TEST_INPUT);

    }



}