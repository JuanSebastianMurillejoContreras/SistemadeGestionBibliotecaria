package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.entity.BookEntity;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.exception.BookException;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.exception.BookNotFoundException;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.mapper.IBookMapper;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.repo.IBookRepo;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final IBookRepo bookRepo;
    private final IBookMapper bookMapper;


    @Value("${properties.messages.error.book-does-not-exist}")
    public String bookDoesntExistError;

    @Value("${properties.messages.error.name-book-exist}")
    public String bookNameExistError;

    @Value("${properties.messages.error.isbn-book-exist}")
    public String bookISBNExistError;

    @Override
    public BookCreateDTO addBook(BookCreateDTO bookCreateDTO) {

        if (bookRepo.existsByTitle(bookCreateDTO.title())) {
            throw new BookException(
                    String.valueOf(HttpStatus.CONFLICT.value()),
                    bookNameExistError + ": " + bookCreateDTO.title());
        }

        if (bookRepo.existsByIsbn(bookCreateDTO.isbn())) {
            throw new BookException(
                    String.valueOf(HttpStatus.CONFLICT.value()),
                    bookISBNExistError + ": " + bookCreateDTO.isbn());
        }

        BookEntity bookEntity = bookMapper.bookCreateDTOToBookEntity(bookCreateDTO);
        BookEntity saved = bookRepo.save(bookEntity);

        BookEntity fullEntity = bookRepo.findByIdWithAuthorAndLibrary(saved.getId())
                .orElseThrow(() -> new BookNotFoundException(
                        String.valueOf(HttpStatus.NOT_FOUND.value()), bookDoesntExistError));

        return bookMapper.bookEntityToBookCreateDTO(fullEntity);
    }



}
