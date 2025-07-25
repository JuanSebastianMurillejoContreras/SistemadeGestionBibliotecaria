-- Insertar bibliotecas
INSERT INTO tb_biblioteca (name, address) VALUES ('Biblioteca Central', 'Calle 123');
INSERT INTO tb_biblioteca (name, address) VALUES ('Biblioteca Norte', 'Carrera 45');
INSERT INTO tb_biblioteca (name, address) VALUES ('Biblioteca Sur', 'Avenida 89');

-- Insertar autores
INSERT INTO tb_autor (name) VALUES ('Gabriel García Márquez');
INSERT INTO tb_autor (name) VALUES ('Jorge Luis Borges');
INSERT INTO tb_autor (name) VALUES ('Isabel Allende');

-- Insertar libros

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Cien años de soledad', '978-1234567890', 1, 1);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('Ficciones', '978-2345678901', 2, 2);

INSERT INTO tb_libro (title, isbn, author_id, library_id)
VALUES ('La casa de los espíritus', '978-3456789012', 3, 3);
