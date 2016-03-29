package com.andrey7mel.test_app.view;

public class Message {

    private String text;

    private TYPE type;

    public enum TYPE {
        USER,
        BOT,
        SYSTEM
    }

    public Message(String text, TYPE type) {
        this.text = text;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public TYPE getType() {
        return type;
    }

}
