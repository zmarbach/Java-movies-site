package com.improving.bootcamp.movies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//playing around with the concept of throwing custom exceptions
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public class  MovieDoesNotExistException extends RuntimeException{
        public MovieDoesNotExistException() {
            super("Movie does not exist");
        }
    }

