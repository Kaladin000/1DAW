# Inputs

diaSemana = int(input("Introduce el día de la semana: "))
diaMes = int(input("Introduce el día del mes: "))
mes = int(input("Introduce el mes (número): "))
año = int(input("Introduce el año (número): "))

# Día de la semana a String

if diaSemana == 1:
    diaSemanaString = "Lunes"
elif diaSemana == 2:
    diaSemanaString = "Martes"
elif diaSemana == 3:
    diaSemanaString = "Miércoles"
elif diaSemana == 4:
    diaSemanaString = "Jueves"
elif diaSemana == 5:
    diaSemanaString = "Viernes"
elif diaSemana == 6:
    diaSemanaString = "Sábado"
elif diaSemana == 7:
    diaSemanaString = "Domingo"

# Mes a String

if mes == 1:
    mesString = "Enero"
elif mes == 2:
    mesString = "Febrero"
elif mes == 3:
    mesString = "Marzo"
elif mes == 4:
    mesString = "Abril"
elif mes == 5:
    mesString = "Mayo"
elif mes == 6:
    mesString = "Junio"
elif mes == 7:
    mesString = "Julio"
elif mes == 8:
    mesString = "Agosto"
elif mes == 9:
    mesString = "Septiembre"
elif mes == 10:
    mesString = "Octubre"
elif mes == 11:
    mesString = "Noviembre"
elif mes == 12:
    mesString = "Diciembre"

# Print final

print("Hoy es " + diaSemanaString + "," , diaMes , "de " + mesString + " de" , año)