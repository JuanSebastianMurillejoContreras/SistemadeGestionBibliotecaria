package com.biblioteca.sistemadegestionbibliotecaria.reservation.service.impl;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepo reservationRepo;
    private final IMapperReservation reservationMapper;


    @Override
    public ReservationDTO addReservation(ReservationCreateDTO reservationCreateDTO) {

        boolean existReservation = reservationRepo.existsByBook_IdAndIsActive(reservationCreateDTO.bookId(), true);

        if(existReservation)
            throw new LibraryException(ReservationErrorMessage.RESERVATION_EXIST_AND_IS_ACTIVE + ": ID Libro " + reservationCreateDTO.bookId());

        ReservationEntity reservationEntity = reservationMapper.ReservationCreateDTOToReservationEntity(reservationCreateDTO);
        ReservationEntity reservation = reservationRepo.save(reservationEntity);

        return reservationMapper.reservationEntityToReservationDTO(reservation);
    }

    @Override
    public ReservationDTO cancelReservation(Long id, ReservationUpdateDTO reservationUpdateDTO) {

        ReservationEntity reservationEntity = reservationRepo.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(
                        ReservationErrorMessage.RESERVATION_DOES_NOT_EXIST + ": " + id));

        if (Boolean.TRUE.equals(reservationUpdateDTO.isActive())) {
            throw new LibraryException("Solo se permite actualizar para cancelar la reserva (isActive debe ser false)");
        }

        reservationEntity.setIsActive(false);

        ReservationEntity reservation = reservationRepo.save(reservationEntity);
        return reservationMapper.reservationEntityToReservationDTO(reservation);
    }

    @Override
    public Page<ReservationDTO> findReservationActiveByUsuario(Long usuarioId, Pageable pageable) {
        Page<ReservationEntity> bookEntityPage = reservationRepo.findByIsActiveAndUsuario_Id(true, usuarioId, pageable);
        return bookEntityPage.map(reservationMapper::reservationEntityToReservationDTO);
    }
}