package com.example.product_catalogue.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private String message;
    private String timestamp;
    private Map<String, String> errors; // For validation errors

    public ApiError(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}