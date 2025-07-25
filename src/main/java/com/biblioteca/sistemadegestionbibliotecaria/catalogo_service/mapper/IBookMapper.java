package com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.mapper;

import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.BookCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.input.BookRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.dto.out.BookResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.catalogo_service.entity.BookEntity;
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
    BookCreateDTO bookEntityToBookCreateDTO(BookEntity bookEntity);
}
