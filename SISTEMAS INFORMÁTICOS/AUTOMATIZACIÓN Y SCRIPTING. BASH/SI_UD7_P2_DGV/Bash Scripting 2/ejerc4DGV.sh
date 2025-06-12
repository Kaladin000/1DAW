#!/bin/bash

a=$1
b=$2

if [ $1 -gt $2 ]
then
  echo "$1 es mayor que $2"
fi

if [ $1 -lt $2 ]
then
  echo "$2 es mayor que $1"
fi
