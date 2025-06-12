import java.util.Scanner;
public class UT1Problema2{ // DAVID GARCÍA VALERO
     public static void main(String[] args){
           final double poblaciónActual = 312032486; // Entrada de variables finales de población
           double población2025a, población2026a, población2027a, población2028a, población2029a;
           final double segundosAño = 31536000; // Segundos que hay en un año  
                  población2025a = poblaciónActual+segundosAño/7+segundosAño/45-segundosAño/13; // División entre segundos anuales y segundos por cada adición o resta
                  población2026a = población2025a+segundosAño/7+segundosAño/45-segundosAño/13;
                  población2027a = población2026a+segundosAño/7+segundosAño/45-segundosAño/13;
                  población2028a = población2027a+segundosAño/7+segundosAño/45-segundosAño/13;
                  población2029a = población2028a+segundosAño/7+segundosAño/45-segundosAño/13;
                   System.out.println("PROYECCIÓN DE LA POBLACIÓN EN LOS EE. UU.");  // Output de evolución de población
                   System.out.print("-----------------------------------------");
                   System.out.printf("\n   Población actual: %.0f personas", poblaciónActual);
                   System.out.printf("\n   Población 2025: %.0f personas", población2025a);
                   System.out.printf("\n   Población 2026: %.0f personas", población2026a);
                   System.out.printf("\n   Población 2027: %.0f personas", población2027a);
                   System.out.printf("\n   Población 2028: %.0f personas", población2028a);
                   System.out.printf("\n   Población 2029: %.0f personas", población2029a);
                   System.out.println("\n\nSi quieres modificar las tasas de nacimiento, muerte y inmigración, continúe, en caso contrario puede cerrar el programa");
           double segundosNacimiento, segundosInmigrante, segundosFallecimiento;                         // aquí empiezo a crear un Scanner para el ejercicio opcional
           double población2025b, población2026b, población2027b, población2028b, población2029b;
                  Scanner input = new Scanner(System.in);
                   System.out.println("Introduca el número de segundos que pasan hasta que cada siguiente nacimiento se produce ");
                     segundosNacimiento = input.nextDouble();
                   System.out.println("Introduca el número de segundos que pasan hasta que cada siguiente inmigrante se recibe ");
                     segundosInmigrante = input.nextDouble();
                   System.out.println("Introduca el número de segundos que pasan hasta que cada siguiente fallecimiento ocurre ");
                     segundosFallecimiento = input.nextDouble();
                  población2025b = poblaciónActual+segundosAño/segundosNacimiento+segundosAño/segundosInmigrante-segundosAño/segundosFallecimiento; // División entre segundos anuales y segundos por cada adición o resta, más las variables del input del usuario
                  población2026b = población2025b+segundosAño/segundosNacimiento+segundosAño/segundosInmigrante-segundosAño/segundosFallecimiento;
                  población2027b = población2026b+segundosAño/segundosNacimiento+segundosAño/segundosInmigrante-segundosAño/segundosFallecimiento;
                  población2028b = población2027b+segundosAño/segundosNacimiento+segundosAño/segundosInmigrante-segundosAño/segundosFallecimiento;
                  población2029b = población2028b+segundosAño/segundosNacimiento+segundosAño/segundosInmigrante-segundosAño/segundosFallecimiento;
                   System.out.print("PROYECCIÓN DE LA POBLACIÓN EN LOS EE. UU.");  // Output de evolución de población con el input del usuario
                   System.out.print("\n-----------------------------------------");
                   System.out.printf("\n   Población actual: %.0f personas", poblaciónActual);
                   System.out.printf("\n   Población 2025: %.0f personas", población2025b);
                   System.out.printf("\n   Población 2026: %.0f personas", población2026b);
                   System.out.printf("\n   Población 2027: %.0f personas", población2027b);
                   System.out.printf("\n   Población 2028: %.0f personas", población2028b);
                   System.out.printf("\n   Población 2029: %.0f personas", población2029b);
 }
}