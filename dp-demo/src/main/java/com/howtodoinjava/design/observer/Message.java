package com.howtodoinjava.design.observer;

public class Message {

    final String messageContent;

    public Message (String m) {
        this.messageContent = m;
    }

    public String getMessageContent() {
        return messageContent;
    }
}
