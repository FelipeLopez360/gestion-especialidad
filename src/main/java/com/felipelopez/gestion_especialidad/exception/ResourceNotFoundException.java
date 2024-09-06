package com.felipelopez.gestion_especialidad.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
