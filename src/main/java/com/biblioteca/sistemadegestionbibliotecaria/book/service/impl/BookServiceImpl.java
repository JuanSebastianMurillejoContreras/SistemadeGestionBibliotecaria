package com.biblioteca.sistemadegestionbibliotecaria.book.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.book.constants.BookErrorMessage;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import com.biblioteca.sistemadegestionbibliotecaria.book.exception.BookException;
import com.biblioteca.sistemadegestionbibliotecaria.book.mapper.IBookMapper;
import com.biblioteca.sistemadegestionbibliotecaria.book.repo.IBookRepo;
import com.biblioteca.sistemadegestionbibliotecaria.book.service.IBookService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final IBookRepo bookRepo;
    private final IBookMapper bookMapper;

    @Override
    public BookDTO addBook(BookCreateDTO bookCreateDTO) {

        List<String> errors = new ArrayList<>();

        if (bookRepo.existsByIsbn(bookCreateDTO.isbn()))
            errors.add(BookErrorMessage.BOOK_ISBN_ALREADY_REGISTERED + ": " + bookCreateDTO.isbn());

        if (bookRepo.existsByTitle(bookCreateDTO.title()))
            errors.add(BookErrorMessage.BOOK_NAME_ALREADY_REGISTERED + ": " + bookCreateDTO.title());

        if (!errors.isEmpty()) throw new BookException(String.join("; ", errors));

        BookEntity bookEntity = bookMapper.bookCreateDTOToBookEntity(bookCreateDTO);
        BookEntity saved = bookRepo.save(bookEntity);

        return bookMapper.bookEntityToBookDTO(saved);
    }

    @Override
    public List<BookDTO> getBooks() {
        List<BookEntity> bookEntity = bookRepo.findAll();
        return bookMapper.bookEntityListToBookDTOList(bookEntity);
    }

    @Override
    public List<BookDTO> getBookByLibrary(Long libraryId) {
        List<BookEntity> bookDTOList = bookRepo.findByLibraryId(libraryId);
        return bookMapper.bookEntityListToBookDTOList(bookDTOList);
    }

    @Override
    public List<BookDTO> getBookByAuthor(Long authorId) {
        List<BookEntity> bookEntityList = bookRepo.findByAuthorId(authorId);
        return bookMapper.bookEntityListToBookDTOList(bookEntityList);
    }

    @Override
    public List<BookDTO> searchBookByTitleOrAuthor(String search) {
        List<BookEntity> bookEntityList = bookRepo.findByTitleContainingIgnoreCaseOrAuthor_NameContainingIgnoreCase(search, search);
        return bookMapper.bookEntityListToBookDTOList(bookEntityList);
    }


}
