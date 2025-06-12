package ut6problema2;

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

    // MÉTODO ABSTRACTO
    
    public abstract double calcularFactorBarco();
}
