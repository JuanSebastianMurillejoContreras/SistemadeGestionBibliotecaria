package com.biblioteca.sistemadegestionbibliotecaria.domain.author;

import com.biblioteca.sistemadegestionbibliotecaria.common.AbstractIntegrationTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CreateAuthorBDDTest extends AbstractIntegrationTest {

    @Test
    void registrarAuthorConDatosValidos() {

        // Given que un administrador desea registrar un nuevo autor
        var requestBody = """
                {
                  "name": "Gabriel García Márquez"
                }
                """;

        //When proporciona el nombre y datos biográficos del autor
        var response =
                given()
                        .port(port)
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/api/v1/authors");

        //Then el autor se guarda correctamente
        //And recibe una confirmación con los datos del autor
        response.then()
                .statusCode(201)
                .body("name", equalTo("Gabriel García Márquez"));
        }
    }