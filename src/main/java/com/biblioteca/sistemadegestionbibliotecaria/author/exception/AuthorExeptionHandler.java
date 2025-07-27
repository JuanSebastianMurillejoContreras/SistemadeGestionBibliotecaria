package com.biblioteca.sistemadegestionbibliotecaria.author.exception;


import com.biblioteca.sistemadegestionbibliotecaria.author.dto.out.AuthorErrorResponse;
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
    public AuthorErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> ((FieldError) error).getField() + ": " + error.getDefaultMessage())
                .toList().toString();
        return new AuthorErrorResponse(errors);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AuthorErrorResponse handleAuthorNotFoundException(AuthorNotFoundException ex) {
        return new AuthorErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(AuthorException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public AuthorErrorResponse handleAuthorException(AuthorException ex) {
        return new AuthorErrorResponse(ex.getMessage());
    }

}