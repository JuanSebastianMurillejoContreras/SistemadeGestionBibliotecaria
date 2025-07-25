package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.out;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.input.LibraryDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.AuthorDTO;

public record BookResponseDTO(
        String title,
        String isbn,
        AuthorDTO author,
        LibraryDTO library

) {
}
