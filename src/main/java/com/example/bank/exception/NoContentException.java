package com.example.bank.exception;

public class NoContentException extends RuntimeException{
    public NoContentException(int id) {
        super(String.format("No content id = %d", id));
    }
}
