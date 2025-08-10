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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

        boolean existsByIsbn = bookRepo.existsByIsbn(bookCreateDTO.isbn());
        boolean existsByTitle = bookRepo.existsByTitle(bookCreateDTO.title());

        if (existsByIsbn)
            errors.add(BookErrorMessage.BOOK_ISBN_ALREADY_REGISTERED + ": " + bookCreateDTO.isbn());
        if (existsByTitle)
            errors.add(BookErrorMessage.BOOK_NAME_ALREADY_REGISTERED + ": " + bookCreateDTO.title());

        if (!errors.isEmpty()) throw new BookException(String.join("; ", errors));

        BookEntity bookEntity = bookMapper.bookCreateDTOToBookEntity(bookCreateDTO);
        BookEntity saved = bookRepo.save(bookEntity);

        return bookMapper.bookEntityToBookDTO(saved);
    }

    @Override
    public Page<BookDTO> getBookByLibraryOrAuthorOrTitle(Long libraryId, Long authorId, String title, Pageable pageable) {
        Page<BookEntity> bookEntityPage = bookRepo.searchBooks(libraryId, authorId, title, pageable);
        return bookEntityPage.map(bookMapper::bookEntityToBookDTO);
    }

}
