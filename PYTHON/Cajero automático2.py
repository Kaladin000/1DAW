saldo = float(input("Introduce el saldo inicial: "))
menu = 4
while menu != 0: # Hice el anterior con el while (lo asocio a los menús)
    print()
    print("-----------------")
    print("CAJERO AUTOMÁTICO")
    print("Pulsa 1 para consultar saldo")
    print("Pulsa 2 para retirar dinero")
    print("Pulsa 3 para ingresar dinero")
    print("Pulsa 0 para salir")
    print("-----------------")
    menu = int(input("Introduce un número: "))
    if menu == 1:
        print("")
        print("Tienes " , saldo , "€")
    elif menu == 2:
        retirar = float(input("Introduce la suma a retirar: "))
        saldo = saldo - retirar
    elif menu == 3:
        ingresar = float(input("Introduce la suma a depositar: "))
        saldo = saldo + ingresar
    elif menu == 4:
        break

