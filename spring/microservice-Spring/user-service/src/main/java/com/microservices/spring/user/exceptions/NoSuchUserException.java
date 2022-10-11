package com.microservices.spring.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NoSuchUserException extends RuntimeException {
    public NoSuchUserException() {
        super("No User with the given username exists in database...");
    }
}
