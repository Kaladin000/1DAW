#!/bin/bash~

jugador1=""
jugador2=""
marcador1=0
marcador2=0
turno=1

num1=0
numA=0
num2=0
numB=0


function cambiar_turno() {
#si es el turno del primer jugador, la variable turno pasa a ser del jugador 2
#y viceversa

if [ $turno -eq 0 ]
then
turno=1
elif [ $turno -eq 1 ]
then
turno=0
fi

}

function anunciar_ganador() {
#se anuncia el ganador del jugador que tenga no tenga los 20 o más puntos
if [ $marcador1 -ge 20 ]
then
echo "ha ganado $jugador1"
fi

if [ $marcador2 -ge 20 ]
then
echo "ha ganado $jugador2"
fi
}

function tirar_turno() {
#si el turno es del jugador uno, tirar el dado, decir
#que resultado has sacado  y sumar resultado al marcador
#del jugador1 o al jugador 2 si es repetido el dado

#else, si es del jugador2, tirar el dado, decir que
#resultado has sacado  y sumar el resultado al marcador
#del jugador2 o al jugador 1 si es repetido el dado

if [ $turno -eq 0 ]
then
num1=$(( RANDOM % 3 ))

if [ $num1 -eq $numA ]
then
marcador2=$(( marcador2 + num1 ))
else
marcador1=$(( num1 + marcador1 ))
fi

if [ $marcador1 -lt 0 ]
then
marcador1=0
fi

numA=$num1

elif [ $turno -eq 1 ]
then
num2=(( RANDOM % 3 ))

if [ $num2 -eq $numB ]
then
marcador1=$(( marcador1 + num1 ))
else
marcador2=$(( num2 + marcador2 ))
fi

if [ $marcador2 -lt 0 ]
then
marcador2=0
fi

numB=$num2
fi
}


function pintar_hashtag() {
#esta función indicara la puntuación de cada jugador haciendo uso
#de la función bucleAsteriscos, a la que se le pasará el marcador del jugador
pintar=1
echo "$jugador1 ($marcador1):"
buclehashtag
echo
pintar=2
echo "$jugador2 ($marcador2):"
buclehashtag
echo
echo

}

function buclehashtag() {
#esta función pintará tantos asteriscos como puntos tenga el marcador
#del jugador que se le pasa
if [ $pintar -eq 1 ]
then
i=0
while [ $i -lt $marcador1 ]
do
echo -n "#"
((i++))
done
elif [ $pintar -eq 2 ]
then
i=0
while [ $i -lt $marcador2 ]
do
echo -n "#"
((i++))
done
fi
}

function introducir_nombre_jugador() {
#funcion que pide introducir el nombre de los dos jugadores. La función debe
#insistir siempre que no se introduzca el nombdre de alguno de los jugadores
read -p "Introduce el nombre del primer jugador: " jugador1
read -p "Introduce el nombre del segundo jugador: " jugador2
}

function saludo_inicial() {
#funcion que mostrará por pantalla un saludo inicial una vez recopilados
#los nombres de los jugadores
echo "Va a dar comienzo el juego, preparaos $jugador1 y $jugador2"
}

#CUERPO DEL PROGRAMA

echo "BIENVENIDOS AL JUEGO CARRERA DE HASHTAG"

introducir_nombre_jugador

saludo_inicial

#bucle: mientras el marcador de alguno de los dos jugadores no sea 20, repetir
while [ $marcador1 -lt 20 -a $marcador2 -lt 20 ]
do
tirar_turno
pintar_hashtag
cambiar_turno
done
#fin del bucle

anunciar_ganador

#FIN DEL CUERPO DEL PROGRAMA
