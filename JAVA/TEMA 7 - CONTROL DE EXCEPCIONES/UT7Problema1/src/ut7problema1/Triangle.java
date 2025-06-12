/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut7problema1;

/**
 *
 * @author David García Valero
 */

// PARTE TRES

public class Triangle {
    public class TriangleIllegalException extends Exception {
        private String exceptionString;
        
        public TriangleIllegalException(String exceptionString) {
            System.out.println(exceptionString);
        }
    }
    
    private double lado1;
    private double lado2;
    private double lado3;
    
    /**
     * Initializa los datos de un triángulo a partir de los lados dados
     * @param lado1
     * @param lado2
     * @param lado3
     * @throws ut7problema1.Triangle.TriangleIllegalException Dará error si algún lado es igual o inferior a 0
     */
    
    public Triangle(double lado1, double lado2, double lado3) throws TriangleIllegalException {
        // Cláusulas guardia
        if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) throw new TriangleIllegalException("Uno de los lados es igual o inferior a cero");
        if (lado1+lado2 > lado1 || lado1+lado3 > lado2 || lado1+lado2 > lado3) throw new TriangleIllegalException("Un lado es menor a la suma de los otros dos lados");
        
        // Constructor
        this.lado1 = lado1;
        this.lado1 = lado1;
        this.lado1 = lado1;
    }
}
