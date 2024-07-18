package com.example.ptmedia.exception;

import com.example.ptmedia.exception.message.AlreadyExistsException;
import com.example.ptmedia.exception.message.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.badRequest().body(customErrorResponse);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> handleAlreadyExistsException(AlreadyExistsException e) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.badRequest().body(customErrorResponse);
    }


    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationٍException (ValidationException e) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(customErrorResponse);
    }
}

