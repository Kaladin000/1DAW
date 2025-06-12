/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut7problema1;

/**
 *
 * @author David García Valero
 */
public class UT7Problema1 {
    
    // PARTE UNO
    
    /**
     * Devuelve un array de números aleatorios.
     * @return array de 100 números aleatorios entre 0 y 500
     */
    
    public static double[] arrayAleatorios() {
        double array[] = new double[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random()*500;
        }
        return array;
    }
    
    /**
     * Ejecuta un array arrayAleatorios con un índice aleatorio
     * comprendido entre los números -50 y 150 y imprime un mensaje
     * por pantalla con el número aleatorio junto al índice utilizado.
     */
    
    public static void printAleatorio() {
        double array[] = arrayAleatorios();
        try {
            for (int i = 0; i < 10; i++) {
                int index = (int) (Math.random() * 200) -50;
                System.out.println("Número con el array en la posición aleatoria " + index + ": " + array[index]);
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("El array está fuera de los límites");
        }
    }
    
    // PARTE DOS
    
    /**
     * Divide dos números enteros positivos
     * @param a dividendo
     * @param b divisor
     */
    
    public static void dividirNumerosPositivos(int a, int b) {
        System.out.println(a/b);
        
        // POSTCONDICIONES
        assert b != 0 : "Postcondición violada: el parámetro int b es cero";
        assert b > 0 : "Postcondición violada: el parámetro int b es negativo";
        assert a >= 0 : "Postcondición violada: el parámetro int a es negativo";
    }
    
    public static void main(String[] args) throws Triangle.TriangleIllegalException {
        // PARTE 1: printAleatorio();
        // PARTE 2: Triangle triangle = new Triangle(x,x,x);
        // PARTE 3: dividirNumerosPositivos(x,x);
    }
}
