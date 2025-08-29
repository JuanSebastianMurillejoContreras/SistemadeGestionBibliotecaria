package com.biblioteca.sistemadegestionbibliotecaria.testContainers.domain.author;

import com.biblioteca.sistemadegestionbibliotecaria.testContainers.common.AbstractIntegrationTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CreateAuthorBDDTest extends AbstractIntegrationTest {

    @Test
    void registrarAuthorConDatosValidos() {

        // Given que un administrador desea registrar un nuevo autor
        String requestBody = """
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

    @Test
    void registrarAuthorConDatosValidos2() {

        // Given que un administrador desea registrar un nuevo autor
        String requestBody = """
                {
                  "name": ""
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
        List<String> errores = new ArrayList<>();
        errores.add("name: El nombre del autor no puede estar vacío");

        response.then()
                .statusCode(400)
                .body("message", equalTo(errores));
    }

}