package com.andrey7mel.test_app.presenter;

import android.os.Bundle;

import com.andrey7mel.test_app.model.Model;
import com.andrey7mel.test_app.other.App;
import com.andrey7mel.test_app.view.Message;
import com.andrey7mel.test_app.view.View;

import javax.inject.Inject;

public class PresenterImpl implements Presenter {

    protected View view;

    @Inject
    Model model;

    public PresenterImpl() {
        App.getComponent().inject(this);
    }

    @Override
    public void clickEnter(String text) {
        view.showMessage(new Message(text, Message.TYPE.USER));
        model.getAnswer(text).subscribe(view::showMessage);
    }

    @Override
    public void onCreate(View view, Bundle state) {
        this.view = view;
    }

    @Override
    public void onStart() {
        model.getMessages().subscribe(view::showMessage);
    }

    @Override
    public void onStop() {

    }
}
