set serveroutput on;

CREATE TABLE vendedor (
    NUMVEND NUMBER PRIMARY KEY,
    NOMVEND VARCHAR2(30)
);

CREATE TABLE registro_contrasenya (
    NUMVEND NUMBER PRIMARY KEY,
    CONTRASENYA VARCHAR2(999),
    FOREIGN KEY (NUMVEND) REFERENCES vendedor(NUMVEND)
);

CREATE OR REPLACE function crearContrasenya(caracteres IN number) return varchar2 is
    caracteresF number := caracteres;
    numeros varchar2(10) := '0123456789';
    abecedario varchar2(26) := 'abcdefghijklmnopqrstuvwxyz';
    abecedarioMAYUS varchar2(26) := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
    signosPuntuacion varchar2(8) := '.,:;¿?¡!';
    contrasenya varchar2(999) := '';
    
    random number;
    random2 number;

    caracter varchar2(1);
BEGIN
    for i in 1..caracteresF loop
        if (i=1) then
            random := TRUNC(DBMS_RANDOM.VALUE(1, 11));
            caracter := SUBSTR(numeros, random, 1);
        end if;
        if (i=2) then
            random := TRUNC(DBMS_RANDOM.VALUE(1, 27));
            caracter := SUBSTR(abecedario, random, 1);
        end if;
        if (i=3) then
            random := TRUNC(DBMS_RANDOM.VALUE(1, 27));
            caracter := SUBSTR(abecedarioMAYUS, random, 1);
        end if;
        if (i=4) then
            random := TRUNC(DBMS_RANDOM.VALUE(1, 9));
            caracter := SUBSTR(signosPuntuacion, random, 1);
        end if;
        if (i>4) then
            random2 := TRUNC(DBMS_RANDOM.VALUE(1, 5));
            if random2 = 1 then
                random := TRUNC(DBMS_RANDOM.VALUE(1, 11));
                caracter := SUBSTR(numeros, random, 1);
            end if;
            if random2 = 2 then
                random := TRUNC(DBMS_RANDOM.VALUE(1, 27));
                caracter := SUBSTR(abecedario, random, 1);
            end if;
            if random2 = 3 then
                random := TRUNC(DBMS_RANDOM.VALUE(1, 27));
                caracter := SUBSTR(abecedarioMAYUS, random, 1);
            end if;
            if random2 = 4 then
                random := TRUNC(DBMS_RANDOM.VALUE(1, 9));
                caracter := SUBSTR(signosPuntuacion, random, 1);
            end if;
        end if;
        
        contrasenya := contrasenya || caracter;
    end loop;
    return contrasenya;
END;

CREATE OR REPLACE trigger registrarContrasenya after insert on vendedor for each row
DECLARE
    contra varchar2(999);
BEGIN
    contra := crearcontrasenya(15);
    insert into registro_contrasenya (numvend, contrasenya) values (:new.numvend, contra);
END;

insert into vendedor values (1,'Gustavo Fring');

select * from registro_contrasenya;
