package com.example.ptmedia.exception.message;

import lombok.Data;

@Data
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }

}
