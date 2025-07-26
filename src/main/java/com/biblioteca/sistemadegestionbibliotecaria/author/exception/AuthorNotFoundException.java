package com.biblioteca.sistemadegestionbibliotecaria.author.exception;

import lombok.Getter;

@Getter
public class AuthorNotFoundException extends AuthorException {
    public AuthorNotFoundException(String message) {
        super(message);
    }
}