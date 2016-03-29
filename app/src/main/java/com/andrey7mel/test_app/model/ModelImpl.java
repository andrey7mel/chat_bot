package com.andrey7mel.test_app.model;

import com.andrey7mel.test_app.other.Const;
import com.andrey7mel.test_app.view.Message;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class ModelImpl implements Model {

    @Inject
    @Named(Const.UI_THREAD)
    Scheduler uiThread;

    @Inject
    @Named(Const.IO_THREAD)
    Scheduler ioThread;

    @Override
    public Observable<List<Message>> getHistory() {
        return null;
    }

    @Override
    public Observable<Message> getMessages() {
        return null;
    }
}
