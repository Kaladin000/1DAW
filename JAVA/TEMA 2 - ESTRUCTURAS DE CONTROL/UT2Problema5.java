/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut2problema5;
import java.util.Scanner;
/**
 *
 * @author David García Valero
 */
public class UT2Problema5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double nota, notaMedia, notaMediaAprobados, notaMediaSuspensos;
        double notaTotal = 0; double aprobadosPorcentaje = 0; double suspensosPorcentaje = 0; double totalAprobados = 0; double totalSuspensos = 0;
        double notaTotalAprobados = 0; double notaTotalSuspensos = 0; double notaAlta = 0; double notaBaja = 11;
        double suficiente = 0; double bien = 0; double notable = 0; double excelente = 0;
        double suficientePorcentaje = 0; double bienPorcentaje = 0; double notablePorcentaje = 0; double excelentePorcentaje = 0;
        
        System.out.println("------------------------------");
        System.out.println("--   ESTADÍSTICA DE NOTAS   --");
        System.out.println("------------------------------");
        
        // CONTROL DE VALIDEZ DEL INPUT NOTA
        
            System.out.println("\nIntroduce una nota (valor negativo para finalizar)");
        
        while (input.hasNextDouble()==false) { /* Si no es un Double pedirá de nuevo el input */
            System.out.println("ERROR: Nota inválida");
            input.next();
        } nota = input.nextDouble();
        while (nota>10) { /* Si la nota es mayor a 10 o no es un Double pedirá de nuevo el input */
            System.out.println("ERROR: Nota inválida");
                if (input.hasNextDouble()==false) {
                    System.out.println("ERROR: Nota inválida");
                    input.next();
                }
            nota = input.nextDouble();    
        } 
        
        double notaAnterior = nota; /* Establezco la primera nota como notaAnterior, 
                                       para registrarla y más tarde saber si ésta será la más alta/baja */
        
        // EL PROGRAMA TERMINA SI EL PRIMER VALOR INTRODUCIDO ES NEGATIVO
        
        if (nota <0) {
            System.out.println("No se han introducido notas");
        }
        
        // BUCLE DE LAS NOTAS DE LOS DISTINTOS ALUMNOS
        
        for (double a = 1; nota >=0; a++) {
            
            notaTotal = nota + notaTotal; /* La siguiente nota se le suma a la nota total */
            
            notaMedia = notaTotal/a; /* Se calcula la nota media en base a la nota total calculada, dividido entre el total de alumnos */
           
            
            if (nota >= notaAnterior) {
                if (nota >= notaAlta) {
                   notaAlta = nota; 
                }
            }
                                            // ESTABLECIMIENTO DE LA NOTA MÁS ALTA Y MÁS BAJA
                                            /* Teniendo en cuenta si la nota establecida en el nuevo paso del bucle es mayor/menor o igual a la anterior
                                               y también si es más alta/baja o igual que la nota más alta/baja establecida */
                                            
            if (nota <= notaAnterior) {
                if (nota <= notaBaja) {
                   notaBaja = nota; 
                }
            }
            
            notaAnterior = nota;
            
            
            // CÁLCULOS APROBADOS Y SUSPENSOS
            
            if (nota<5) {
                totalSuspensos++;
                notaTotalSuspensos = nota + notaTotalSuspensos;     // CÁLCULO DE LA NOTA TOTAL DE LOS APROBADOS Y SUSPENSOS         
            } else if (nota >=5) {                                  // CÁLCULO DEL TOTAL DE APROBADOS Y SUSPENSOS
                totalAprobados++;
                notaTotalAprobados = nota + notaTotalAprobados;
            }
            
            if (totalSuspensos >=1) {
                suspensosPorcentaje = totalSuspensos/a*100;
            }                                                       // CÁLCULO PORCENTAJE DE APROBADOS Y SUSPENSOS
            if (totalAprobados >=1) { 
                aprobadosPorcentaje = totalAprobados/a*100;
            }
            
            notaMediaAprobados = notaTotalAprobados/totalAprobados;
                                                                        // CÁLCULO NOTA MEDIA DE APROBADOS Y SUSPENSOS
            notaMediaSuspensos = notaTotalSuspensos/totalSuspensos;
            
            // CÁLCULOS SUFICIENTE BIEN NOTABLE EXCELENTE
            
            if (nota>=5 && nota<6) {
                suficiente++;
            } else if (nota>=6 && nota<7) {
                bien++;                         // TOTAL 
            } else if (nota>=7 && nota<9) {
                notable++;
            } else if (nota>=9 && nota<10) {
                excelente++;
            }
            
            if (suficiente >=1) {
                suficientePorcentaje = suficiente/a*100;
            }
            if (bien >=1) {
                bienPorcentaje = bien/a*100;
            }                                             // PORCENTAJE
            if (notable >=1) {
                notablePorcentaje = notable/a*100;
            }                                                       
            if (excelente >=1) { 
                excelentePorcentaje = excelente/a*100;
            }
            
            // CONTROL DE VALIDEZ DEL INPUT NOTA
            
            System.out.println("Introduce una nota (valor negativo para finalizar)");
            
            while (input.hasNextDouble()==false) { /* Si no es un Double pedirá de nuevo el input */
                System.out.println("ERROR: Nota inválida");
                input.next();
            } nota = input.nextDouble();
            while (nota>10) { /* Si la nota es mayor a 10 o no es un Double pedirá de nuevo el input */
            System.out.println("ERROR: Nota inválida");
                if (input.hasNextDouble()==false) {
                    System.out.println("ERROR: Nota inválida");
                    input.next();
                }
            nota = input.nextDouble();    
        } 
            
            // FIN DEL PROGRAMA + RESULTADOS (SI LA NOTA ES NEGATIVA)
            
            if (nota <0) {
                System.out.printf("\nSe han evaluado un total de %.0f alumnos", a);
                System.out.printf("\nLa nota media ha sido un %.2f", notaMedia);
                System.out.printf("\nHan aprobado %.0f alumnos, lo que supone un %.2f", totalAprobados, aprobadosPorcentaje); System.out.print("% del total");
                
                    if (totalAprobados==0) {
                        System.out.print("\nLa nota media de los alumnos aprobados es inexistente, ya que no hay ningún aprobado");
                    } else
                        System.out.printf("\nLa nota media de los aprobados ha sido un %.2f", notaMediaAprobados);
                System.out.printf("\nHan suspendido %.0f alumnos, lo que supone un %.2f", totalSuspensos, suspensosPorcentaje); System.out.print("% del total");
                    if (totalSuspensos==0) {
                        System.out.print("\nLa nota media de los alumnos suspensos es inexistente, ya que no hay ningún suspenso");
                    } else
                        System.out.printf("\nLa nota media de los aprobados ha sido un %.2f", notaMediaSuspensos);
                    
                System.out.printf("\nLa nota más alta ha sido un %.2f", notaAlta);
                System.out.printf("\nLa nota más baja ha sido un %.2f\n", notaBaja);
                
                System.out.println("\nPARTE OPCIONAL");
                System.out.printf("\nHubo un total de %.0f alumnos con excelente, lo que supone un %.2f", excelente, excelentePorcentaje); System.out.print("% del total");
                System.out.printf("\nHubo un total de %.0f alumnos con notable, lo que supone un %.2f", notable, notablePorcentaje); System.out.print("% del total");
                System.out.printf("\nHubo un total de %.0f alumnos con bien, lo que supone un %.2f", bien, bienPorcentaje); System.out.print("% del total");
                System.out.printf("\nHubo un total de %.0f alumnos con suficiente, lo que supone un %.2f", suficiente, suficientePorcentaje); System.out.print("% del total");
                System.out.printf("\nHubo un total de %.0f alumnos con insuficiente, lo que supone un %.2f", totalSuspensos, suspensosPorcentaje); System.out.print("% del total\n");
                break;
            }
        }
    }
}