#!/bin/bash

a=$1
b=$2

if [ $1 -gt $2 ]
then
  echo "$1 es mayor que $2"
fi

if [ $1 -lt $2 ]
then
  echo "$1 es menor que $2"
fi

if [ $1 -eq $2 ]
then
  echo "$1 es igual a $2"
fi
