#!/bin/bash

a=$1

if [ ! $1 ];
then
  echo ERROR, no hay parametros.
  exit 0;
fi

echo "$1"
