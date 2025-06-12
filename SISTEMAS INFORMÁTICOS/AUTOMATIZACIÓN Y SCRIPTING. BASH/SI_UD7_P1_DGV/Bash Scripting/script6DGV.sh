#!/bin/bash
#Script que lista el directorio introducido

directorio=$1

if [ ! $1 ];
then
  echo ERROR, no has introducido valores.
  exit 0;
fi

if [ $2 ];
then
  echo ERROR, has introducido valores de mas.
  exit 0;
fi

ls -l $1
