package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.mapper;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.input.LibraryRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.dto.out.LibraryResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas.entity.LibraryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILibraryMapper {

    //DTO -> ENTITY
    LibraryEntity libraryEntityToLibraryCreateDTO(LibraryCreateDTO libraryCreateDTO);

    //ENTITY -> DTO
    LibraryCreateDTO libraryEntityToLibraryCreateDTO(LibraryEntity libraryEntity);

    // DTO -> DTO
    LibraryCreateDTO LibraryRequestDTOToLibraryCreateDTO(LibraryRequestDTO libraryRequestDTO);
    LibraryResponseDTO LibraryCreateDTOToLibraryResponseDTO(LibraryCreateDTO libraryCreateDTO);


}
