package com.biblioteca.sistemadegestionbibliotecaria.testContainers.domain.library;

import com.biblioteca.sistemadegestionbibliotecaria.testContainers.common.AbstractIntegrationTest;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.dto.input.LibraryRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.entity.LibraryEntity;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.repo.ILibraryRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryIntegrationTest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ILibraryRepo libraryRepo;

    @Test
    void debeCrearLibreriaExitosamente()  throws Exception {

        LibraryRequestDTO libraryRequestDTO = new LibraryRequestDTO("Alejandría","Grecia");

        given()
                .port(port)
                .contentType("application/json")
                .body(objectMapper.writeValueAsString(libraryRequestDTO))
                .when()
                .post("/api/v1/libraries")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("name", equalTo("Alejandría"));

        assertTrue(
                libraryRepo.existsByName("Alejandría"),
                "La librería debería existir en la base de datos"
        );
    }

    @Test
    void noDebePermitirLibreriasDuplicadas()  throws Exception {

        // Pre-cargar en DB
        libraryRepo.save(new LibraryEntity(null,"Alejandría","Grecia", new ArrayList<>()));

        LibraryRequestDTO libraryRequestDTO = new LibraryRequestDTO("Alejandría", "Grecia");

        given()
                .port(port)
                .contentType("application/json")
                .body(objectMapper.writeValueAsString(libraryRequestDTO))
                .when()
                .post("/api/v1/libraries")
                .then()
                .statusCode(HttpStatus.CONFLICT.value())
                .body("message", containsString("La biblioteca ya esta registrada en la base de datos: " + libraryRequestDTO.name()));
    }
}
