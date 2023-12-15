package com.example.ptmedia.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ptException{
    public NotFoundException() {
        super(HttpStatus.BAD_REQUEST, 102);
    }
}
