#!/bin/bash

fichero1=$1
fichero2=$2

mv $fichero1 temporal

mv $fichero2 $fichero1

mv temporal $fichero2
