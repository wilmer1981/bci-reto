DELETE FROM telefono;
DELETE FROM usuario;

INSERT INTO usuario (id, name, email, password, token) 
VALUES 
    ('23b49518-f114-4285-8f00-b0182ef966f1','Juan Rodriguez', 'juan@rodriguez.org', 'hunter2','token_ejemplo_1'),
    ('23b49518-f114-4285-8f00-b0182ef966f2','Wilmer Saldaña', 'wilmer.saldana@sermaluc.pe', 'admin21','token_ejemplo_2'),
    ('23b49518-f114-4285-8f00-b0182ef966f3','Frank Del', 'frankd@hotmail.com', 'frank123','token_ejemplo_3');

INSERT INTO telefono (number, citycode, contrycode, usuario_id)
VALUES 
    ('1234567', '2', '55', '23b49518-f114-4285-8f00-b0182ef966f1'),
    ('9876543', '2', '55', '23b49518-f114-4285-8f00-b0182ef966f2'),
    ('5554321', '3', '34', '23b49518-f114-4285-8f00-b0182ef966f3');
