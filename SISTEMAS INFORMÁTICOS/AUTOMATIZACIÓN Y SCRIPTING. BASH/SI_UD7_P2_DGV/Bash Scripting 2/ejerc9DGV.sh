#!/bin/bash

base=$1
exponente=$2
resultado=0
i=1

if [ $i -eq $2 ]
then
  echo $base
  exit 0
fi

while [ $i -ne $2 ]
do
  resultado=$(($base*$base+$resultado))
  ((i++))
done

echo $resultado
