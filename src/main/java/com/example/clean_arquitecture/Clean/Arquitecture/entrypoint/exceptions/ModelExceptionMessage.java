package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.exceptions;

public class ModelExceptionMessage {

    private String message;
    private Integer statusCode;

    public ModelExceptionMessage(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

}
