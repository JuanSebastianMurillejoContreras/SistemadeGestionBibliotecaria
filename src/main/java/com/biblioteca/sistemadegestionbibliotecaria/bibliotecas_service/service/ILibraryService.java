package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.service;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.input.LibraryCreateDTO;

public interface ILibraryService {

    LibraryCreateDTO createLibrary(LibraryCreateDTO libraryCreateDTO);

}
