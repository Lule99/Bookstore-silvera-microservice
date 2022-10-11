package com.microservices.spring.sci.paper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoSuchSciPaperException extends RuntimeException{
    public NoSuchSciPaperException() {
        super("SciPaper with the given id doesnt exist");
    }
}
