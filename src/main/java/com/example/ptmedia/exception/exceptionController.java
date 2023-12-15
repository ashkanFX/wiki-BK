package com.example.ptmedia.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class exceptionController {
    @ExceptionHandler(alreadyExsitException.class)
    @ResponseBody
    public ResponseEntity<Integer> handelPtException(HttpServletRequest request, ptException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getCode());
    }
}
