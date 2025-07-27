package com.biblioteca.sistemadegestionbibliotecaria.reservation.service;

import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationUpdateDTO;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface IReservationService {

    List<ReservationDTO> getReservations();
    ReservationDTO addReservation(ReservationCreateDTO reservationCreateDTO);
    ReservationDTO updateReservation(ReservationUpdateDTO reservationUpdateDTO);


}
