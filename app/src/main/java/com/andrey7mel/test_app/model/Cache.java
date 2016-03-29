package com.andrey7mel.test_app.model;

import com.andrey7mel.test_app.view.Message;

import java.util.List;

import rx.Observable;

public interface Cache {

    Observable<List<Message>> getHistory();

    void putMessage(Message message);

}
