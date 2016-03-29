package com.andrey7mel.test_app.presenter;

import android.os.Bundle;
import android.view.View;

import com.andrey7mel.test_app.model.Model;
import com.andrey7mel.test_app.other.App;

import javax.inject.Inject;

public class PresenterImpl implements Presenter {

    private View view;

    @Inject
    Model model;

    public PresenterImpl() {
        App.getComponent().inject(this);
    }

    @Override
    public void clickEnter(String text) {

    }

    @Override
    public void onCreate(View view, Bundle state) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
