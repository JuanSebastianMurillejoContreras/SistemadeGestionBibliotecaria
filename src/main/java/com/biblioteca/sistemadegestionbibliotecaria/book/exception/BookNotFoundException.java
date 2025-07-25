package com.biblioteca.sistemadegestionbibliotecaria.book.exception;

import lombok.Getter;

@Getter
public class BookNotFoundException extends BookException {
    public BookNotFoundException(String code, String message) {
        super(code, message);
    }
}