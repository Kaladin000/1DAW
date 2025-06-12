nota = float(input("Introduce una nota:"))
if nota < 5:
    print("Insuficiente")
elif nota >= 5 and nota <6:
    print("Suficiente")
elif nota >= 6 and nota <7:
    print("Bien")
elif nota >= 7 and nota <9:
    print("Notable")
elif nota >= 9 and nota <10:
    print("Sobresaliente")
elif nota >= 10:
    print("Matrícula de honor")
