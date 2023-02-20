CREATE DATABASE banco;

USE banco;

# CREAR TABLA DOMICILIOS
CREATE TABLE Domicilios (
	id_domicilio INT PRIMARY KEY AUTO_INCREMENT,
	calle VARCHAR(100) NOT NULL,
    numero VARCHAR(50) NOT NULL,
    colonia VARCHAR(100) NOT NULL
); 

# CREAR TABLA CLIENTES
CREATE TABLE `clientes` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apellido_paterno` varchar(50) NOT NULL,
  `apellido_materno` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `edad` int DEFAULT NULL,
  `contrasena` varchar(50) NOT NULL,
  `id_domicilio` int DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `clientes_ibfk_1` (`id_domicilio`),
  CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_domicilio`) REFERENCES `domicilios` (`id_domicilio`)
);

# CREAR TABLA CUENTAS
CREATE TABLE `cuentas` (
  `num_cuenta` int NOT NULL AUTO_INCREMENT,
  `fecha_apertura` datetime DEFAULT CURRENT_TIMESTAMP,
  `saldo` decimal(10,2) DEFAULT '0.00',
  `estado` enum('Activa','Cancelada') DEFAULT 'Activa',
  `id_cliente` int NOT NULL,
  PRIMARY KEY (`num_cuenta`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `cuentas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
) ;

# CREAR TABLA OPERACIONES
CREATE TABLE `operaciones` (
  `folio` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `monto` decimal(10,2) NOT NULL DEFAULT '0.00',
  `num_cuenta_origen` int NOT NULL,
  PRIMARY KEY (`folio`),
  KEY `num_cuenta_origen` (`num_cuenta_origen`),
  CONSTRAINT `operaciones_ibfk_1` FOREIGN KEY (`num_cuenta_origen`) REFERENCES `cuentas` (`num_cuenta`)
) ; 

# CREAR TABLA TRANSFERENCIAS
CREATE TABLE Transferencias (
	id_transferencia INT PRIMARY KEY AUTO_INCREMENT,
    folio INT NOT NULL,
    num_cuenta_destino INT NOT NULL,
    FOREIGN KEY(folio) REFERENCES Operaciones(folio),
    FOREIGN KEY(num_cuenta_destino) REFERENCES Cuentas(num_cuenta)
); 

# CREAR TABLA RETIROS SIN CUENTA
CREATE TABLE Retiros (
	id_retiro INT PRIMARY KEY AUTO_INCREMENT,
    contrasena VARCHAR(8) NOT NULL,
    estado ENUM('Cobrado','No Cobrado') NOT NULL,
    folio INT NOT NULL,
    FOREIGN KEY(folio) REFERENCES Operaciones(folio)
);

delimiter //
create trigger insertar_edad before insert on clientes
for each row 
begin
SET new.edad = (FLOOR(DATEDIFF(CURDATE(), new.fecha_nacimiento) / 365));
end//
delimiter ;
