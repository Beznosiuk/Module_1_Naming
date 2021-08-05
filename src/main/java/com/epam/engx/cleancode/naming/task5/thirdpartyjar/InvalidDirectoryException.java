package com.epam.engx.cleancode.naming.task5.thirdpartyjar;

public class InvalidDirectoryException extends RuntimeException {
    String message;

    public InvalidDirectoryException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
