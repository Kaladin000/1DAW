num = 16
numAdivinar = 0
intentos = 3
while num != numAdivinar and intentos != 0:
    numAdivinar = int(input("Adivina el número: "))
    intentos -= 1
if intentos == 0 and numAdivinar != num:
    print("Has perdido...")
else:
    print("¡Has acertado!")