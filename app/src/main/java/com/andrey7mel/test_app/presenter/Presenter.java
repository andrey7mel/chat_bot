package com.andrey7mel.test_app.presenter;

import android.os.Bundle;
import android.view.View;

public interface Presenter {
    void clickEnter(String text);

    void onCreate(View view, Bundle state);

    void onStart();

    void onStop();
}
