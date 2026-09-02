package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ModelExceptionMessage> ResourceNotFoundException(ResourceNotFoundException e) {
        ModelExceptionMessage model = new ModelExceptionMessage(e.getMessage(), 404);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
    }
}
