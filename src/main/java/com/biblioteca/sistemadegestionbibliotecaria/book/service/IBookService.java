package com.biblioteca.sistemadegestionbibliotecaria.book.service;

import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookDTO;

import java.util.List;

public interface IBookService {

    BookDTO addBook(BookCreateDTO bookCreateDTO);
    List<BookDTO> getBooks();
    List<BookDTO> getBookByLibrary(Long libraryId);
    List<BookDTO> getBookByAuthor(Long authorId);
    List<BookDTO> searchBookByTitleOrAuthor(String search);
}
