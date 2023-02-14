# CREATE DATABASE banco;

USE banco;

# CREAR TABLA DOMICILIOS
CREATE TABLE Domicilios (
	id_domicilio INT PRIMARY KEY AUTO_INCREMENT,
	calle VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    colonia VARCHAR(100) NOT NULL
); 

# CREAR TABLA CLIENTES
CREATE TABLE Clientes (
	id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NOT NULL,
    edad INT NOT NULL,
    id_domicilio INT NOT NULL,
    FOREIGN KEY(id_domicilio) REFERENCES Domicilios(id_domicilio)
);

# CREAR TABLA CUENTAS
CREATE TABLE Cuentas (
	num_cuenta INT PRIMARY KEY AUTO_INCREMENT,
	fecha_apertura DATETIME NOT NULL,
    saldo DECIMAL(10, 4) DEFAULT 0.0000 NOT NULL,
    id_cliente INT NOT NULL,
    FOREIGN KEY(id_cliente) REFERENCES Clientes(id_cliente)
); 

# CREAR TABLA OPERACIONES
CREATE TABLE Operaciones (
	folio INT PRIMARY KEY AUTO_INCREMENT,
	fecha DATETIME NOT NULL,
    monto DECIMAL(10, 4) NOT NULL,
    num_cuenta_origen INT NOT NULL,
    FOREIGN KEY(num_cuenta_origen) REFERENCES Cuentas(num_cuenta)
); 

# CREAR TABLA TRANSFERENCIAS
CREATE TABLE Transferencias (
	id_transferencia INT PRIMARY KEY AUTO_INCREMENT,
	num_cuenta_destino INT NOT NULL,
    folio INT NOT NULL,
    FOREIGN KEY(folio) REFERENCES Operaciones(folio)
); 

# CREAR TABLA RETIROS SIN CUENTA
CREATE TABLE Retiros (
	id_retiro INT PRIMARY KEY AUTO_INCREMENT,
    contraseña VARCHAR(8) NOT NULL,
    estado ENUM('Cobrado','No Cobrado') NOT NULL,
    folio INT NOT NULL,
    FOREIGN KEY(folio) REFERENCES Operaciones(folio)
);

#Hola brandon
#Hola cota