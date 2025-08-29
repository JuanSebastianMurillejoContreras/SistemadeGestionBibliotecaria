package com.biblioteca.sistemadegestionbibliotecaria.testUnitarios.service.book;

import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import com.biblioteca.sistemadegestionbibliotecaria.book.mapper.IBookMapper;
import com.biblioteca.sistemadegestionbibliotecaria.book.repo.IBookRepo;
import com.biblioteca.sistemadegestionbibliotecaria.book.service.impl.BookServiceImpl;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.entity.LibraryEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;
    @Mock
    private IBookRepo bookRepo;
    @Spy
    private IBookMapper bookMapper = Mappers.getMapper(IBookMapper.class);

    @Test
    void givenBookRequestDTOWhenAddBookThenReturnBookResponseDTO() {
        //given:
        BookCreateDTO input = new BookCreateDTO("Libro","9780306406157",1L,1L);

        //when:
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(1L);

        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setId(1L);

        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle("Libro");
        bookEntity.setIsbn("9780306406157");
        bookEntity.setAuthor(authorEntity);
        bookEntity.setLibrary(libraryEntity);

        Mockito.when(bookRepo.save(bookEntity)).thenReturn(bookEntity);

        BookDTO outPutEsperado = new BookDTO("Libro","9780306406157",1L,1L);

        BookDTO resultado = bookService.addBook(input);

        //then:
        assertEquals(outPutEsperado, resultado);

    }

    @Test
    void givenBookRequestDTOWhenAddBookThenReturnBookResponseDTO2() {
        //given:
        BookCreateDTO input = new BookCreateDTO("Libro2","9780306406157",1L,1L);
        //when:

        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(1L);

        LibraryEntity libraryEntity = new LibraryEntity();
        libraryEntity.setId(1L);

        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle("Libro2");
        bookEntity.setIsbn("9780306406157");
        bookEntity.setAuthor(authorEntity);
        bookEntity.setLibrary(libraryEntity);

        Mockito.when(bookRepo.save(Mockito.any())).thenReturn(bookEntity);
        BookDTO outPutEsperado = new BookDTO("Libro2","9780306406157",1L,1L);

        BookDTO resultado = bookService.addBook(input);
        //then:
        assertEquals(outPutEsperado, resultado);
    }


    @Test
    void givenBookRequestDTOWhenAddBookWithNUllISBNThenReturnBookResponseDTO3() {
        //given:
        BookCreateDTO input = new BookCreateDTO("Libro2",null,1L,1L);

        assertThrows(IllegalArgumentException.class, () -> bookService.addBook(input));

    }

    @Test
    void givenBookRequestDTOWhenAddBookWithEmptyISBNThenReturnBookResponseDTO3() {
        //given:
        BookCreateDTO input = new BookCreateDTO("Libro2","",1L,1L);

        assertThrows(IllegalArgumentException.class, () -> bookService.addBook(input));

    }

    @Test
    void givenBookRequestDTOWhenAddBookWithRandomCaracterISBNThenReturnBookResponseDTO3() {
        //given:
        BookCreateDTO input = new BookCreateDTO("Libro2","12sgh2",1L,1L);

        assertThrows(IllegalArgumentException.class, () -> bookService.addBook(input));

    }

}