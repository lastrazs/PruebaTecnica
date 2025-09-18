-- Crear la base de datos
CREATE DATABASE tienda;

-- Usar la base de datos
USE tienda;

-- Crear la tabla usuarios
CREATE TABLE usuarios (
    id INT PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255)
);

-- Crear la tabla productos
CREATE TABLE productos (
    id INT PRIMARY KEY,
    nombre VARCHAR(255),
    precio DECIMAL(10,2),
    stock INT
);

-- Crear la tabla pedidos
CREATE TABLE pedidos (
    id INT PRIMARY KEY,
    usuario_id INT,
    producto_id INT,
    cantidad INT,
    fecha DATE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (producto_id) REFERENCES productos(id)
);


/*Consula A)*/
SELECT p.id AS pedido_id,u.id AS usuario_id,u.nombre AS usuario_nombre,u.email AS usuario_email,
pr.id AS producto_id,
pr.nombre AS producto_nombre,
pr.precio AS producto_precio,
p.cantidad AS cantidad,
p.fecha AS fecha_pedido FROM pedidos p JOIN usuarios u ON p.usuario_id = u.id 
JOIN 
productos pr ON p.producto_id = pr.id;
    
/*Consulta B*/
SELECT u.id AS usuario_id,u.nombre AS usuario_nombre,SUM(p.cantidad * pr.precio) AS total_gastado
FROM pedidos p JOIN usuarios u ON p.usuario_id = u.id
JOIN productos pr ON p.producto_id = pr.id
GROUP BY u.id, u.nombre;