/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenut2;
import java.util.Scanner;
/**
 *
 * @author David García Valero
 */
public class ExamenUT2 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        
        // PEDIR ALTURA
        
        System.out.println("Introduce la altura de la figura");
        int altura;
        while (!input.hasNextInt()) {
            System.out.println("ERROR. Has introducido un número no entero. Vuelve a intentarlo.");
            input.next();
        } altura = input.nextInt();
        while (altura <=0) {
            System.out.println("ERROR. Has introducido un número menor o igual a 0. Vuelve a intentarlo.");
            while (!input.hasNextInt()) {
                System.out.println("ERROR. Has introducido un número no entero. Vuelve a intentarlo.");
                input.next();
            }
            altura = input.nextInt();
        }
        
        // CONSTRUIR PIRÁMIDE
        
        int espacios = altura-1;
        int espacioLetras = 1;
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int numAlfabeto = 0;
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < espacios; j++) {
                System.out.print(" ");
            }
            espacios--;
            for (int k = 0; k < espacioLetras; k++) {
                System.out.print(alfabeto.charAt(numAlfabeto));
                numAlfabeto++;
                if (numAlfabeto==26) {
                    numAlfabeto=0;
                }
            }
            espacioLetras++; espacioLetras++;
            System.out.println("");
        }
    }
    
}
