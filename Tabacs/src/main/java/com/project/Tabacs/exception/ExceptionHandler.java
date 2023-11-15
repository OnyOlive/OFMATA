package com.project.Tabacs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<ErrorResponse> entityNotFoundHandler (EntityNotFound entityNotFound) {
        var error = ErrorResponse.builder()
                .message(entityNotFound.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .code(HttpStatus.NOT_FOUND.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EntityExistException.class)
    public ResponseEntity<ErrorResponse> entityExistHandler (EntityExistException entityExistException) {
        var error = ErrorResponse.builder()
                .message(entityExistException.getMessage())
                .status(HttpStatus.NOT_ACCEPTABLE)
                .code(HttpStatus.NOT_ACCEPTABLE.value())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
    }
}
