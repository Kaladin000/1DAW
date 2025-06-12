#!/bin/bash

while true
do

echo "/**********BIENVENIDO********/"

echo "1. Cual es mi nombre de usuario"

echo "2. En que directorio estoy"

echo "3. Crea una carpeta en una ruta concreta"

echo "4. Cambia la contrasena de mi usuario"

echo "5. Abre el navegador web Firefox"

echo "6. Descarga un fichero de una ruta determinada"

echo "7. Reinicia el sistema"

echo "0. Salir"

read menu

if [ $menu -eq 1 ]
then
echo $USER
fi

if [ $menu -eq 2 ]
then
pwd
fi

if [ $menu -eq 3 ]
then
sudo mkdir -p /home/usuario/carpeta
fi

if [ $menu -eq 4 ]
then
passwd
fi

if [ $menu -eq 5 ]
then
firefox
fi

if [ $menu -eq 6 ]
then
wget http://mundogeek.net/wp-content/mejor-sistema-operativo.png
fi

if [ $menu -eq 7 ]
then
sudo reboot
fi

if [ $menu -eq 0 ]
then
break
fi

done
