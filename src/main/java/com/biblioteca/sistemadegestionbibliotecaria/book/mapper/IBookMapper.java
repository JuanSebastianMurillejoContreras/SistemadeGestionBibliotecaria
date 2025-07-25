package com.biblioteca.sistemadegestionbibliotecaria.book.mapper;

import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.dto.out.BookResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IBookMapper {

    // DTO -> DTO
    BookCreateDTO bookRequestDTOToBookCreateDTO(BookRequestDTO bookRequestDTO);
    BookResponseDTO bookCreateDTOToBookResponseDTO(BookCreateDTO bookCreateDTO);

    // DTO -> Entity
    @Mapping(source = "authorId", target = "author.id")
    @Mapping(source = "libraryId", target = "library.id")
    BookEntity bookCreateDTOToBookEntity(BookCreateDTO bookCreateDTO);


    // Entity -> DTO
    BookResponseDTO bookEntityToBookResposeDTO(BookEntity bookEntity);

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "library.id", target = "libraryId")
    BookCreateDTO bookEntityToBookCreateDTO(BookEntity bookEntity);
}
