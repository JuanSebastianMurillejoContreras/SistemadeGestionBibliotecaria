package com.biblioteca.sistemadegestionbibliotecaria.domain.author;

import com.biblioteca.sistemadegestionbibliotecaria.author.dto.input.AuthorRequestDTO;
import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.author.repo.IAuthorRepo;
import com.biblioteca.sistemadegestionbibliotecaria.common.AbstractIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

class AuthorIntegrationTest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IAuthorRepo authorRepo;

    @Test
    void debeCrearAutorExitosamente() throws Exception {
        AuthorRequestDTO request = new AuthorRequestDTO("Gabriel García Márquez");

        given()
                .port(port)
                .contentType("application/json")
                .body(objectMapper.writeValueAsString(request))
                .when()
                .post("/api/v1/authors")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("name", equalTo("Gabriel García Márquez"));

        // Verificar en DB
        boolean existe = authorRepo.existsByName("Gabriel García Márquez");
        org.junit.jupiter.api.Assertions.assertTrue(existe);
    }

    @Test
    void noDebePermitirAutoresDuplicados() throws Exception {
        // Pre-cargar en DB
        authorRepo.save(new AuthorEntity(null, "Borges", null));

        AuthorRequestDTO request = new AuthorRequestDTO("Borges");

        given()
                .port(port)
                .contentType("application/json")
                .body(objectMapper.writeValueAsString(request))
                .when()
                .post("/api/v1/authors")
                .then()
                .statusCode(HttpStatus.CONFLICT.value()) // o el código que se use en AuthorException
                .body("message", containsString("El autor ya está registrado en la base de datos: " + request.name()));
    }
}