#!/bin/bash

while true
do

echo "**SCRIPT CREADO POR DGV**"

echo "1. Listar ficheros"

echo "2. Ver directorios de trabajo"

echo "3. Crear directorio"

echo "4. Borrar directorio"

echo "5. Crear usuario"

echo "6. Borrar usuario"

echo "7. Salir"

read menu

if [ $menu -eq 1 ]
then
ls -l
fi

if [ $menu -eq 2 ]
then
pwd
fi

if [ $menu -eq 3 ]
then
read directorio
sudo mkdir -p $directorio
fi

if [ $menu -eq 4 ]
then
read directorioBorrar
sudo rm -r $directorioBorrar
fi

if [ $menu -eq 5 ]
then
if [ $(id -u) -ne 0 ]
then
echo "No eres root, no puedes agregar un usuario"
exit
fi

read usuario
adduser $usuario

fi

if [ $menu -eq 6 ]
then
if [ $(id -u) ne 0 ]
then
echo "No eres root, no puedes borrar un usuario"
exit
fi

read usuarioBorrar
sudo deluser $usuarioBorrar
fi

if [ $menu -eq 7 ]
then
break
fi

done
