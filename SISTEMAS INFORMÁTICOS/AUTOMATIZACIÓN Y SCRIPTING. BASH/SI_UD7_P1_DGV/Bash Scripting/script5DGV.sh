#!/bin/bash
#Script que lee dos variables e imprime por pantalla el resultado
#Si lee mas o menos de dos parametros aborta el programa

numero1=$1
numero2=$2
numero3=$3

if [ ! $1 ];
then
  echo ERROR, no has introducido valores.
  exit 0;
fi

if [ ! $2 ];
then
  echo ERROR, no has introducido el segundo valor.
  exit 0;
fi

if [ $3 ];
then
  echo ERROR, has introducido valores de mas.
  exit 0;
fi

echo El resultado de la suma de $1 y de $2 es: $(($1+$2))
