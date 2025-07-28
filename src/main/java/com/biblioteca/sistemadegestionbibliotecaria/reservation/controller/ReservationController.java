package com.biblioteca.sistemadegestionbibliotecaria.reservation.controller;

import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationUpdateDTO;
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
@RequestMapping("api/v1/reservation")
public class ReservationController {

    private final IReservationService reservationService;
    private final IMapperReservation mapperReservation;

    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations(@PathVariable Long id) {
        List<ReservationDTO> reservationResponseDTO = reservationService.findReservationActiveByUsuario(id);
        List<ReservationResponseDTO> reservationResponseDTOS =
                mapperReservation.reservationDTOListToReservationResponseDTOList(reservationResponseDTO);
        return ResponseEntity.ok(reservationResponseDTOS);
    }

    @PutMapping("/cancel-reservation/{id}")
    public ResponseEntity<ReservationResponseDTO> updateLibro(@PathVariable Long id,
                                                        @RequestBody @Valid ReservationUpdateDTO reservationUpdateDTO) {

        ReservationDTO reservationUpdate = reservationService.updateReservation(id, reservationUpdateDTO);
        ReservationResponseDTO reservationResponseDTO = mapperReservation.ReservationDTOToReservationResponseDTO(reservationUpdate);

        return ResponseEntity.ok(reservationResponseDTO);
    }
}
