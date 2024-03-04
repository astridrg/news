package com.app.news.domain.exceptions;

public class NotFoundedException extends RuntimeException {

    public NotFoundedException(String message) {
        super(message);
    }
}
