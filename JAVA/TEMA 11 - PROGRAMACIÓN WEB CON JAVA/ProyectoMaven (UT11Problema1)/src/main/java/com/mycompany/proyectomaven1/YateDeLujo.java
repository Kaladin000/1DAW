package com.mycompany.proyectomaven1;

/**
 * Subclase de Barco, tiene dos atributos únicos,
 * potencia y numCabinas.
 * El factor barco se calcula en base a ellos.
 * @author David García Valero
 */
public class YateDeLujo extends EmbarcacionDeportiva {
    // ATRIBUTO
    
    public int numCabinas;
    
    // CONSTRUCTOR
    
    public YateDeLujo(String matricula, double eslora, int añoFabricacion, int potencia, int numCabinas) {
        super(matricula, eslora, añoFabricacion, potencia);
        this.matricula = matricula;
        this.eslora = eslora;
        this.añoFabricacion = añoFabricacion;
        this.potencia = potencia;
        this.numCabinas = numCabinas;
    }
    
    // GETTERS
    
    public String getNumCabinas() {
        return this.numCabinas + "";
    }
    
    // TO STRING
    
    public String toString() {
        return "matricula=" + this.getMatricula() + ", eslora=" + this.getEslora() + ", anyFabricacio=" + this.getAñoFabricacion() + ", potencia=" + this.potencia + ", cabinas=" + this.numCabinas;
    }
    
    // MÉTODO
    
    public double calcularFactorBarco() {
        return (eslora*10)+((potencia/2)+(numCabinas*10));
    }
}
