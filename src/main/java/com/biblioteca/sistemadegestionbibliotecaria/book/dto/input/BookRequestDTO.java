package com.biblioteca.sistemadegestionbibliotecaria.book.dto.input;

public record BookRequestDTO(
        String title,
        String isbn,
        Long authorId,
        Long libraryId
) {}
