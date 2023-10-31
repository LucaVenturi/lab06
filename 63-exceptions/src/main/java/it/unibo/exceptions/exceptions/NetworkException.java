package it.unibo.exceptions.exceptions;

import java.io.IOException;

public class NetworkException extends IOException {

    private final String message;

    public NetworkException() {
        this.message = "Network error: no response";
    }

    public NetworkException(final String message) {
        this.message = "Network error while sending message: " + message;
    }

    public String getMessage() {
        return this.message;
    }
}
