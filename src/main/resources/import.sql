/* Populate tables */
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (1, 'Diego', 'Dominguez', 'dominguezdiex@gmail.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (2, 'John', 'Doe', 'johndoe@gmail.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (3, 'Dawn', 'Reaw', 'example1@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (4, 'Mary', 'Jane', 'example2@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (5, 'Sean', 'Smith', 'example3@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (6, 'Sylas', 'Doe', 'example4@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (7, 'Chris', 'Adams', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (8, 'Joel', 'Doe', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (9, 'Sam', 'Trus', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (10, 'Eva', 'Lias', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (11, 'Louis', 'Jonson', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (12, 'Terrance', 'Doe', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (13, 'Samuel', 'Smith', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (14, 'Jesus', 'Asturd', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (15, 'Hall', 'Sams', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (16, 'Joseph', 'Asturd', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (17, 'Adan', 'Kelan', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (18, 'Mary', 'Smith', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (19, 'Christina', 'James', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (20, 'Margaret', 'Geras', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (21, 'Cesar', 'Jonson', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (22, 'George', 'Doe', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (23, 'Fernando', 'Jane', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (24, 'Sebastian', 'Ivert', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (25, 'Will', 'Heas', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (26, 'Tony', 'Smith', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (27, 'Hector', 'Sams', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (28, 'Joel', 'Doe', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (29, 'Randy', 'Adams', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (30, 'David', 'Harrys', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (31, 'Gerald', 'Somfield', 'example5@example.com', '2022-04-04', '');
INSERT INTO clientes (id, nombre, apellido, email, created_at, foto) VALUES (32, 'Alfred', 'Stuart', 'example5@example.com', '2022-04-04', '');

/* Populate table productos */
INSERT INTO productos (nombre, precio, created_at) VALUES("Dell Monitor 25''", 5300, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES("NPET Teclado Mecanico", 2100, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES("EAGLE WARRIOR MOUSE Gaming",530 , NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES("Samung Monitor 32''", 6200, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES("Redmi AirDot3 Pro", 1650, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES("Bose QuietComform A13", 8200, NOW());
INSERT INTO productos (nombre, precio, created_at) VALUES("Redmi Note12 128GB", 12250, NOW());

/* Insertamos algunas facturas de ejemplo */
INSERT INTO facturas (descripcion, observacion, cliente_id, created_at) VALUES ('Factura equipos de computo', null, 1, NOW());
INSERT INTO factura_detalles (cantidad, factura_id, producto_id) VALUES (2,1,1);
INSERT INTO factura_detalles (cantidad, factura_id, producto_id) VALUES (1,1,2);
INSERT INTO factura_detalles (cantidad, factura_id, producto_id) VALUES (3,1,3);
INSERT INTO factura_detalles (cantidad, factura_id, producto_id) VALUES (1,1,7);

INSERT INTO facturas (descripcion, observacion, cliente_id, created_at) VALUES ('Factura equipos de audio', "Audifonos Reacondicionados", 1, NOW());
INSERT INTO factura_detalles (cantidad, factura_id, producto_id) VALUES (2,2,6);

/* Creamos algunos usuarios */

INSERT INTO users (username, password, enabled) VALUES ('admin','$2a$10$d9K.7D5YNZlt52/3vKtGh.V9KqeI7WzAvb0r69GUVYPn9AnklFLyS',1);
INSERT INTO users (username, password, enabled) VALUES ('diego','$2a$10$BOoM8FEwBc/6uNgDkzkiyeV84ZyhOD3JkSSki9EUu8lpKNICUI2ea',1);
INSERT INTO users (username, password, enabled) VALUES ('dab','$2a$10$RqviJruzmrFSUnKBHaMJRurzEqlMfcJxcy5aXmAl6slwlIo7ptkFW',1);

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (3, 'ROLE_ADMIN');