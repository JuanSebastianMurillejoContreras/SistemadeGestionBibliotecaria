package com.biblioteca.sistemadegestionbibliotecaria.author.exception;

import lombok.Getter;

@Getter
public class AuthorNotFoundException extends AuthorException {
    public AuthorNotFoundException(String code, String message) {
        super(code, message);
    }
}