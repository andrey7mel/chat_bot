package com.andrey7mel.test_app.view;

import java.util.List;

public interface View {
    void showMessage(Message message);

    void showHistory(List<Message> list);
}
