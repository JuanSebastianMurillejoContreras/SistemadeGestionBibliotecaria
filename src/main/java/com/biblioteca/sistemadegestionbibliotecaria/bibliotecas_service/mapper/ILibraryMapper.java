package com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.mapper;

import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.input.LibraryCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.input.LibraryDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.input.LibraryRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.dto.out.LibraryResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.bibliotecas_service.entity.LibraryEntity;
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
