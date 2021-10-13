package com.epam.task02.exception;

public class CubeException extends Exception{
    public CubeException() {
    }

    public CubeException(String message) {
        super(message);
    }

    public CubeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CubeException(Throwable cause) {
        super(cause);
    }
}
