package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.service;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryDTO;

public interface ILibraryService {
    LibraryDTO createLibrary(LibraryCreateDTO libraryCreateDTO);
}
