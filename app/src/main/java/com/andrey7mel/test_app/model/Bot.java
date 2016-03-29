package com.andrey7mel.test_app.model;

import com.andrey7mel.test_app.view.Message;

import rx.Observable;

public interface Bot {
    Observable<Message> getMessages();
}
