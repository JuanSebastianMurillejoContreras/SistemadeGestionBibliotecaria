package com.biblioteca.sistemadegestionbibliotecaria.reservation.controller;

import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationUpdateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.out.ReservationListResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.out.ReservationResponseDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.mapper.IMapperReservation;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.service.IReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/reservations")
public class ReservationController {

    private final IReservationService reservationService;
    private final IMapperReservation mapperReservation;

    @GetMapping
    public ResponseEntity<ReservationListResponseDTO> getReservationsActiveByUser(@RequestParam Long userId) {
        List<ReservationDTO> reservationResponseDTO = reservationService.findReservationActiveByUsuario(userId);

        List<ReservationResponseDTO> reservationResponseDTOS =
                mapperReservation.reservationDTOListToReservationResponseDTOList(reservationResponseDTO);

        ReservationListResponseDTO reservationListResponseDTO = new ReservationListResponseDTO(reservationResponseDTOS);

        return ResponseEntity.ok(reservationListResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ReservationResponseDTO> createReservation(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO) {
        ReservationCreateDTO reservationDTO = mapperReservation.reservationRequestDTOToReservationCreateDTO(reservationRequestDTO);
        ReservationDTO reservationAdd = reservationService.addReservation(reservationDTO);
        ReservationResponseDTO reservationResponseDTO = mapperReservation.reservationDTOToReservationResponseDTO(reservationAdd);
        return ResponseEntity.ok(reservationResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> updateReservation(@PathVariable Long id,
                                                        @RequestBody @Valid ReservationUpdateDTO reservationUpdateDTO) {

        ReservationDTO reservationUpdate = reservationService.updateReservation(id, reservationUpdateDTO);
        ReservationResponseDTO reservationResponseDTO = mapperReservation.reservationDTOToReservationResponseDTO(reservationUpdate);

        return ResponseEntity.ok(reservationResponseDTO);
    }

    /*
    @PostMapping("/{id}/cancel")
    public ResponseEntity<ReservationResponseDTO> cancelReservation(@PathVariable Long id) {

        ReservationDTO reservationUpdate = reservationService.updateReservation(id);
        ReservationResponseDTO reservationResponseDTO = mapperReservation.reservationDTOToReservationResponseDTO(reservationUpdate);

        return ResponseEntity.ok(reservationResponseDTO);
    }*/

}