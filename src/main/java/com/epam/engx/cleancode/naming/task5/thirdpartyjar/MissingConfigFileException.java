package com.epam.engx.cleancode.naming.task5.thirdpartyjar;

public class MissingConfigFileException extends RuntimeException {

    final String message;

    public MissingConfigFileException(String message) {
        this.message = message;
    }

    public MissingConfigFileException(String message, Exception e) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
