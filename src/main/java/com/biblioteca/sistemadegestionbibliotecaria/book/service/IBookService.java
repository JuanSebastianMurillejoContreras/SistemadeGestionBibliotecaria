package com.biblioteca.sistemadegestionbibliotecaria.book.service;

import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;

public interface IBookService {

    BookCreateDTO addBook(BookCreateDTO bookCreateDTO);

}
