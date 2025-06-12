/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut2problema4;
import java.util.Scanner;

/**
 *
 * @author David García Valero
 */
public class UT2Problema4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double numSecreto = Math.random()*100;
        int numSecretoInt = (int)numSecreto; // Parte entera del número secreto
        int numUsuario, numIntentos, diferencia;
        int dificultad, dificultadIntentos, puntuación;
        
        System.out.println("BIENVENIDO AL JUEGO DE ADIVINAR EL NÚMERO SECRETO\n");

        System.out.println("SELECCIONA DIFICULTAD, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL, 4 PARTE OBLIGATORIA");
            dificultad = input.nextInt(); //Selección de dificultad OPCIONAl o PARTE OBLIGATORIA
        
        switch (dificultad) {
            
            
            case 1: //FÁCIL (UN DÍGITO)
       
                
        numSecreto = Math.random()*10;
        numSecretoInt = (int)numSecreto; // Parte entera del número secreto 
                
        System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        
        
        // CONTROL DE VALIDEZ DEL INPUT dificultadIntentos
        
        while (input.hasNextInt() == false) { // error si no es un número entero
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        input.next();
        } dificultadIntentos = input.nextInt();
        while (dificultadIntentos <=0 || dificultadIntentos >=4) { // error si es distinto a 1 al 3 o si no es un número entero
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        while (input.hasNextInt() == false) {
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        input.next();
        } dificultadIntentos = input.nextInt();
        }
        
        //SELECCIÓN DE DIFICULTAD EN BASE A LOS INTENTOS
        
        numIntentos = 0;
        
        switch (dificultadIntentos){
            case 1:
                numIntentos = 10;
            break;
            case 2:
                numIntentos = 6;
            break;
            case 3:
                numIntentos = 4;
            break;
        }           
              
        // BUCLE FOR PARA LOS INTENTOS (Fácil 8, Normal 5, Difícil 3)
        
        for (int intento = 1; intento <= numIntentos; intento++) {
            System.out.println("Intento " + intento + ": ");
            
            // CONTROL DE VALIDEZ DEL INPUT numUsuario
            
            while (input.hasNextInt() == false) {
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            input.next();
            } numUsuario = input.nextInt();
            while (numUsuario <0 || numUsuario >9) { // error si es menor que 0 o mayor que 99 o si no es un número entero
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            while (input.hasNextInt() == false) {
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            input.next();
            } numUsuario = input.nextInt();
            }

            // VERIFICAR EL RESULTADO
            
            if (numUsuario == numSecretoInt) {
                System.out.println("¡Enhorabuena, has acertado el número secreto!"); // PUNTUACIÓN
                puntuación = 10 /*puntuación dificultad fácil*/ * 10 * (dificultadIntentos*10) + ((numIntentos-intento) * 500)  /* Intentos restantes */;
                System.out.println("¡HAS CONSEGUIDO " + puntuación + " PUNTOS!");
                break; // Salir si se adivina correctamente
            } else if (numUsuario != numSecretoInt && intento == numIntentos) {
                System.out.println("Has perdido..., el número secreto era " + numSecretoInt);
                break; // Salir si no se adivina cuando se hayan acabado los intentos
            }
            
            //CÁLCULO DE LA DIFERENCIA dando como resultado siempre un número entero (Math.abs)    
            
            diferencia = Math.abs(numUsuario-numSecretoInt);

            if (numUsuario > numSecretoInt) {
                System.out.print("El número introducido es mayor ");
            } else {
                System.out.print("El número introducido es menor ");
            }

            // PISTAS EN BASE A LA DIFERENCIA
        
            if (diferencia >= 7) {
                System.out.println("(Frío)");
            } else if (diferencia >= 4) {
                System.out.println("(Templado)");
            } else {
                System.out.println("(Caliente)");
            }
        }
            break;
            
            
            
            case 2: //NORMAL (DOS DÍGITOS)
   
                
                
        System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        
        
        // CONTROL DE VALIDEZ DEL INPUT dificultadIntentos
        
        while (input.hasNextInt() == false) { // error si no es un número entero
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        input.next();
        } dificultadIntentos = input.nextInt();
        while (dificultadIntentos <=0 || dificultadIntentos >=4) { // error si es distinto a 1 al 3 o si no es un número entero
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        while (input.hasNextInt() == false) {
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        input.next();
        } dificultadIntentos = input.nextInt();
        }
        
        //SELECCIÓN DE DIFICULTAD EN BASE A LOS INTENTOS
        
        numIntentos = 0;
        
        switch (dificultadIntentos){
            case 1:
                numIntentos = 10;
            break;
            case 2:
                numIntentos = 6;
            break;
            case 3:
                numIntentos = 4;
            break;
        }           
              
        // BUCLE FOR PARA LOS INTENTOS (Fácil 8, Normal 5, Difícil 3)
        
        for (int intento = 1; intento <= numIntentos; intento++) {
            System.out.println("Intento " + intento + ": ");
            
            // CONTROL DE VALIDEZ DEL INPUT numUsuario
            
            while (input.hasNextInt() == false) {
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            input.next();
            } numUsuario = input.nextInt();
            while (numUsuario <0 || numUsuario >99) { // error si es menor que 0 o mayor que 99 o si no es un número entero
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            while (input.hasNextInt() == false) {
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            input.next();
            } numUsuario = input.nextInt();
            }

            // VERIFICAR EL RESULTADO
            
            if (numUsuario == numSecretoInt) {
                System.out.println("¡Enhorabuena, has acertado el número secreto!"); // PUNTUACIÓN
                puntuación = 100 /*puntuación dificultad normal*/ * 10 * (dificultadIntentos*10) + ((numIntentos-intento) * 500)  /* Intentos restantes */;
                System.out.println("¡HAS CONSEGUIDO " + puntuación + " PUNTOS!");
                break; // Salir si se adivina correctamente
            } else if (numUsuario != numSecretoInt && intento == numIntentos) {
                System.out.println("Has perdido..., el número secreto era " + numSecretoInt);
                break; // Salir si no se adivina cuando se hayan acabado los intentos
            }
            
            //CÁLCULO DE LA DIFERENCIA dando como resultado siempre un número entero (Math.abs)    
            
            diferencia = Math.abs(numUsuario-numSecretoInt);

            if (numUsuario > numSecretoInt) {
                System.out.print("El número introducido es mayor ");
            } else {
                System.out.print("El número introducido es menor ");
            }

            // PISTAS EN BASE A LA DIFERENCIA
        
            if (diferencia >= 25) {
                System.out.println("(Frío)");
            } else if (diferencia >= 15) {
                System.out.println("(Templado)");
            } else {
                System.out.println("(Caliente)");
            }
        }  
                
                
            break;
            
            
            
            case 3: //DIFÍCIL (TRES DÍGITOS)
       
                
                
        numSecreto = Math.random()*1000;
        numSecretoInt = (int)numSecreto; // Parte entera del número secreto 
                
        System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        
        
        // CONTROL DE VALIDEZ DEL INPUT dificultadIntentos
        
        while (input.hasNextInt() == false) { // error si no es un número entero
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        input.next();
        } dificultadIntentos = input.nextInt();
        while (dificultadIntentos <=0 || dificultadIntentos >=4) { // error si es distinto a 1 al 3 o si no es un número entero
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        while (input.hasNextInt() == false) {
            System.out.println("ERROR");
            System.out.println("SELECCIONA LA DIFICULTAD DE INTENTOS, introduce 1 para FÁCIL, 2 NORMAL, 3 DIFÍCIL");
        input.next();
        } dificultadIntentos = input.nextInt();
        }
        
        //SELECCIÓN DE DIFICULTAD EN BASE A LOS INTENTOS
        
        numIntentos = 0;
        
        switch (dificultadIntentos){
            case 1:
                numIntentos = 10;
            break;
            case 2:
                numIntentos = 6;
            break;
            case 3:
                numIntentos = 4;
            break;
        }           
        
              
        // BUCLE FOR PARA LOS INTENTOS (Fácil 8, Normal 5, Difícil 3)
        
        for (int intento = 1; intento <= numIntentos; intento++) {
            System.out.println("Intento " + intento + ": ");
            
            // CONTROL DE VALIDEZ DEL INPUT numUsuario
            
            while (input.hasNextInt() == false) {
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            input.next();
            } numUsuario = input.nextInt();
            while (numUsuario <0 || numUsuario >999) { // error si es menor que 0 o mayor que 99 o si no es un número entero
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            while (input.hasNextInt() == false) {
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            input.next();
            } numUsuario = input.nextInt();
            }

            // VERIFICAR EL RESULTADO
            
            if (numUsuario == numSecretoInt) {
                System.out.println("¡Enhorabuena, has acertado el número secreto!"); // PUNTUACIÓN
                puntuación = 1000 /*puntuación dificultad difícil*/ * 10 * (dificultadIntentos*10) + ((numIntentos-intento) * 500)  /* Intentos restantes */;
                System.out.println("¡HAS CONSEGUIDO " + puntuación + " PUNTOS!");
                break; // Salir si se adivina correctamente
            } else if (numUsuario != numSecretoInt && intento == numIntentos) {
                System.out.println("Has perdido..., el número secreto era " + numSecretoInt);
                break; // Salir si no se adivina cuando se hayan acabado los intentos
            }
            
            //CÁLCULO DE LA DIFERENCIA dando como resultado siempre un número entero (Math.abs)    
            
            diferencia = Math.abs(numUsuario-numSecretoInt);

            if (numUsuario > numSecretoInt) {
                System.out.print("El número introducido es mayor ");
            } else {
                System.out.print("El número introducido es menor ");
            }

            // PISTAS EN BASE A LA DIFERENCIA
        
            if (diferencia >= 250) {
                System.out.println("(Frío)");
            } else if (diferencia >= 150) {
                System.out.println("(Templado)");
            } else {
                System.out.println("(Caliente)");
            }
        }
            break;
            
            
            
            
            case 4: //PARTE OBLIGATORIA
                
                
                
                
        // CONTROL DE VALIDEZ DEL INPUT numIntentos
        
        System.out.println("¿Cuántos intentos necesitas?: ");
        while (input.hasNextInt() == false) { // error si no es un número entero
            System.out.println("ERROR");
            System.out.println("¿Cuántos intentos necesitas?: ");
        input.next();
        } numIntentos = input.nextInt();
        while (numIntentos <=0 || numIntentos >=11) { // error si es distinto a 1 al 10 o si no es un número entero
            System.out.println("ERROR");
            System.out.println("¿Cuántos intentos necesitas?: ");
        while (input.hasNextInt() == false) {
            System.out.println("ERROR");
            System.out.println("¿Cuántos intentos necesitas?: ");
        input.next();
        } numIntentos = input.nextInt(); 
        }
        
        // BUCLE FOR PARA LOS INTENTOS (Como máximo 10)
        
        for (int intento = 1; intento <= numIntentos; intento++) {
            System.out.println("Intento " + intento + ": ");
            
            // CONTROL DE VALIDEZ DEL INPUT numUsuario
            
            while (input.hasNextInt() == false) {
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            input.next();
            } numUsuario = input.nextInt();
            while (numUsuario <0 || numUsuario >99) { // error si es menor que 0 o mayor que 99 o si no es un número entero
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            while (input.hasNextInt() == false) {
                System.out.println("ERROR");
                System.out.println("Intento " + intento + ": ");
            input.next();
            } numUsuario = input.nextInt();
            }

            // VERIFICAR EL RESULTADO
            
            if (numUsuario == numSecretoInt) {
                System.out.println("¡Enhorabuena, has acertado el número secreto!");
                break; // Salir si se adivina correctamente
            } else if (numUsuario != numSecretoInt && intento == numIntentos) {
                System.out.println("Has perdido..., el número secreto era " + numSecretoInt);
                break; // Salir si no se adivina cuando se hayan acabado los intentos
            }
            
            //CÁLCULO DE LA DIFERENCIA dando como resultado siempre un número entero (Math.abs)    
            
            diferencia = Math.abs(numUsuario-numSecretoInt);

            if (numUsuario > numSecretoInt) {
                System.out.print("El número introducido es mayor ");
            } else {
                System.out.print("El número introducido es menor ");
            }

            // PISTAS EN BASE A LA DIFERENCIA
        
            if (diferencia >= 25) {
                System.out.println("(Frío)");
            } else if (diferencia >= 15) {
                System.out.println("(Templado)");
            } else {
                System.out.println("(Caliente)");
            }
        } break;
        }
    }
    
}
