package com.example.ptmedia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public class ptException extends RuntimeException{
    private final HttpStatus status ;
    private final Integer code;
}
