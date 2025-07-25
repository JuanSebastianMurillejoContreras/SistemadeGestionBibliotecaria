package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.controller;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.BookRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.out.BookResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.mapper.IBookMapper;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    private final IBookService bookService;
    private final IBookMapper bookMapper;

    @PostMapping
    public ResponseEntity<BookResponseDTO> addBook(@RequestBody BookRequestDTO bookRequestDTO){

        BookCreateDTO bookCreateDTO = bookMapper.bookRequestDTOToBookCreateDTO(bookRequestDTO);
        BookCreateDTO addBookCreateDTO = bookService.addBook(bookCreateDTO);
        BookResponseDTO bookResponseDTO = bookMapper.bookCreateDTOToBookResponseDTO(addBookCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(bookResponseDTO);
    }

}
