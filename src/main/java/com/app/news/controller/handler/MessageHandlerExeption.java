package com.app.news.controller.handler;

import com.app.news.controller.model.response.ErrorMessage;
import com.app.news.domain.exceptions.NotFoundedException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class MessageHandlerExeption {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ErrorMessage errorMessage = new ErrorMessage(getErrorMessageFieldValidation(e));
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(NotFoundedException.class)
    public ResponseEntity<ErrorMessage> NotFoundValidException(NotFoundedException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return ResponseEntity.badRequest().body(errorMessage);
    }

    private List<String> getErrorMessageFieldValidation(MethodArgumentNotValidException ex) {
        final List<String> errors = new ArrayList<>();
        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        return errors;
    }

}
