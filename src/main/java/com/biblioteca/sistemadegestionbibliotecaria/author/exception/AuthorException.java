package com.biblioteca.sistemadegestionbibliotecaria.author.exception;


import lombok.Getter;

@Getter
public class AuthorException extends RuntimeException  {

    public AuthorException(String message) {
        super(message);
    }
}