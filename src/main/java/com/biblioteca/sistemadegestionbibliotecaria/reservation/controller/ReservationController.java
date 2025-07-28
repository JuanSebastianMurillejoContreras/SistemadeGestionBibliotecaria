package com.biblioteca.sistemadegestionbibliotecaria.reservation.controller;

import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationRequestDTO;
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

    @GetMapping("/active-by-user/{id}")
    public ResponseEntity<List<ReservationResponseDTO>> getReservationsActiveByUser(@PathVariable Long id) {
        List<ReservationDTO> reservationResponseDTO = reservationService.findReservationActiveByUsuario(id);
        List<ReservationResponseDTO> reservationResponseDTOS =
                mapperReservation.reservationDTOListToReservationResponseDTOList(reservationResponseDTO);
        return ResponseEntity.ok(reservationResponseDTOS);
    }

    @PostMapping("/create")
    public ResponseEntity<ReservationResponseDTO> createReservation(@Valid @RequestBody ReservationRequestDTO reservationRequestDTO) {
        ReservationCreateDTO reservationDTO = mapperReservation.reservationRequestDTOToReservationCreateDTO(reservationRequestDTO);
        ReservationDTO reservationAdd = reservationService.addReservation(reservationDTO);
        ReservationResponseDTO reservationResponseDTO = mapperReservation.reservationDTOToReservationResponseDTO(reservationAdd);
        return ResponseEntity.ok(reservationResponseDTO);
    }



    @PutMapping("/cancel/{id}")
    public ResponseEntity<ReservationResponseDTO> updateLibro(@PathVariable Long id,
                                                        @RequestBody @Valid ReservationUpdateDTO reservationUpdateDTO) {

        ReservationDTO reservationUpdate = reservationService.updateReservation(id, reservationUpdateDTO);
        ReservationResponseDTO reservationResponseDTO = mapperReservation.reservationDTOToReservationResponseDTO(reservationUpdate);

        return ResponseEntity.ok(reservationResponseDTO);
    }
}
