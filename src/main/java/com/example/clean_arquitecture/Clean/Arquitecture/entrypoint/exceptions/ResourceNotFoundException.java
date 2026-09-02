package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
