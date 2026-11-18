package com.example.library.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long id) {
        super("Book with ID " + id + " was not found.");
    }
}
