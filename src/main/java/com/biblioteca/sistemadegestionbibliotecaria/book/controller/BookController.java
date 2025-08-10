package com.biblioteca.sistemadegestionbibliotecaria.book.controller;

import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.out.BookListResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.out.BookResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.mapper.IBookMapper;
import com.biblioteca.sistemadegestionbibliotecaria.book.service.IBookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final IBookService bookService;
    private final IBookMapper bookMapper;

    @PostMapping
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody @Valid BookRequestDTO bookRequestDTO){
        BookCreateDTO bookCreateDTO = bookMapper.bookRequestDTOToBookCreateDTO(bookRequestDTO);
        BookDTO bookDTO = bookService.addBook(bookCreateDTO);
        BookResponseDTO bookResponseDTO = bookMapper.bookDTOToBookResponseDTO(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponseDTO);
    }

    @GetMapping
    public ResponseEntity<BookListResponseDTO> getBookByLibraryOrAuthorOrTitle(@RequestParam(required = false) Long libraryId,
                                                                               @RequestParam(required = false) Long authorId,
                                                                               @RequestParam(required = false) String title) {
        List<BookDTO> bookDTOList = bookService.getBookByLibraryOrAuthorOrTitle(libraryId, authorId, title);
        List<BookResponseDTO> bookResponseDTOS = bookMapper.bookDTOToBookResponseListDTO(bookDTOList);

        BookListResponseDTO bookListResponseDTO = new  BookListResponseDTO(bookResponseDTOS);

        return ResponseEntity.status(HttpStatus.OK).body(bookListResponseDTO);
    }


}
