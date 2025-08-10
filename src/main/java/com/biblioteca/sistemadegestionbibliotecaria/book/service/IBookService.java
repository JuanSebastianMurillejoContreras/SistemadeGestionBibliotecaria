package com.biblioteca.sistemadegestionbibliotecaria.book.service;

import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookDTO;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.entity.LibraryEntity;

import java.util.List;

public interface IBookService {

    BookDTO addBook(BookCreateDTO bookCreateDTO);
    List<BookDTO> getBooks();
    List<BookDTO> getBookByLibraryOrAuthorOrTitle(Long libraryId, Long authorId, String title);


}