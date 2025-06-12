#!/bin/bash

if [ -e $1 ]
then
  ./$2
elif [ -f $1 ]
then
  cat $2
fi
