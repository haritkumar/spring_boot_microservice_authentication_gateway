package com.gateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIExceptionHandler {
	
	 @ExceptionHandler(org.springframework.validation.BindException.class)
     public ResponseEntity<String> handleBindException(org.springframework.validation.BindException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
     }
}
