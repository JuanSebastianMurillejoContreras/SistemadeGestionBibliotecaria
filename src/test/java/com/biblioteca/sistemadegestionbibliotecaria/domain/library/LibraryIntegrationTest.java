package com.biblioteca.sistemadegestionbibliotecaria.domain.library;

import com.biblioteca.sistemadegestionbibliotecaria.author.repo.IAuthorRepo;
import com.biblioteca.sistemadegestionbibliotecaria.common.AbstractIntegrationTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;

public class LibraryIntegrationTest extends AbstractIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IAuthorRepo authorRepo;




}
