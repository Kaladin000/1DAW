drop table departamento cascade constraints;
 drop table empleado cascade constraints;
 drop table empleado_departamento cascade constraints;
 drop table nomina cascade constraints;
 drop table linea cascade constraints;
 drop table elemento_de_coste cascade constraints;
 drop table ingreso cascade constraints;
 drop table descuento cascade constraints;
 drop table concepto_retributivo cascade constraints;
 CREATE TABLE departamento (
 codigo number(7),
 nombre varchar2(100)
 );
 CREATE TABLE empleado (
 num_mat number(7),
 nif varchar2(9),
 nombre varchar2(100),
 num_hijos number(2),
 retencion number(7),
 cuenta_corriente varchar2(24)
 );
 CREATE TABLE empleado_departamento (
 num_mat number(7),
 codigo number(7),
 funcion varchar2(100)
 );
 CREATE TABLE nomina (
 num_mat number(7),
 ejercicio varchar2(100),
 mes date,
 numero number(7),
 ingreso_total number(7),
 descuento_total number(7)
 );
 CREATE TABLE linea (
 num_linea number(7),
 num_mat number(7),
 ejercicio varchar2(100),
 mes date,
 numero number(7),
 cantidad number(7)
 );
CREATE TABLE elemento_de_coste (
 codigo_elemento_de_coste number(7),
 descripcion varchar2(100),
 saldo number(7),
 pertenece_elemento number(7)
 );
 CREATE TABLE ingreso (
 num_linea number(7),
 num_mat number(7),
 ejercicio varchar2(100),
 mes date,
 numero number(7),
 codigo_concepto_retributivo number(7) NOT NULL
 );
 CREATE TABLE descuento (
 num_linea number(7),
 num_mat number(7),
 ejercicio varchar2(100),
 mes date,
 numero number(7),
 base number(5),
 porcentaje number(3)
 );
 CREATE TABLE concepto_retributivo (
 codigo_concepto_retributivo number(7),
 descripcion_concepto_retributivo varchar2(100)
 );--Definiciones claves primarias
 ALTER TABLE departamento ADD CONSTRAINT pk_departamento PRIMARY KEY
 (codigo);
 ALTER TABLE empleado ADD CONSTRAINT pk_empleado PRIMARY KEY (num_mat);
 ALTER TABLE empleado_departamento ADD CONSTRAINT pk_empleado_departamento
 PRIMARY KEY (codigo, num_mat);
 ALTER TABLE nomina ADD CONSTRAINT pk_nomina PRIMARY KEY (num_mat, ejercicio,
 mes, numero);
 ALTER TABLE linea ADD CONSTRAINT pk_linea PRIMARY KEY (num_linea, num_mat,
 ejercicio, mes, numero);
 ALTER TABLE elemento_de_coste ADD CONSTRAINT pk_elemento_de_coste PRIMARY
 KEY (codigo_elemento_de_coste);
 ALTER TABLE ingreso ADD CONSTRAINT pk_ingreso PRIMARY KEY (num_linea,
 num_mat, ejercicio, mes, numero);
 ALTER TABLE descuento ADD CONSTRAINT pk_descuento PRIMARY KEY (num_linea,
 num_mat, ejercicio, mes, numero);
ALTER TABLE concepto_retributivo ADD CONSTRAINT pk_concepto_retributivo PRIMARY
 KEY (codigo_concepto_retributivo);--Definiciones claves ajenas
 ALTER TABLE empleado_departamento ADD CONSTRAINT fk_empldep_departamento
 FOREIGN KEY(codigo) REFERENCES departamento(codigo);
 ALTER TABLE empleado_departamento ADD CONSTRAINT fk_empldep_empleado
 FOREIGN KEY(num_mat) REFERENCES empleado(num_mat);
 ALTER TABLE nomina ADD CONSTRAINT fk_nomina_empleado FOREIGN KEY(num_mat)
 REFERENCES empleado(num_mat);
 ALTER TABLE linea ADD CONSTRAINT fk_linea_nomina FOREIGN KEY(num_mat,
 ejercicio, mes, numero) REFERENCES nomina(num_mat, ejercicio, mes, numero);
 ALTER TABLE elemento_de_coste ADD CONSTRAINT
 fk_elemento_de_coste_elemento_de_coste FOREIGN KEY (pertenece_elemento)
 REFERENCES elemento_de_coste;
 ALTER TABLE ingreso ADD CONSTRAINT fk_ingreso_linea FOREIGN KEY (num_linea,
 num_mat, ejercicio, mes, numero) REFERENCES linea(num_linea, num_mat, ejercicio,
 mes, numero);
 ALTER TABLE ingreso ADD CONSTRAINT fk_ingreso_conceptoretrib FOREIGN KEY
 (codigo_concepto_retributivo) REFERENCES
 concepto_retributivo(codigo_concepto_retributivo);
 ALTER TABLE descuento ADD CONSTRAINT fk_descuento_linea FOREIGN KEY
 (num_linea, num_mat, ejercicio, mes, numero) REFERENCES linea(num_linea, num_mat,
 ejercicio, mes, numero);