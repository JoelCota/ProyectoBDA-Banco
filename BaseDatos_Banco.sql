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
  `contrasena` blob(8) NOT NULL,
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
  `tipo` ENUM("Transferencia", "Retiro") NOT NULL,
  PRIMARY KEY (`folio`),
  KEY `num_cuenta_origen` (`num_cuenta_origen`),
  CONSTRAINT `operaciones_ibfk_1` FOREIGN KEY (`num_cuenta_origen`) REFERENCES `cuentas` (`num_cuenta`)
) ; 

# CREAR TABLA TRANSFERENCIAS
CREATE TABLE Transferencias (
	id_transferencia INT PRIMARY KEY AUTO_INCREMENT,
    folio INT NOT NULL,
    num_cuenta_destino INT,
    FOREIGN KEY(folio) REFERENCES Operaciones(folio),
    FOREIGN KEY(num_cuenta_destino) REFERENCES Cuentas(num_cuenta)
); 

# CREAR TABLA RETIROS SIN CUENTA
CREATE TABLE Retiros (
	id_retiro INT PRIMARY KEY AUTO_INCREMENT,
    contrasena VARCHAR(8) NOT NULL,
    estado ENUM('Pendiente','Cobrado','No Cobrado') DEFAULT 'Pendiente' NOT NULL,
    folio INT NOT NULL,
    FOREIGN KEY(folio) REFERENCES Operaciones(folio)
);

# TRIGGERS

delimiter //
Create trigger insertar_edad before insert on clientes
for each row 
begin
	SET new.edad = (FLOOR(DATEDIFF(CURDATE(), new.fecha_nacimiento) / 365));
end//
delimiter ;

delimiter //
Create trigger generar_contrasena before insert on retiros
for each row 
begin 
	set new.contrasena = aes_encrypt(LPAD(FLOOR(RAND() * 99999999), 8, '0'),"hunter2");
end//
delimiter ; 

delimiter //
Create trigger insertar_transferencias_retiros after insert on operaciones
for each row 
begin 
	IF (new.tipo LIKE 'Transferencia') THEN
		INSERT INTO Transferencias(folio) VALUES (new.folio);
	ELSE 
		INSERT INTO Retiros(folio) VALUES (new.folio);
	END IF;
end//
delimiter ; 

# STORED PROCEDURES

delimiter $$ 
CREATE PROCEDURE realizarTransferencia(IN cuentaOrigen INT, IN cuentaDestino INT, IN montoTransferencia DECIMAL(10, 2))
BEGIN
    DECLARE saldoCuentaOrigen DECIMAL(10, 2);
    START TRANSACTION;
			SELECT saldo INTO saldoCuentaOrigen FROM Cuentas WHERE num_cuenta = cuentaOrigen FOR UPDATE;
		IF (saldoCuentaOrigen >= montoTransferencia AND cuentaOrigen != cuentaDestino AND montoTransferencia > 0) THEN
			UPDATE Cuentas SET saldo = saldo - montoTransferencia WHERE num_cuenta = cuentaOrigen;
			UPDATE Cuentas SET saldo = saldo + montoTransferencia WHERE num_cuenta = cuentaDestino;
			INSERT INTO Operaciones(monto, num_cuenta_origen, tipo) VALUES (montoTransferencia, cuentaOrigen, 'Transferencia');
			COMMIT;
		ELSE
			signal sqlstate '45000' set message_text = "La transferencia no se pudo concretar";
			ROLLBACK;
		END IF;
END
$$

delimiter $$ 
CREATE PROCEDURE realizarRetiro(IN idRetiro INT, IN cuentaOrigen INT, IN montoRetiro DECIMAL(10, 2))
BEGIN
	DECLARE saldoCuentaOrigen DECIMAL(10, 2);
    DECLARE estadoCuentaOrigen VARCHAR(10);
	START TRANSACTION;
			SELECT saldo INTO saldoCuentaOrigen FROM Cuentas WHERE num_cuenta = cuentaOrigen FOR UPDATE;
            SELECT estado INTO estadoCuentaOrigen FROM Cuentas WHERE num_cuenta = cuentaOrigen FOR UPDATE;
		IF (saldoCuentaOrigen >= montoRetiro AND estadoCuentaOrigen = 'Activa') THEN
			UPDATE Cuentas SET saldo = saldo - montoRetiro WHERE num_cuenta = cuentaOrigen;
			UPDATE Retiros SET estado = "Cobrado" Where id_retiro = idRetiro;
            INSERT INTO Operaciones(monto, num_cuenta_origen, tipo) VALUES (montoRetiro, cuentaOrigen, 'Retiro');
			COMMIT;
		ELSE ROLLBACK;
    END IF;
END
$$

delimiter $$
CREATE PROCEDURE retiroNoCobrado(IN idRetiro INT)
BEGIN
    DECLARE estadoActual varchar(20);
    DECLARE fechaHoraRetiro DATETIME;
    DECLARE fechaHoraActual DATETIME;
    DECLARE minutosTranscurridos INT;
    SELECT estado FROM Retiros WHERE id_Retiro = idRetiro INTO estadoActual;
    SELECT fechaHora FROM Retiros WHERE id_Retiro = idRetiro INTO fechaHoraRetiro;
    SET fechaHoraActual = NOW();
    SET minutosTranscurridos = TIMESTAMPDIFF(MINUTE, fechaHoraRetiro, fechaHoraActual);
    IF minutosTranscurridos >= 10 AND estadoActual LIKE "Pendiente" THEN
        UPDATE Retiros SET estado = 'No Cobrado' WHERE id_retiro = idRetiro;
    END IF;
END
$$

