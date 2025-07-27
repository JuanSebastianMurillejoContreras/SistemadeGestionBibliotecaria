package com.biblioteca.sistemadegestionbibliotecaria.reservation.mapper;

import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.out.ReservationResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface IMapperReservation {

    // Entity -> DTO
    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "book.id", target = "bookId")
    ReservationDTO reservationEntityToReservationDTO(ReservationEntity entity);

    // Entity -> DTO
    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "book.id", target = "bookId")
    List<ReservationDTO> reservationEntityListToReservationDTOList(List<ReservationEntity> reservationEntities);
    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "bookId", target = "book.id")
    List<ReservationEntity> ReservationDTOListToReservationEntityList(List<ReservationDTO> reservationEntities);

    // DTO -> DTO
    List<ReservationResponseDTO> reservationDTOListToReservationResponseDTOList(List<ReservationDTO> reservationDTOs);

}
