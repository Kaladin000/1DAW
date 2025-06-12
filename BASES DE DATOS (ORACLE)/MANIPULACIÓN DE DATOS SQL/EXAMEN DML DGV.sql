drop table deportistas cascade constraints;
drop table individuales cascade constraints;
drop table equipo cascade constraints;
drop table deporte cascade constraints;
drop table individuales_equipo cascade constraints;
drop table pais cascade constraints;

CREATE TABLE deportistas (
	id number(6),
	nombre varchar2(25),
    id_deporte number(4),
    iso_pais varchar2(3)
);

CREATE TABLE individuales (
	dni varchar2(9),
    id_deportista number(6),
    mejor_tiempo number(6,3),
    patrocinador varchar2(25)
);

CREATE TABLE equipo (
	id_equipo number(5),
    denominacion varchar2(25),
    id_deporte number(4),
    mejor_registro number(6,3),
    integrantes number(4)
);

CREATE TABLE deporte (
	id number(4) NOT NULL,
    denominacion varchar2(26),
    fecha_creacion date,
    tipo varchar2(25)
);

CREATE TABLE individuales_equipo (
	id_equipo number(5),
    id_deportista number(6),
    dni varchar2(9)
);

CREATE TABLE pais (
	cod_iso varchar2(3),
    cod_pais number(3),
    nombre varchar2(26),
    habitantes number(10)
);

--claves primarias

ALTER TABLE deportistas ADD CONSTRAINT pk_deportistas PRIMARY KEY (id);
ALTER TABLE individuales ADD CONSTRAINT pk_individuales PRIMARY KEY (id_deportista);
ALTER TABLE equipo ADD CONSTRAINT pk_equipo PRIMARY KEY (id_equipo);
ALTER TABLE deporte ADD CONSTRAINT pk_deporte PRIMARY KEY (id);
ALTER TABLE individuales_equipo ADD CONSTRAINT pk_individuales_equipo PRIMARY KEY (id_equipo);
ALTER TABLE pais ADD CONSTRAINT pk_pais PRIMARY KEY (cod_iso);

--claves unique

ALTER TABLE pais ADD CONSTRAINT uk_pais UNIQUE (cod_pais);
ALTER TABLE individuales ADD CONSTRAINT uk_individuales UNIQUE (dni);
ALTER TABLE individuales_equipo ADD CONSTRAINT uk_individuales_equipo UNIQUE (dni, id_deportista);

--foreign keys

ALTER TABLE deportistas ADD CONSTRAINT fk_deportistas_deporte FOREIGN KEY (id_deporte) REFERENCES deporte(id);
ALTER TABLE deportistas ADD CONSTRAINT fk_deportistas_pais FOREIGN KEY (iso_pais) REFERENCES pais(cod_iso);
ALTER TABLE individuales ADD CONSTRAINT fk_individuales_deportistas FOREIGN KEY (id_deportista) REFERENCES deportistas(id);
ALTER TABLE equipo ADD CONSTRAINT fk_equipo_deporte FOREIGN KEY (id_equipo) REFERENCES deporte(id);
ALTER TABLE individuales_equipo ADD CONSTRAINT fk_individuales_equipo_equipo FOREIGN KEY (id_equipo) REFERENCES equipo(id_equipo);
ALTER TABLE individuales_equipo ADD CONSTRAINT fk_ind_eq_ind FOREIGN KEY (id_deportista) REFERENCES individuales(id_deportista);
ALTER TABLE individuales_equipo ADD CONSTRAINT fk_individuales_equipo_individualesdni FOREIGN KEY (dni) REFERENCES individuales(dni);

--modificaciones

ALTER TABLE pais DROP COLUMN habitantes;
ALTER TABLE deportistas ADD estado number(1);


--inserciones

INSERT INTO deporte VALUES (001,'Golf', TO_DATE ('01/01/1908','DD/MM/YYYY'), 'Colectivo');
INSERT INTO deporte VALUES (002,'Natación', TO_DATE ('01/01/1545','DD/MM/YYYY'), 'Colectivo');
INSERT INTO deporte VALUES (003,'Tenis', TO_DATE ('01/01/1924','DD/MM/YYYY'), 'Adaptado');
INSERT INTO deporte VALUES (004,'Atletismo', TO_DATE ('01/01/0456','DD/MM/YYYY'), 'Individual');

INSERT INTO equipo (id_equipo,denominacion,id_deporte, integrantes) VALUES (1,'Golferas', 001, 2);
INSERT INTO equipo (id_equipo,denominacion,id_deporte, integrantes) VALUES (2,'Sirenitas', 002, 4);
INSERT INTO equipo (id_equipo,denominacion,id_deporte, integrantes) VALUES (3,'Capuzones', 002, 5);

INSERT INTO deportistas VALUES (001, 'Jose María Olazabal', 001, 'ESP');
INSERT INTO deportistas VALUES (002, 'Michael Phelps', 002, 'EUA');
INSERT INTO deportistas VALUES (003, 'Naomi Osaka', 003, 'EUA');
INSERT INTO deportistas VALUES (004, 'Mo Farat', 004, 'GBR');

--modificaciones y borrados

ALTER TABLE deporte DISABLE CONSTRAINT pk_deporte cascade;
DELETE FROM deporte WHERE fecha_creacion >= TO_DATE ('01/01/1900','DD/MM/YYYY');
UPDATE deportistas SET iso_pais='EAU' WHERE nombre='Mo Farat';
DELETE FROM deporte WHERE tipo='Adaptado';
ALTER TABLE deporte ENABLE CONSTRAINT pk_deporte;
