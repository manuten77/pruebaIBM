CREATE DATABASE IF NOT EXISTS mydb;
USE mydb;

CREATE TABLE IF NOT EXISTS `proveedores` (
  `id_proveedor` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `fecha_de_alta` date NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  UNIQUE KEY `id_proveedor_UNIQUE` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO proveedores (id_proveedor,nombre, fecha_de_alta, id_cliente) VALUES (1,'Coca-cola', '2022-07-01',5);
INSERT INTO proveedores (id_proveedor,nombre, fecha_de_alta, id_cliente) VALUES (2,'Pepsi', '2023-01-01',5);
INSERT INTO proveedores (id_proveedor,nombre, fecha_de_alta, id_cliente) VALUES (3,'Redbull', '2020-05-30',6);

