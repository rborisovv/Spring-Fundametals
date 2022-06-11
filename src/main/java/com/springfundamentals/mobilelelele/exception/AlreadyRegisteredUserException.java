package com.springfundamentals.mobilelelele.exception;

public class AlreadyRegisteredUserException extends Exception {
    public AlreadyRegisteredUserException() {
        super();
    }

    public AlreadyRegisteredUserException(String message) {
        super(message);
    }
}
