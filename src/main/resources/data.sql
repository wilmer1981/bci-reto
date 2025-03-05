CREATE TABLE usuarios (
    id UUID PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL,
    created DATE DEFAULT CURRENT_TIMESTAMP,
    modified DATE DEFAULT CURRENT_TIMESTAMP,
    last_login DATE DEFAULT CURRENT_TIMESTAMP,
    token VARCHAR(300),
    isactive BOOLEAN DEFAULT TRUE
);

INSERT INTO usuarios (id, name, email, password, token) 
VALUES 
	('23b49518-f114-4285-8f00-b0182ef966f1','Juan Rodriguez', 'juan@rodriguez.org', 'hunter2','token_ejemplo_1'),
        ('23b49518-f114-4285-8f00-b0182ef966f2','Wilmer Saldaña', 'wilmer.saldana@sermaluc.pe', 'admin21','token_ejemplo_2'),
        ('23b49518-f114-4285-8f00-b0182ef966f3','Frank Del', 'frankd@hotmail.com', 'frank123','token_ejemplo_3');

CREATE TABLE telefonos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    number VARCHAR(200) NOT NULL,
    citycode VARCHAR(200) NOT NULL,
    contrycode VARCHAR(200) NOT NULL,
    usuario_id CHAR(36),
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

INSERT INTO telefono (number, citycode, countrycode, usuario_id)
VALUES 
    ('1234567', '2', '55', '23b49518-f114-4285-8f00-b0182ef966f1'),
    ('9876543', '2', '55', '23b49518-f114-4285-8f00-b0182ef966f2'),
    ('5554321', '3', '34', '23b49518-f114-4285-8f00-b0182ef966f3');