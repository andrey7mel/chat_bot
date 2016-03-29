package com.andrey7mel.test_app.model;

import com.andrey7mel.test_app.other.Const;
import com.andrey7mel.test_app.view.Message;

import java.util.ArrayList;
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
        ArrayList<Message> list = new ArrayList<>();
        list.add(new Message("Привет!", Message.TYPE.BOT));
        list.add(new Message("Рад тебя видеть снова!", Message.TYPE.BOT));
        return Observable.from(list);
    }

    @Override
    public Observable<Message> getAnswer(String in) {
        return Observable.just(new Message(in.length() + " букв(ы)!", Message.TYPE.BOT));
    }
}
