package com.biblioteca.sistemadegestionbibliotecaria.reservation.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.libraries.constants.LibraryErrorMessage;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.exception.LibraryException;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.constants.ReservationErrorMessage;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationUpdateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.entity.ReservationEntity;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.exception.ReservationNotFoundException;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.mapper.IMapperReservation;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.repo.IReservationRepo;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepo reservationRepo;
    private final IMapperReservation reservationMapper;


    @Override
    public List<ReservationDTO> getReservations() {
        List<ReservationEntity> reservationDTOList = reservationRepo.findAll();
        return reservationMapper.reservationEntityListToReservationDTOList(reservationDTOList);
    }

    @Override
    public ReservationDTO addReservation(ReservationCreateDTO reservationCreateDTO) {

        if(reservationRepo.existsByBook_IdAndIsActive(reservationCreateDTO.bookId(), true))
            throw new LibraryException(ReservationErrorMessage.RESERVATION_EXIST_AND_IS_ACTIVE + ": " + reservationCreateDTO.bookId());

        ReservationEntity reservationEntity = reservationMapper.ReservationCreateDTOToReservationEntity(reservationCreateDTO);
        ReservationEntity reservation = reservationRepo.save(reservationEntity);
        return reservationMapper.reservationEntityToReservationDTO(reservation);
    }

    @Override
    public ReservationDTO updateReservation(Long id, ReservationUpdateDTO reservationUpdateDTO) {

        ReservationEntity reservationEntity = reservationRepo.findById(id).orElseThrow(() -> new ReservationNotFoundException(
                ReservationErrorMessage.RESERVATION_DOES_NOT_EXIST + ": " + id));

            reservationMapper.updateReservationEntityFromDTO(reservationUpdateDTO, reservationEntity);
            ReservationEntity reservation = reservationRepo.save(reservationEntity);
        return reservationMapper.reservationEntityToReservationDTO(reservation);
    }

    @Override
    public List<ReservationDTO> findReservationActiveByUsuario(Long usuarioId) {
        List<ReservationEntity> bookEntityList = reservationRepo.findByIsActiveAndUsuario_Id(true, usuarioId);
        return reservationMapper.reservationEntityListToReservationDTOList(bookEntityList);
    }



}
