set serveroutput on;

create or replace PROCEDURE contarDinero (dinero number) is
    
    /* Inicializo los valores únicos de cada unidad de medida monetaria
       Inicializo el valor dineroTotal */
    
    cantB500 number := 0;
    cantB200 number := 0;
    cantB100 number := 0;
    cantB50 number := 0;
    cantB20 number := 0;
    cantB10 number := 0;
    cantB5 number := 0;
    cantM2 number := 0;
    cantM1 number := 0;
    
    dineroTotal number := dinero;
    
begin
    
    /* Establezco que dineroTotal ha de ser mayor a la unidad de moneda establecida,
    si lo es, suma su valor único en 1 y resta el dinero del total, se repite 
    hasta que el dineroTotal sea menor a la unidad de moneda establecida. */

    while dineroTotal>=500 loop
        cantB500:=cantB500+1;
        dineroTotal:=dineroTotal-500;
    end loop;
    while dineroTotal>=200 loop
        cantB200:=cantB200+1;
        dineroTotal:=dineroTotal-200;
    end loop;
    while dineroTotal>=100 loop
        cantB100:=cantB100+1;
        dineroTotal:=dineroTotal-100;
    end loop;
    while dineroTotal>=50 loop
        cantB50:=cantB50+1;
        dineroTotal:=dineroTotal-50;
    end loop;
    while dineroTotal>=20 loop
        cantB20:=cantB20+1;
        dineroTotal:=dineroTotal-20;
    end loop;
    while dineroTotal>=10 loop
        cantB10:=cantB10+1;
        dineroTotal:=dineroTotal-10;
    end loop;
    while dineroTotal>=5 loop
        cantB5:=cantB5+1;
        dineroTotal:=dineroTotal-5;
    end loop;
    while dineroTotal>=2 loop
        cantM2:=cantM2+1;
        dineroTotal:=dineroTotal-2;
    end loop;
    while dineroTotal>=1 loop
        cantM1:=cantM1+1;
        dineroTotal:=dineroTotal-1;
    end loop;
    
    /* Imprime por pantalla cada unidad monetaria única si existe (es mayor a 0) */
    
    if cantB500>0 then
        dbms_output.put_line(To_CHAR(cantB500) || ' billete de 500');
    end if;    
    if cantB200>0 then
        dbms_output.put_line(To_CHAR(cantB200) || ' billete de 200');
    end if;
    if cantB100>0 then
        dbms_output.put_line(To_CHAR(cantB100) || ' billete de 100');
    end if;
    if cantB50>0 then
        dbms_output.put_line(To_CHAR(cantB50) || ' billete de 50');
    end if;
    if cantB20>0 then
        dbms_output.put_line(To_CHAR(cantB20) || ' billete de 20');
    end if;
    if cantB10>0 then
        dbms_output.put_line(To_CHAR(cantB10) || ' billete de 10');
    end if;
    if cantB5>0 then
        dbms_output.put_line(To_CHAR(cantB5) || ' billete de 5');
    end if;
    if cantM2>0 then
        dbms_output.put_line(To_CHAR(cantM2) || ' moneda de 2');
    end if;
    if cantM1>0 then
        dbms_output.put_line(To_CHAR(cantM1) || ' moneda de 1');
    end if;
    
end;

execute contarDinero(139);