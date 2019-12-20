package com.improving.bootcamp.movies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {

    //messing around with error handler concept
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(MovieDoesNotExistException.class)
    public String exceptionHandler(Exception e) {
        return e.getMessage();
    }
}
