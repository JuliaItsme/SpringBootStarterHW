package ru.goryacheva.springbootstarterhw.exception;

public class LogRequestException extends RuntimeException {

    public LogRequestException() {
    }

    public LogRequestException(String message) {
        super(message);
    }
}
