#!/bin/bash

i=1
echo Introduce el primer numero
read num1
echo Introduce el segundo numero
read num2

if [ $num2 -gt $num1 ]
then
  while [ $i -le $num2 ]
  do
    echo "*"
    ((i++))
  done
else
  while [ $i -le $num1 ]
  do
    echo "*"
    ((i++))
  done
fi
