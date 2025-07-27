package com.biblioteca.sistemadegestionbibliotecaria.reservation.controller;

import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.out.ReservationResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.mapper.IMapperReservation;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.service.IReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reservation")
public class ReservationController {

    private final IReservationService reservationService;
    private final IMapperReservation mapperReservation;

    @GetMapping
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations() {
        List<ReservationDTO> reservationResponseDTO = reservationService.getReservations();
        List<ReservationResponseDTO> reservationResponseDTOS =
                mapperReservation.reservationDTOListToReservationResponseDTOList(reservationResponseDTO);
        return ResponseEntity.ok(reservationResponseDTOS);
    }

}
