package com.mycompany.proyectomaven1;

import java.util.ArrayList;

/**
 * Clase de padre de las subclases Velero, EmbarcacionDeportiva 
 * y YateDeLujo. 
 * Almacena los atributos matricula, eslora y
 * añoFabricacion, que heredan las subclases.
 * Posee un método calcularFactorBarco abstracto que implementan 
 * las subclases.
 * @author David García Valero
 */
public abstract class Barco {
    
    // ATRIBUTOS
    
    protected String matricula;
    protected double eslora;
    protected int añoFabricacion;
    
    // CONSTRUCTOR
    
    public Barco(String matricula, double eslora, int añoFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.añoFabricacion = añoFabricacion;
    }
    
    // MÉTODOS
    
    public Barco buscar(ArrayList<Barco> vaixells, String matricula) {
        for (int i = 0; i < vaixells.size() ; i++) {
            if (matricula.equals(vaixells.get(i).getMatricula())) {
                return vaixells.get(i);
            }
        }
        return null;
    }
    
    // GETTERS
    
    public String getMatricula() {
        return this.matricula;
    }
    
    public String getEslora() {
        return this.eslora + "";
    }
    
    public String getAñoFabricacion() {
        return this.añoFabricacion + "";
    }
    
    // TO STRING
    
    public String toString() {
        return "matricula=" + this.getMatricula() + ", eslora=" + this.getEslora() + ", anyFabricacio=" + this.getAñoFabricacion();
    }
    
    // MÉTODO ABSTRACTO
    
    public abstract double calcularFactorBarco();
}
