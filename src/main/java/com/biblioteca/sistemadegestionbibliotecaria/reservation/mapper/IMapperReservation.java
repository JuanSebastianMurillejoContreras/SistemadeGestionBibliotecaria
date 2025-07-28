package com.biblioteca.sistemadegestionbibliotecaria.reservation.mapper;

import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationUpdateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.out.ReservationResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.entity.ReservationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
@Mapper(componentModel = "spring")
public interface IMapperReservation {

    // Entity -> DTO


    // Entity -> DTO
    ReservationEntity ReservationUpdateDTOToReservationEntity(ReservationUpdateDTO reservationUpdateDTO);
    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "book.id", target = "bookId")
    List<ReservationDTO> reservationEntityListToReservationDTOList(List<ReservationEntity> reservationEntities);
    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "bookId", target = "book.id")
    List<ReservationEntity> ReservationDTOListToReservationEntityList(List<ReservationDTO> reservationEntities);

    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "book.id", target = "bookId")
    ReservationDTO reservationEntityToReservationDTO(ReservationEntity reservationEntity);

    // DTO -> DTO
    List<ReservationResponseDTO> reservationDTOListToReservationResponseDTOList(List<ReservationDTO> reservationDTOs);
    ReservationDTO ReservationUpdateDTOToReservationDTO(ReservationUpdateDTO reservationUpdateDTO);
    ReservationResponseDTO ReservationDTOToReservationResponseDTO(ReservationDTO reservationUpdateDTO);

    // Métodos especiales
    void updateReservationEntityFromDTO(ReservationUpdateDTO dto, @MappingTarget ReservationEntity entity);
}
