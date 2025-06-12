#!/bin/bash

a=$1
b=$2

if [ -e $1 ]
then
  echo "Existe el fichero"
fi

if [ ! -e $1 ]
then
  echo "No existe el fichero"
fi

if [ -d $1 ]
then
  echo "Es un directorio"
fi
