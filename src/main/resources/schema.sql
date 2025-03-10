CREATE TABLE usuario (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    created DATE DEFAULT CURRENT_TIMESTAMP,
    modified DATE DEFAULT CURRENT_TIMESTAMP,
    last_login DATE DEFAULT CURRENT_TIMESTAMP,
    token VARCHAR(300),
    isactive BOOLEAN DEFAULT TRUE
);

CREATE TABLE telefono (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(200) NOT NULL,
    citycode VARCHAR(200) NOT NULL,
    contrycode VARCHAR(200) NOT NULL,
    usuario_id VARCHAR(36),
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);