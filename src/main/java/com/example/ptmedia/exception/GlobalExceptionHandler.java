package com.example.ptmedia.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), 401);
        return ResponseEntity.badRequest().body(customErrorResponse);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> handleAlreadyExistsException(AlreadyExistsException e) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), 403);
        return ResponseEntity.badRequest().body(customErrorResponse);
    }


    @ExceptionHandler(ValidationٍException.class)
    public ResponseEntity<?> handleValidationٍException (ValidationٍException e) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), 400);
        return ResponseEntity.badRequest().body(customErrorResponse);
    }
}

