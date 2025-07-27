package com.biblioteca.sistemadegestionbibliotecaria.reservation.service.impl;

import com.biblioteca.sistemadegestionbibliotecaria.book.dto.input.BookDTO;
import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationUpdateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.entity.ReservationEntity;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.mapper.IMapperReservation;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.repo.IReservationRepo;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return null;
    }

    @Override
    public ReservationDTO updateReservation(ReservationUpdateDTO reservationUpdateDTO) {
        return null;
    }

    @Override
    public List<ReservationDTO> findReservationByUsuario(Long usuarioId) {
        List<ReservationEntity> bookEntityList = reservationRepo.findByUsuarioId(usuarioId);
        return reservationMapper.reservationEntityListToReservationDTOList(bookEntityList);
    }


}
