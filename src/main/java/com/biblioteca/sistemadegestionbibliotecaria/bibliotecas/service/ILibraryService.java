package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.service;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryCreateDTO;

public interface ILibraryService {

    LibraryCreateDTO createLibrary(LibraryCreateDTO libraryCreateDTO);

}
