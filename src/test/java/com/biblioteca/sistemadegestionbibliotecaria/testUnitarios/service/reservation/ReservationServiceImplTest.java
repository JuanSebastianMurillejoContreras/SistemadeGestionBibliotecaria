package com.biblioteca.sistemadegestionbibliotecaria.testUnitarios.service.reservation;

import com.biblioteca.sistemadegestionbibliotecaria.book.entity.BookEntity;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.mapper.ILibraryMapper;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.repo.ILibraryRepo;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.service.impl.LibraryServiceImpl;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationCreateDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.dto.input.ReservationDTO;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.entity.ReservationEntity;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.mapper.IMapperReservation;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.repo.IReservationRepo;
import com.biblioteca.sistemadegestionbibliotecaria.reservation.service.impl.ReservationServiceImpl;
import com.biblioteca.sistemadegestionbibliotecaria.usuario.entity.UsuarioEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceImplTest {

    @InjectMocks
    private ReservationServiceImpl reservationService;
    @Mock
    private IReservationRepo reservationRepo;
    @Spy
    private IMapperReservation reservationMapper = Mappers.getMapper(IMapperReservation.class);

    @Test
    void givenReservationRequestDTOWhenAddReservationThenReturnReservationResponseDTO() {
        //Given
        ReservationCreateDTO input = new ReservationCreateDTO(1L,1L, true);

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setId(1L);

        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(1L);

        //When
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setId(1L);
        reservationEntity.setUsuario(usuarioEntity);
        reservationEntity.setBook(bookEntity);
        reservationEntity.setIsActive(true);

        // When
        Mockito.when(reservationRepo.save(Mockito.any(ReservationEntity.class))).thenReturn(reservationEntity);

        ReservationDTO outputEsperado = new ReservationDTO(1L,1L,true);
        ReservationDTO resultadoEsperado = reservationService.addReservation(input);

        //Then
        assertEquals(outputEsperado, resultadoEsperado);
    }

}
