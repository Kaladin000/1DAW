#!/bin/bash

for archivo in $@
do
if [ -e $archivo ]
then
  echo $archivo existe
  if [ -d $archivo ]
  then
    echo $archivo es un directorio
  else
    echo $archivo es un fichero
  fi
else
  echo $archivo no existe
fi
done
