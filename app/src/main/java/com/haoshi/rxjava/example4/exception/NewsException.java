package com.haoshi.rxjava.example4.exception;

/**
 * @author HaoShi
 */

public class NewsException extends Exception {
    public NewsException() {
        super();
    }

    public NewsException(String message) {
        super(message);
    }

    public NewsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsException(Throwable cause) {
        super(cause);
    }

}
