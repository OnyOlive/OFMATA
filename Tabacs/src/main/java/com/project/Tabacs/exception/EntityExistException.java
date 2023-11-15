package com.project.Tabacs.exception;

public class EntityExistException extends RuntimeException{
    public EntityExistException(String message) {
        super(message);
    }
}
