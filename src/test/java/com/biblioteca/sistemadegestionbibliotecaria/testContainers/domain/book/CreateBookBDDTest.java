package com.biblioteca.sistemadegestionbibliotecaria.testContainers.domain.book;

import com.biblioteca.sistemadegestionbibliotecaria.author.entity.AuthorEntity;
import com.biblioteca.sistemadegestionbibliotecaria.author.repo.IAuthorRepo;
import com.biblioteca.sistemadegestionbibliotecaria.book.repo.IBookRepo;
import com.biblioteca.sistemadegestionbibliotecaria.testContainers.common.AbstractIntegrationTest;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.entity.LibraryEntity;
import com.biblioteca.sistemadegestionbibliotecaria.libraries.repo.ILibraryRepo;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateBookBDDTest extends AbstractIntegrationTest {

    @Autowired
    private IAuthorRepo authorRepo;

    @Autowired
    private ILibraryRepo libraryRepo;

    @Autowired
    private IBookRepo bookRepo;

    @Test
    void registrarLibroConAutorYBibliotecaExistentes() {
        // Given: que el autor y la biblioteca ya existen en el sistema
        var author = authorRepo.save(
                new AuthorEntity(null, "Gabriel García Márquez", new ArrayList<>())
        );
        var library = libraryRepo.save(
                new LibraryEntity(null, "Biblioteca Nacional", "Colombia", new ArrayList<>())
        );

        // When: se envía una solicitud con el título del libro, ID del autor e ID de la biblioteca
        var requestBody = """
                {
                  "title": "Cien Años de Soledad",
                  "isbn": "9780307474728",
                  "authorId": %d,
                  "libraryId": %d
                }
                """.formatted(author.getId(), library.getId());


        given()
                .port(port)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/api/v1/books")
                // Then: el libro se registra correctamente
                .then()
                .statusCode(201)
                .body("title", equalTo("Cien Años de Soledad"))
                .body("isbn", equalTo("9780307474728"))
                .body("authorId", equalTo(author.getId().intValue()))
                .body("libraryId", equalTo(library.getId().intValue()));

        // And: se verifica que el libro existe en la base de datos
        assertTrue(
                bookRepo.existsByIsbn("9780307474728"),
                "El libro debería existir en la base de datos"
        );
    }
}