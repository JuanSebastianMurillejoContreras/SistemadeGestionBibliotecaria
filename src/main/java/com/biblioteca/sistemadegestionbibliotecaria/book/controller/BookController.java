package com.biblioteca.sistemadegestionbibliotecaria.book.controller;

import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.out.BookResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.mapper.IBookMapper;
import com.biblioteca.sistemadegestionbibliotecaria.book.service.IBookService;
import jakarta.servlet.ServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
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
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        List<BookDTO> bookDTOList = bookService.getBooks();
        List<BookResponseDTO> bookResponseDTOS = bookMapper.bookDTOToBookResponseListDTO(bookDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDTOS);
    }

    @GetMapping("/by-library/{id}")
    public ResponseEntity<List<BookResponseDTO>> getAllBooksByLibrary(@PathVariable Long id){
        List<BookDTO> bookDTOList = bookService.getBookByLibrary(id);
        List<BookResponseDTO> bookResponseDTOS = bookMapper.bookDTOToBookResponseListDTO(bookDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDTOS);
    }

    @GetMapping("/by-author/{id}")
    public ResponseEntity<List<BookResponseDTO>> getAllBooksByAuthor(@PathVariable Long id){
        List<BookDTO> bookDTOList = bookService.getBookByAuthor(id);
        List<BookResponseDTO> bookResponseDTOList = bookMapper.bookDTOToBookResponseListDTO(bookDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDTOList);
    }

    @GetMapping("/search/{search}")
    public ResponseEntity<List<BookResponseDTO>> getBookByTitleOrAuthor(@PathVariable String search){
        List<BookDTO> bookDTOList = bookService.searchBookByTitleOrAuthor(search);
        List<BookResponseDTO> bookResponseDTOList = bookMapper.bookDTOToBookResponseListDTO(bookDTOList);
        return ResponseEntity.status(HttpStatus.OK).body(bookResponseDTOList);
    }


}
