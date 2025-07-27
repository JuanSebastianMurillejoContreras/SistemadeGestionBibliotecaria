package com.biblioteca.sistemadegestionbibliotecaria.author.exception;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.out.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthorExeptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                .toList().toString();
        return new ErrorResponse(errors);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleAuthorNotFoundException(AuthorNotFoundException ex) {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(AuthorException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleAuthorException(AuthorException ex) {
        return new ErrorResponse(ex.getMessage());
    }

}