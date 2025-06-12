DROP TABLE ej3_cliente CASCADE CONSTRAINTS;
DROP TABLE ej3_entidad CASCADE CONSTRAINTS;
DROP TABLE ej3_sucursal CASCADE CONSTRAINTS;
DROP TABLE ej3_cuenta CASCADE CONSTRAINTS;

--CREACIÓN DE TABLAS

CREATE TABLE ej3_cliente(
    nombre VARCHAR2(50) PRIMARY KEY,
    telefono VARCHAR2(9),
    edad NUMBER(3),
    domicilio VARCHAR2(50)
);

CREATE TABLE ej3_entidad(
    nombre VARCHAR2(20),
    sede VARCHAR2(50),
    CONSTRAINT pk_ej3_entidad PRIMARY KEY (nombre)
);

CREATE TABLE ej3_sucursal(
    nombre_ent VARCHAR2(20),
    numero NUMBER(4),
    direccion VARCHAR2(50),
    director VARCHAR2(50),
    CONSTRAINT pk_ej3_sucursal PRIMARY KEY (nombre_ent,numero),
    CONSTRAINT fk_ej3_sucursal_ej3_entidad FOREIGN KEY (nombre_ent) REFERENCES ej3_entidad
);

CREATE TABLE ej3_cuenta(
    nombre_ent VARCHAR2(20),
    numero_suc NUMBER(4),
    numero NUMBER(8),
    tipo VARCHAR2(10),
    saldo NUMBER(10,2),
    nombre_cli VARCHAR2(50) REFERENCES ej3_cliente ON DELETE CASCADE,
    CONSTRAINT pk_ej3_cuenta PRIMARY KEY (nombre_ent,numero_suc,numero),
    CONSTRAINT fk_ej3_cuenta_ej3_sucursal FOREIGN KEY (nombre_ent,numero_suc) REFERENCES ej3_sucursal ON DELETE CASCADE
);

--INSERCIÓN DE DATOS

INSERT INTO ej3_cliente VALUES ('Alba Navarro', '965467898', 31, 'C/Azorín, 15');
INSERT INTO ej3_cliente VALUES ('Juan Pérez', '965381654', 21, 'C/Boccacio, 38');
INSERT INTO ej3_cliente VALUES ('Alex Cuenca', '965551985', 15, 'C/Cervantes, 28');

SELECT * FROM ej3_cliente;

INSERT INTO ej3_entidad VALUES ('BBVA','Bilbao');
INSERT INTO ej3_entidad VALUES ('Caixa','Barcelona');
INSERT INTO ej3_entidad VALUES ('Bankia','Madrid');

SELECT * FROM ej3_entidad;

INSERT INTO ej3_sucursal VALUES ('BBVA', 0001,'C/Los pinos, 34','Fernando Calleja');
INSERT INTO ej3_sucursal VALUES ('BBVA', 0002,'C/Cruzados, 71','Silvia Verdú');
INSERT INTO ej3_sucursal VALUES ('Caixa', 0001,'C/Mayor, 1','Lorena Juan');
INSERT INTO ej3_sucursal VALUES ('Caixa', 0002,'C/Real, 3','Lorena Moreno');
INSERT INTO ej3_sucursal VALUES ('Bankia', 1245,'C/Cotos, 54','Roberto Bautista');
INSERT INTO ej3_sucursal VALUES ('Bankia', 0564,'C/Calabacines, 12','Sara Navarro');

SELECT * FROM ej3_sucursal;

INSERT INTO ej3_cuenta VALUES ('BBVA', 0001, 89765432, 'Ahorro', 5000.54, 'Alba Navarro');
INSERT INTO ej3_cuenta VALUES ('Caixa', 0002, 23456788, 'Corriente', 78654.65, 'Juan Pérez');
INSERT INTO ej3_cuenta VALUES ('Bankia', 1245, 87654875, 'Ahorro', 123.45, 'Alex Cuenca');
INSERT INTO ej3_cuenta VALUES ('BBVA', 0002, 57648775, 'Corriente', 12.5, 'Alex Cuenca');
INSERT INTO ej3_cuenta VALUES ('Caixa', 0002, 45648746, 'Corriente', 984746.5, 'Alba Navarro');
INSERT INTO ej3_cuenta VALUES ('BBVA', 0001, 89776535, 'Corriente', 654877.4, 'Alba Navarro');
INSERT INTO ej3_cuenta VALUES ('BBVA', 0002, 89776535, 'Corriente', 654877.4, 'Alba Navarro');
INSERT INTO ej3_cuenta VALUES ('Caixa', 0001, 89776535, 'Corriente', 654877.4, 'Alba Navarro');

SELECT * FROM ej3_cuenta;

--MODIFICACIÓN DE DATOS

UPDATE ej3_cuenta SET saldo=12456.97 WHERE numero=89776535;

SELECT * FROM ej3_cuenta;

UPDATE ej3_sucursal SET director='Ricardo Campos' WHERE director='Fernando Calleja';

SELECT * FROM ej3_sucursal;

UPDATE ej3_cliente SET domicilio='C/Lorca, 24' WHERE nombre='Alex Cuenca';

SELECT * FROM ej3_cliente;

UPDATE ej3_sucursal SET director='Juan Cabezo' WHERE director='Lorena Moreno';
UPDATE ej3_sucursal SET direccion='C/Los abetos' WHERE director='Juan Cabezo';

SELECT * FROM ej3_sucursal;

UPDATE ej3_entidad SET sede='Alicante' WHERE nombre='Caixa';

SELECT * FROM ej3_entidad;

--BORRADO DE DATOS

DELETE FROM ej3_sucursal WHERE numero=0564;

SELECT * FROM ej3_sucursal;

DELETE FROM ej3_cuenta WHERE nombre_cli='Juan Pérez';

SELECT * FROM ej3_cuenta;

UPDATE ej3_cuenta SET saldo=NULL WHERE numero=089765432;

SELECT * FROM ej3_cuenta;

DELETE FROM ej3_sucursal WHERE direccion='C/Los abetos';

SELECT * FROM ej3_sucursal;

DELETE FROM ej3_cliente WHERE nombre='Alba Navarro'; --He editado la linea 36 para que al borrarse el cliente, también se borre la referencia/hijo

SELECT * FROM ej3_cliente;