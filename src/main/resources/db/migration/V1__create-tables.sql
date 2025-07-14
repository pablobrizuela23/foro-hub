
CREATE TABLE perfil (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);


CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(150) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL
);


CREATE TABLE usuario_perfiles (
    usuario_id INT NOT NULL,
    perfil_id INT NOT NULL,
    PRIMARY KEY (usuario_id,perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id)
);


CREATE TABLE curso (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);


CREATE TABLE topico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50),
    autor_id INT NOT NULL,
    curso_id INT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuario(id),
    FOREIGN KEY (curso_id) REFERENCES curso(id)

);


CREATE TABLE respuesta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico_id INT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    autor_id INT NOT NULL,
    solucion BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (topico_id) REFERENCES topico(id),
    FOREIGN KEY (autor_id) REFERENCES usuario(id)
);



