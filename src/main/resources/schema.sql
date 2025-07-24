-- Tabla de bibliotecas
CREATE TABLE tb_biblioteca (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(255) NOT NULL,
       address VARCHAR(255) NOT NULL
);

-- Tabla de autores
CREATE TABLE tb_autor (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(255) NOT NULL UNIQUE
);

-- Tabla de libros
CREATE TABLE tb_libro (
      id BIGINT AUTO_INCREMENT PRIMARY KEY,
      titulo VARCHAR(255) NOT NULL,
      isbn VARCHAR(255) NOT NULL UNIQUE,

      author_id BIGINT NOT NULL,
      biblioteca_id BIGINT NOT NULL,

      CONSTRAINT fk_libro_autor
          FOREIGN KEY (author_id)
              REFERENCES tb_autor(id)
              ON DELETE RESTRICT
              ON UPDATE CASCADE,

      CONSTRAINT fk_libro_biblioteca
          FOREIGN KEY (biblioteca_id)
              REFERENCES tb_biblioteca(id)
              ON DELETE RESTRICT
              ON UPDATE CASCADE
);
