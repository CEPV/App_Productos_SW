CREATE DATABASE bd_producto;
USE bd_producto;
CREATE TABLE tbl_producto(
id_producto INT PRIMARY KEY AUTO_INCREMENT,
nombre_producto VARCHAR (25) NOT NULL,
distribuidor_producto VARCHAR (25) NOT NULL,
precio_producto INT NOT NULL,
tamaño_producto VARCHAR (25)

);

SELECT * FROM tbl_producto;