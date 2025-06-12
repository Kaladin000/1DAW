/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut3problema3;
import java.util.Scanner;
/**
 *
 * @author David García Valero
 */
public class UT3Problema3 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.println("Introduce la medida de la matriz: ");
        
        // Validación INPUT de la medida de la matriz
        
        while (!input.hasNextInt()) {
            System.out.println("Has introducido una medida de matriz errónea, vuelve a intentarlo: ");
            input.next();
        } int medidaMatriz = input.nextInt();
        while (medidaMatriz<=0) {
            System.out.println("Has introducido una medida de matriz errónea, vuelve a intentarlo: ");
                while (!input.hasNextInt()) {
                    System.out.println("Has introducido una medida de matriz errónea, vuelve a intentarlo: ");
                    input.next();
                }
            medidaMatriz = input.nextInt();
        }
        
        // Introducción del array[][] matriz
        
        int matriz[][] = new int[medidaMatriz][medidaMatriz];
        
        // Cálculo y impresión de números aleatorios 0 o 1
        
        System.out.print("\n");
        int j = 0; int aleatorio = 0;
        
        while (j != matriz.length) {
            for (int i = 0; i < matriz.length; i++) {
                double aleatorioDouble = Math.random();
                if (aleatorioDouble>=0.50000) {
                    aleatorio = 1;
                } else if (aleatorioDouble<0.50000) {
                    aleatorio = 0;
                } 
                matriz[i][j] = aleatorio;
                
                System.out.print(matriz[i][j]);
                if (i == matriz.length-1) {
                    System.out.print("\n");
                    j++;
                }
            }
        }
        
        // ANÁLISIS DE LA MATRIZ (Cálculos)
        
        System.out.print("\n");
        int sumaFila = 0;
        int sumaColumna = 0;
        j=0;
        int filaMás1s = 0; int columnaMás1s = 0;
        String stringFilaMás1s = "";
        String stringColumnaMás1s = "";
        String[] fila0s = new String[matriz.length]; int c = 0;
        String[] fila1s = new String[matriz.length]; int d = 0;
        String[] columna0s = new String[matriz.length]; int e = 0;
        String[] columna1s = new String[matriz.length]; int f = 0;
        int sumaTotalMatriz = 0; String matriz0s = null;
        int sumaFilaTotal = 0; int sumaColumnaTotal = 0;
        
        while (j != matriz.length) {
            for (int i = 0; i < matriz.length; i++) {
                sumaFila = matriz[i][j] + sumaFila;
                sumaColumna = matriz[j][i] + sumaColumna;
                
                // Cálculo de la suma de todos los valores de la matriz
                
                sumaFilaTotal = matriz[i][j] + sumaFilaTotal;
                sumaColumnaTotal = matriz[j][i] + sumaColumnaTotal;
                sumaTotalMatriz = sumaFilaTotal+sumaColumnaTotal; // Suma de todos los valores de la matriz
                if (sumaTotalMatriz == 0) { // Si la suma de todos los valores de la matriz es 0
                    matriz0s = "1. La matriz solo tiene ceros"; 
                } else {
                    matriz0s = null;
                }
                
                // Cuando la fila acabe, pasará a la siguiente columna (j++)
                
                if (i == matriz.length-1) {
                    
                    // Establecimiento de strings de filas y columnas con más 1s
                    
                    if (sumaFila>=filaMás1s) {
                        filaMás1s = sumaFila;
                        stringFilaMás1s = "1. " + "Fila " + j + " con mayor número de 1s";
                    }
                    if (sumaColumna>=columnaMás1s) {
                        columnaMás1s = sumaColumna;
                        stringColumnaMás1s = "2. " + "Columna " + j + " con mayor número de 1s";
                    }
                    
                    // Establecimiento de strings de filas y columnas con todo 0s o 1s
                    
                    if (sumaFila==0) {
                        fila0s[c]="3. " + "Fila " + j + " con todo 0s";
                        c++;
                    } else if (sumaFila==matriz.length) {
                        fila1s[d]="3. " + "Fila " + j + " con todo 1s";
                        d++;
                    }
                    
                    if (sumaColumna==0) {
                        columna0s[e]="4. " + "Columna " + i + " con todo 0s";
                        e++;
                    } else if (sumaColumna==matriz.length) {
                        columna1s[f]="4. " + "Columna " + i + " con todo 1s";
                        f++;
                    }
                    sumaFila=0;
                    sumaColumna=0;
                    j++;
                }
            }
        }
        
        // Bucles distintos para establecer el análisis de las 2 diagonales
        
        int sumaDiagonalMayor = 0;
        int sumaSubdiagonal = 0;
        String diagonalMayor = "";
        
        for (int i = 0; i < matriz.length; i++) {
            sumaDiagonalMayor = matriz[i][i] + sumaDiagonalMayor;
            if (sumaDiagonalMayor==0) {
                diagonalMayor = "5. Diagonal mayor con todo 0s";
            } else if (sumaDiagonalMayor==matriz.length) {
                diagonalMayor = "5. Diagonal mayor con todo 1s";
            } else {
                diagonalMayor = "5. Diagonal mayor sin números iguales";
            }
        }
        
        j=matriz.length-1;
        String subdiagonal = "";
        
        for (int k = 0; k < matriz.length; k++ ,j--) {   
            sumaSubdiagonal = matriz[k][j] + sumaSubdiagonal;
                        
            if (sumaSubdiagonal==0) {
                subdiagonal = "6. Subdiagonal con todo 0s";
            } else if (sumaSubdiagonal==matriz.length) {
                subdiagonal = "6. Subdiagonal con todo 1s";
            } else {
                subdiagonal = "6. Subdiagonal sin números iguales";
            }
        }
        
        // ANÁLISIS DE LA MATRIZ (Impresión)
        
        // Impresión filas y columnas con más 1s
        
        if (matriz0s==null) { // Si no existe el texto de que la matriz solo tiene 0s, determinado mediante la suma de todos los valores de la matriz
            System.out.println(stringFilaMás1s);
            System.out.println(stringColumnaMás1s);
        } else if (matriz0s == "1. La matriz solo tiene ceros") {
            System.out.println(matriz0s);
            System.out.println("2. La matriz solo tiene ceros");
        }
        boolean arrayVacío = true;
        
        // Impresión filas con todo 0s o 1s o la no existencia de las mismas
        
        for (int i = 0; i < matriz.length; i++) {
            if (fila0s[i]!=null) { // Si existe texto en el array asignado (!=null) imprimirá el texto
                System.out.println(fila0s[i]);
                arrayVacío = false; // Al haber una fila válida, el array no está vacío
            }
            if (fila1s[i]!=null) {
                System.out.println(fila1s[i]);
                arrayVacío = false;
            } 
            if (i == matriz.length-1) {
                if (arrayVacío == true) { // Si no existen valores para el array String se imprimirá el texto
                    System.out.println("3. No hay filas con el mismo número");
                } 
            }
        }
        
        // Impresión columnas con todo 0s o 1s o la no existencia de las mismas
        
        arrayVacío = true;
        
        for (int i = 0; i < matriz.length; i++) {
            if (columna0s[i]!=null) { // Si existe texto en el array asignado (!=null) imprimirá el texto
                System.out.println(columna0s[i]);
                arrayVacío = false; // Al haber una fila válida, el array no está vacío
            }
            if (columna1s[i]!=null) {
                System.out.println(columna1s[i]);
                arrayVacío = false;
            } 
            if (i == matriz.length-1) {
                if (arrayVacío == true) { // Si no existen valores para el array String se imprimirá el texto
                    System.out.println("4. No hay columnas con el mismo número");
                } 
            }
        }
        System.out.println(diagonalMayor);
        System.out.println(subdiagonal);
    } 
}
