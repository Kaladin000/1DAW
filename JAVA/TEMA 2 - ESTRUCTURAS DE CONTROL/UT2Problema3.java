/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut2problema3;
import java.util.Scanner;

/**
 *
 * @author David García Valero
 */
public class UT2Problema3 {
    public static void main(String[] args) {
        int añoInput, móduloAño;
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce el año para saber que animal del horóscopo chino es: ");
        añoInput = input.nextInt(); // Error si introduce un número 0 o negativo
            while (añoInput==0){ //(añoInput<=0) en primer caso sin la prueba opcional, para excluir los num negativos
                System.out.println("ERROR, Has introducido el número 0, reinicia el programa");
                break;
            }
        móduloAño = (añoInput-2020)%12; //Saco el resultado de la variable menos el último año de la Rata y calculo su módulo entre 12
        switch (móduloAño){
            case (0): //Al ser el módulo 0, es exacto y será Rata
                System.out.println("Tu horóscopo chino corresponde con la Rata");
            break;
            case (-1): //Ya que el módulo es -1 significa que le sobra un año, entonces es el Cerdo
                System.out.println("Tu horóscopo chino corresponde con la Cerdo");
            break;
            case (-2): //Así sucesivamente
                System.out.println("Tu horóscopo chino corresponde con la Perro");
            break;
            case (-3): 
                System.out.println("Tu horóscopo chino corresponde con la Gallo");
            break;
            case (-4): 
                System.out.println("Tu horóscopo chino corresponde con la Mono");
            break;
            case (-5): 
                System.out.println("Tu horóscopo chino corresponde con la Cabra");
            break;
            case (-6): 
                System.out.println("Tu horóscopo chino corresponde con la Caballo");
            break;
            case (-7): 
                System.out.println("Tu horóscopo chino corresponde con la Serpiente");
            break;
            case (-8): 
                System.out.println("Tu horóscopo chino corresponde con la Dragón");
            break;
            case (-9): 
                System.out.println("Tu horóscopo chino corresponde con la Conejo");
            break;
            case (-10): 
                System.out.println("Tu horóscopo chino corresponde con la Tigre");
            break;
            case (-11): 
                System.out.println("Tu horóscopo chino corresponde con la Buey");
            break;
        }
    }
    
}
