package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.service;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.out.BookResponseDTO;

public interface IBookService {

    BookCreateDTO addBook(BookCreateDTO bookCreateDTO);

}
