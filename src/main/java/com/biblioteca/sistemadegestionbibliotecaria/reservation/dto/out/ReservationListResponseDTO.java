package com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.out;

import java.util.List;

public record ReservationListResponseDTO(
        List<ReservationResponseDTO> reservationResponseDTOS
) {}
