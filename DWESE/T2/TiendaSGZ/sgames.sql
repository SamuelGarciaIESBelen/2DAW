DROP DATABASE IF EXISTS sgames;
CREATE DATABASE sgames;
USE sgames;

DROP TABLE IF EXISTS categoria;
CREATE TABLE categoria (
    idCategoria	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre		VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS producto;
CREATE TABLE producto (
    idProducto	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre		VARCHAR(255) NOT NULL,
    descripcion	VARCHAR(600),
    precio		DECIMAL(4,2) NOT NULL,
    imagen		VARCHAR(255),
    idCategoria	INT NOT NULL,
    FOREIGN KEY (idCategoria) REFERENCES categoria(idCategoria)
);

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
    idUsuario	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre		VARCHAR(255) NOT NULL UNIQUE,
    password	VARCHAR(128) NOT NULL,
    rol			VARCHAR(30) NOT NULL
);

DROP TABLE IF EXISTS pedido;
CREATE TABLE pedido (
    idPedido	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    idCliente	INT NOT NULL,
    fecha		DATE NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES usuario(idUsuario)
);

DROP TABLE IF EXISTS detalles_pedido;
CREATE TABLE  detalles_pedido (
    idPedido	INT NOT NULL,
    idProducto	INT NOT NULL,
    cantidad	INT NOT NULL,
    PRIMARY KEY (idPedido, idProducto),
    FOREIGN KEY (idPedido) REFERENCES pedido(idPedido),
    FOREIGN KEY (idProducto) REFERENCES producto(idProducto)
);

INSERT INTO categoria (nombre) VALUES ('Acción y Aventura');
INSERT INTO categoria (nombre) VALUES ('Rol y Estrategia');
INSERT INTO categoria (nombre) VALUES ('Deportes');
INSERT INTO categoria (nombre) VALUES ('Indie');

INSERT INTO producto (nombre, descripcion, precio, imagen, idCategoria) VALUES 
('The Legend of Zelda: Breath of the Wild', 'Aventura épica en un mundo abierto inmenso.', 59.99, '1a.jpg', 1),
('Red Dead Redemption 2', 'Western de acción con gráficos inmersivos.', 49.99, '1b.jpg', 1),
('God of War Ragnarök', 'Kratos enfrenta nuevos desafíos mitológicos.', 69.99, '1c.jpg', 1),
('Uncharted 4: El desenlace del ladrón', 'Juego de aventuras y exploración.', 19.99, '1d.jpg', 1),
('Batman Arkham Knight', 'Ponte el traje del Caballero Oscuro y limpia Gotham.', 29.99, '1e.jpg', 1);

INSERT INTO producto (nombre, descripcion, precio, imagen, idCategoria) VALUES 
('Elden Ring', 'Explora un mundo oscuro lleno de desafíos.', 59.99, '2a.jpg', 2),
('Pokémon Escarlata', 'Explora las tierras de Paldea y hazte con todos.', 69.99, '2b.jpg', 2),
('The Witcher 3: La Cacería Salvaje', 'Aventura RPG con una profunda narrativa.', 39.99, '2c.jpg', 2),
('Skyrim', 'Juego de rol donde encarnas al Sangre de Dragón.', 14.99, '2d.jpg', 2),
('Age of Mythology Retold', 'Estrategia en tiempo real con batallas históricas.', 49.99, '2e.jpg', 2);

INSERT INTO producto (nombre, descripcion, precio, imagen, idCategoria) VALUES 
('EA Sports FC 25', 'El fútbol más realista en videojuegos.', 59.99, '3a.jpg', 3),
('NBA 2K25', 'Juego de baloncesto con gráficos inmersivos.', 49.99, '3b.jpg', 3),
('Gran Turismo 7', 'Simulación de carreras de alta calidad.', 69.99, '3c.jpg', 3),
('Forza Horizon 5', 'Explora paisajes abiertos mientras compites.', 59.99, '3d.jpg', 3),
('Tony Hawk’s Pro Skater 1+2', 'Remake del clásico de skateboarding.', 39.99, '3e.jpg', 3);

INSERT INTO producto (nombre, descripcion, precio, imagen, idCategoria) VALUES 
('Hollow Knight', 'Juego de plataformas con un estilo único.', 14.99, '4a.jpg', 4),
('Stardew Valley', 'Simulación de granja y vida diaria.', 14.99, '4b.jpg', 4),
('Celeste', 'Plataformas desafiante con narrativa emotiva.', 19.99, '4c.jpg', 4),
('Outer Wilds', 'Exploración espacial y puzzles increíbles.', 19.99, '4d.jpg', 4),
('Hades', 'Explora el inframundo en este aclamado juego indie.', 24.99, '4e.jpg', 4);

-- La contraseña es 1234 --
INSERT INTO usuario (nombre, password, rol) VALUES
('Samuel', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'admin'),
('Ricardo', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'admin'),
('Juan', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'cliente');
