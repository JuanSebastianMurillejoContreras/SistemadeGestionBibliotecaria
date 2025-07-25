package com.biblioteca.sistemadegestionbibliotecaria.book.dto.input;

import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryDTO;

public record BookDTO(
        String title,
        String isbn,
        AuthorDTO author,
        LibraryDTO library
) {}
