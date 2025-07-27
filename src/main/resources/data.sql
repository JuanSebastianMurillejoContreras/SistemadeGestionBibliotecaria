-- Insertar libraries
INSERT INTO tb_biblioteca (name, address) VALUES ('Biblioteca Central', 'Calle 123');
INSERT INTO tb_biblioteca (name, address) VALUES ('Biblioteca Norte', 'Carrera 45');
INSERT INTO tb_biblioteca (name, address) VALUES ('Biblioteca Sur', 'Avenida 89');

-- Insertar autores
INSERT INTO tb_autor (name) VALUES ('Gabriel García Márquez');
INSERT INTO tb_autor (name) VALUES ('Jorge Luis Borges');
INSERT INTO tb_autor (name) VALUES ('Isabel Allende');
INSERT INTO tb_autor (name) VALUES ('Mario Vargas Llosa');
INSERT INTO tb_autor (name) VALUES ('Julio Cortázar');
INSERT INTO tb_autor (name) VALUES ('Laura Esquivel');
INSERT INTO tb_autor (name) VALUES ('Carlos Ruiz Zafón');
INSERT INTO tb_autor (name) VALUES ('Pablo Neruda');
INSERT INTO tb_autor (name) VALUES ('Miguel de Cervantes');
INSERT INTO tb_autor (name) VALUES ('Federico García Lorca');


-- Insertar libros

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Cien años de soledad', '978-1234567890', 1, 1);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('El otoño del patriarca', '978-1111111111', 1, 1);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Crónica de una muerte anunciada', '978-2222222222', 1, 2);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('El amor en los tiempos del cólera', '978-3333333333', 1, 3);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('El general en su laberinto', '978-4444444444', 1, 1);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Del amor y otros demonios', '978-5555555555', 1, 2);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('La hojarasca', '978-6666666666', 1, 3);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Los funerales de la Mamá Grande', '978-7777777777', 1, 1);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Relato de un náufrago', '978-8888888888', 1, 2);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Doce cuentos peregrinos', '978-9999999999', 1, 3);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Vivir para contarla', '978-1010101010', 1, 1);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Ficciones', '978-2345678901', 2, 2);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('La casa de los espíritus', '978-3456789012', 3, 3);
INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('La ciudad y los perros', '978-4567890123', 4, 3);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Rayuela', '978-5678901234', 5, 3);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Como agua para chocolate', '978-6789012345', 6, 3);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('La sombra del viento', '978-7890123456', 7, 2);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Veinte poemas de amor', '978-8901234567', 8, 3);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Don Quijote de la Mancha', '978-9012345678', 9, 3);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Bodas de sangre', '978-0123456789', 10, 1);

-- Insertar usuarios
INSERT INTO tb_usuario (name, email) VALUES ('juan', 'juan@example.com');
INSERT INTO tb_usuario (name, email) VALUES ('maria', 'maria@example.com');
INSERT INTO tb_usuario (name, email) VALUES ('pedro', 'pedro@example.com');

INSERT INTO tb_reserva (usuario_id, book_id, date_reservation, is_active)
VALUES
    (1, 1, TIMESTAMP '2025-07-27 10:00:00', true),
    (1, 2, TIMESTAMP '2025-07-27 11:00:00', true),
    (2, 3, TIMESTAMP '2025-07-27 12:00:00', true);

