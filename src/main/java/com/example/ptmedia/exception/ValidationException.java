package com.example.ptmedia.exception;

import lombok.Data;

@Data
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }

}
