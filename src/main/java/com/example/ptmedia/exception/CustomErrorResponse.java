package com.example.ptmedia.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomErrorResponse {
    private String errorMessage;
    private int statusCode;
    private long timestamp;
    // Constructors, getters, and setters
}
