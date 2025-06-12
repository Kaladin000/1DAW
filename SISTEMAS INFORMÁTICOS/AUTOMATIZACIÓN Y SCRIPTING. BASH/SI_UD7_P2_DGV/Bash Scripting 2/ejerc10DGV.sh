#!/bin/bash

if  [ ! -e Seguridad  ]
then
  mkdir Seguridad
fi

cp $@ Seguridad
