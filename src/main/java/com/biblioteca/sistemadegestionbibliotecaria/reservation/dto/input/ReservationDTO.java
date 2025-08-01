package com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input;

import java.time.LocalDateTime;

public record ReservationDTO(
        Long usuarioId,
        Long bookId,
        LocalDateTime dateReservation,
        Boolean isActive
) {}
