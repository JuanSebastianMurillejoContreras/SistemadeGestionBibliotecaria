package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.exception;

import lombok.Getter;

@Getter
public class BookNotFoundException extends BookException {
    public BookNotFoundException(String code, String message) {
        super(code, message);
    }
}