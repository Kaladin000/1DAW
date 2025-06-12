/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut2problema1;
import java.util.Scanner;

/**
 *
 * @author David García Valero
 */
public class UT2Problema1 {
    public static void main(String[] args) {
        double sueldoMensual, sueldoAnual, impuesto, sueldoNeto;
        int numPagas;
        Scanner input = new Scanner(System.in);
            System.out.println("Calculadora de impuestos");
            System.out.println("------------------------");
            System.out.println("¿Cuál es tu sueldo mensual? (€):");
            sueldoMensual = input.nextDouble();
            System.out.println("¿Cuál es tu número de pagas anual?:");
            numPagas = input.nextInt();
            sueldoAnual = sueldoMensual*numPagas;
                if (sueldoAnual>=40000){ //Impuestos +40000 euros
                    impuesto = sueldoAnual*0.3;
                    sueldoNeto = sueldoAnual-impuesto;
                    System.out.printf("\nTu sueldo anual es de %.2f €\nTienes que pagar %.2f € de impuestos, no recibes ninguna ayuda\nTu sueldo neto es de %.2f ", sueldoAnual, impuesto, sueldoNeto);
                } else if (sueldoAnual>=15000 && sueldoAnual<40000){ //Impuestos 15000 a 40000 euros
                    impuesto = sueldoAnual*0.2;
                    sueldoNeto = sueldoAnual-impuesto;
                    System.out.printf("\nTu sueldo anual es de %.2f €\nTienes que pagar %.2f € de impuestos, no recibes ninguna ayuda\nTu sueldo neto es de %.2f ", sueldoAnual, impuesto, sueldoNeto);
                } else if (sueldoAnual>=10000 && sueldoAnual<15000){ //Impuestos 10000 a 15000 euros + ayuda
                    impuesto = sueldoAnual*0.2;
                    sueldoNeto = sueldoAnual-impuesto+1500;
                    System.out.printf("\nTu sueldo anual es de %.2f €\nTienes que pagar %.2f € de impuestos, recibes una ayuda de 1500 €\nTu sueldo neto es de %.2f ", sueldoAnual, impuesto, sueldoNeto);
                } else if (sueldoAnual<10000 && sueldoAnual>0) { //No impuestos - de 10000 euros + ayuda
                    sueldoNeto = sueldoAnual+1500;
                    System.out.printf("\nTu sueldo anual es de %.2f €\nNo tienes que pagar impuestos, recibes una ayuda de 1500 €\nTu sueldo neto es de %.2f ", sueldoAnual, sueldoNeto);
                } else System.out.print("\nERROR "); //Error si es 0 o menor que 0
            
    }
}
