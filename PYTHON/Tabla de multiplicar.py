num = int(input("Introduce el número para mostrar su tabla de multiplicar: "))

def multiplicar(): # work smart, not hard :D
    for i in range(11):
        print(num , "x" , i , "=" , num*i)

multiplicar()