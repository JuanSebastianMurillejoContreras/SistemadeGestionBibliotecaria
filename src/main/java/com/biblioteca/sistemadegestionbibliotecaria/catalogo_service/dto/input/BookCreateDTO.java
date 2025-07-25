package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input;

public record BookCreateDTO(
        String title,
        String isbn,
        Long authorId,
        Long libraryId
) {}
