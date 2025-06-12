#!/bin/bash


for archivo in $@
do
echo $archivo
cat $archivo
done
