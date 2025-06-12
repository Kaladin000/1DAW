drop table provincia cascade constraints;
 drop table pais cascade constraints;
 drop table proveedor cascade constraints;
 drop table productor cascade constraints;
 drop table estacion_primaria cascade constraints;
 drop table hidroelectrica cascade constraints;
 drop table solar cascade constraints;
 drop table nuclear cascade constraints;
 drop table termica cascade constraints;
 drop table transportista cascade constraints;
 drop table transportista_nuclear_proveedor cascade constraints;
 drop table estacion_primaria_productor cascade constraints;
 drop table red_distribucion cascade constraints;
 drop table deriva_sobrante cascade constraints;
 drop table linea cascade constraints;
 drop table companyia cascade constraints;
 drop table companyia_red cascade constraints;
 drop table subestacion cascade constraints;
 drop table zona_servicio cascade constraints;
 drop table zona_subestacion cascade constraints;
 CREATE TABLE provincia (
 cod number(2),
 nombre varchar2(100)
 );
 CREATE TABLE pais (
 cod number(3),
 nombre varchar2(101)
 );
 CREATE TABLE proveedor (
 nombre varchar2(102)
 );
 CREATE TABLE productor (
 nombre varchar2(103),
 prod_max number(7),
 prod_media number(7),
 fecha_ent date
 );
 CREATE TABLE estacion_primaria (
 nombre varchar2(104),
 num_estaciones number(7)
 );
 CREATE TABLE hidroelectrica (
nombre varchar2(103),
 ocupacion varchar2(100),
 capacidad_max number(7),
 num_turbinas number(5)
 );
 CREATE TABLE solar (
 nombre varchar2(103),
 superficie number(7),
 tipo varchar2(100),
 med_anual_sol number(5)
 );
 CREATE TABLE nuclear (
 nombre varchar2(103),
 num_reac number(5),
 vol_plu number(7),
 res_nucleares number(7)
 );
 CREATE TABLE termica (
 nombre varchar2(103),
 num_hornos number(5),
 vol_carbon number(7),
 vol_gases number(8)
 );
 CREATE TABLE transportista (
 nombre varchar(105),
 matricula varchar2(7)
 );
 CREATE TABLE transportista_nuclear_proveedor (
 nombre_trans varchar(105),
 nombre_pro varchar(103),
 nombre_nuc varchar(103),
 cantidad number(6),
 fecha date
 );
 CREATE TABLE estacion_primaria_productor (
 nombre_prod varchar(103),
 nombre_est varchar(104)
 );
 CREATE TABLE red_distribucion (
 numero number(7),
 nombre varchar(104) NOT NULL
);
 CREATE TABLE deriva_sobrante (
 numero_red_ori number(7),
 numero_red_des number(7),
 volumen number(7)
 );
 CREATE TABLE linea (
 red_distribucion number(7),
 numero number(6),
 longitud number(7)
 );
 CREATE TABLE companyia (
 nombre varchar(106),
 cif varchar2(9)
 );
 CREATE TABLE companyia_red (
 nombre varchar(106),
 numero number(7)
 );
 CREATE TABLE subestacion (
 codigo number(7),
 red_distribucion number(7) NOT NULL,
 numero number(6) NOT NULL
 );
 CREATE TABLE zona_servicio (
 cod number(2),
 numero number(8),
 consumo_med number (7),
 num_consumidores number (7)
 );
 CREATE TABLE zona_subestacion (
 numero number(8),
 cod number(2),
 codigo number(7)
 );--Definiciones claves primarias
 ALTER TABLE provincia ADD CONSTRAINT pk_provincia PRIMARY KEY (cod);
 ALTER TABLE pais ADD CONSTRAINT pk_pais PRIMARY KEY (cod);
 ALTER TABLE proveedor ADD CONSTRAINT pk_proveedor PRIMARY KEY (nombre);
ALTER TABLE productor ADD CONSTRAINT pk_productor PRIMARY KEY (nombre);
 ALTER TABLE estacion_primaria ADD CONSTRAINT pk_est_prim PRIMARY KEY
 (nombre);
 ALTER TABLE hidroelectrica ADD CONSTRAINT pk_hidroelectrica PRIMARY KEY
 (nombre);
 ALTER TABLE solar ADD CONSTRAINT pk_solar PRIMARY KEY (nombre);
 ALTER TABLE nuclear ADD CONSTRAINT pk_nuclear PRIMARY KEY (nombre);
 ALTER TABLE termica ADD CONSTRAINT pk_termica PRIMARY KEY (nombre);
 ALTER TABLE transportista ADD CONSTRAINT pk_transportista PRIMARY KEY (nombre);
 ALTER TABLE transportista_nuclear_proveedor ADD CONSTRAINT pk_tra_nuc_pro
 PRIMARY KEY (nombre_trans,nombre_pro,nombre_nuc,fecha);
 ALTER TABLE estacion_primaria_productor ADD CONSTRAINT pk_est_pri_pro PRIMARY
 KEY (nombre_prod,nombre_est);
 ALTER TABLE red_distribucion ADD CONSTRAINT pk_red_distribucion PRIMARY KEY
 (numero);
 ALTER TABLE deriva_sobrante ADD CONSTRAINT pk_deriva_sobrante PRIMARY KEY
 (numero_red_ori,numero_red_des);
 ALTER TABLE linea ADD CONSTRAINT pk_linea PRIMARY KEY
 (red_distribucion,numero);
 ALTER TABLE companyia ADD CONSTRAINT pk_companyia PRIMARY KEY (cif);
 ALTER TABLE companyia_red ADD CONSTRAINT pk_companyia_red PRIMARY KEY
 (nombre,numero);
 ALTER TABLE subestacion ADD CONSTRAINT pk_subestacion PRIMARY KEY (codigo);
 ALTER TABLE zona_servicio ADD CONSTRAINT pk_zona_servicio PRIMARY KEY
 (numero,cod);
 ALTER TABLE zona_subestacion ADD CONSTRAINT pk_zona_subestacion PRIMARY
 KEY (numero,cod,codigo);--Definiciones claves únicas
 ALTER TABLE companyia ADD CONSTRAINT uk_companyia UNIQUE (nombre);--Definiciones claves ajenas
 ALTER TABLE hidroelectrica ADD CONSTRAINT fk_hidroelectrica_productor FOREIGN
 KEY (nombre) REFERENCES productor(nombre);
 ALTER TABLE solar ADD CONSTRAINT fk_solar_productor FOREIGN KEY (nombre)
 REFERENCES productor(nombre);
 ALTER TABLE nuclear ADD CONSTRAINT fk_nuclear_productor FOREIGN KEY (nombre)
 REFERENCES productor(nombre);
 ALTER TABLE termica ADD CONSTRAINT fk_termica_productor FOREIGN KEY (nombre)
 REFERENCES productor(nombre);
 ALTER TABLE transportista_nuclear_proveedor ADD CONSTRAINT
 fk_tra_nuc_pro_transportista FOREIGN KEY (nombre_trans) REFERENCES
 transportista(nombre);
 ALTER TABLE transportista_nuclear_proveedor ADD CONSTRAINT
 fk_tra_nuc_pro_productor FOREIGN KEY (nombre_pro) REFERENCES productor(nombre);
ALTER TABLE transportista_nuclear_proveedor ADD CONSTRAINT
 fk_tra_nuc_pro_nuclear FOREIGN KEY (nombre_nuc) REFERENCES nuclear(nombre);
 ALTER TABLE estacion_primaria_productor ADD CONSTRAINT fk_est_pri_pro_productor
 FOREIGN KEY (nombre_prod) REFERENCES productor(nombre);
 ALTER TABLE estacion_primaria_productor ADD CONSTRAINT
 fk_est_pri_pro_estacion_primaria FOREIGN KEY (nombre_est) REFERENCES
 estacion_primaria(nombre);
 ALTER TABLE red_distribucion ADD CONSTRAINT fk_red_distribucion_estacion_primaria
 FOREIGN KEY (nombre) REFERENCES estacion_primaria(nombre);
 ALTER TABLE deriva_sobrante ADD CONSTRAINT fk_deriva_sobrante_red_disori
 FOREIGN KEY (numero_red_ori) REFERENCES red_distribucion(numero);
 ALTER TABLE deriva_sobrante ADD CONSTRAINT fk_deriva_sobrante_red_disdes
 FOREIGN KEY (numero_red_des) REFERENCES red_distribucion(numero);
 ALTER TABLE linea ADD CONSTRAINT fk_linea_red_dis FOREIGN KEY (red_distribucion)
 REFERENCES red_distribucion(numero);
 ALTER TABLE companyia_red ADD CONSTRAINT fk_companyia_red_companyia
 FOREIGN KEY (nombre) REFERENCES companyia(nombre);
 ALTER TABLE companyia_red ADD CONSTRAINT fk_companyia_red_red_dis FOREIGN
 KEY (numero) REFERENCES red_distribucion(numero);
 ALTER TABLE subestacion ADD CONSTRAINT fk_subestacion_linea FOREIGN KEY
 (red_distribucion,numero) REFERENCES linea(red_distribucion,numero);
 ALTER TABLE zona_servicio ADD CONSTRAINT fk_zona_servicio_provincia FOREIGN
 KEY (cod) REFERENCES provincia(cod);
 ALTER TABLE zona_subestacion ADD CONSTRAINT fk_zona_subestacion_zona_servicio
 FOREIGN KEY (numero,cod) REFERENCES zona_servicio(numero,cod);
 ALTER TABLE zona_subestacion ADD CONSTRAINT fk_zona_subestacion_subestacion
 FOREIGN KEY (codigo) REFERENCES subestacion(codigo);