package com.biblioteca.sistemadegestionbibliotecaria.book.service;

import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookDTO;

public interface IBookService {

    BookDTO addBook(BookCreateDTO bookCreateDTO);

}
