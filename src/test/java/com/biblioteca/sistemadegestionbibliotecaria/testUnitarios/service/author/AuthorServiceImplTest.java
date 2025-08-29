package com.biblioteca.sistemadegestionbibliotecaria.testUnitarios.service.author;


import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.author.mapper.IAuthorMapper;
import com.biblioteca.sistemadegestionbibliotecaria.author.repo.IAuthorRepo;
import com.biblioteca.sistemadegestionbibliotecaria.author.service.impl.AuthorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(MockitoExtension.class)
public class AuthorServiceImplTest {

    @InjectMocks
    private AuthorServiceImpl authorService;
    @Mock
    private IAuthorRepo authorRepo;
    @Spy
    private IAuthorMapper authorMapper = Mappers.getMapper(IAuthorMapper.class);

    @Test
    void givenAuthorRequestDTOWhenAddAuthorThenReturnAuthorResponseDTO() {
       //Given
        AuthorCreateDTO input = new AuthorCreateDTO("Gabriel García Márquez");

        //When
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName("Gabriel García Márquez");

        Mockito.when(authorRepo.save(authorEntity)).thenReturn(authorEntity);

        AuthorDTO outPutEsperado = new AuthorDTO("Gabriel García Márquez");
        AuthorDTO resultado = authorService.addAuthor(input);

        assertEquals(outPutEsperado, resultado);

    }

    @Test
    void givenAuthorRequestDTOWhenAddAuthorWithNullNameThenThrowException() {
        // given
        AuthorCreateDTO input = new AuthorCreateDTO(null);

        // then
        assertThrows(IllegalArgumentException.class, () -> authorService.addAuthor(input));
    }

    @Test
    void givenAuthorRequestDTOWhenAddAuthorWithEmptyNameThenThrowException() {
        // given
        AuthorCreateDTO input = new AuthorCreateDTO("");

        // then
        assertThrows(IllegalArgumentException.class, () -> authorService.addAuthor(input));
    }

}
