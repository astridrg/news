package com.app.news.controller.model.response;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private String message;
    private List<String> messages;

    public ErrorMessage(String message, List<String> messages) {
        this.message = message;
        this.messages = messages;
    }

    public ErrorMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(List<String> messages) {
        this.messages = messages;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
