package com.example.clean_arquitecture.Clean.Arquitecture.config;

import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ModelExceptionMessage;
import com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<ModelExceptionMessage> ResourceNotFoundException(ResourceNotFoundException e) {
        ModelExceptionMessage message = new ModelExceptionMessage(e.getMessage(), e.hashCode());
        return new ResponseEntity<>(message, HttpStatusCode.valueOf(e.hashCode()));
    }

}
