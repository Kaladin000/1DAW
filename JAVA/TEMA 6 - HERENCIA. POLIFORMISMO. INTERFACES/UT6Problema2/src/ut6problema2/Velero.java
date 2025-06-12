package ut6problema2;

/**
 * Subclase de Barco, tiene un atributo único,
 * numeroMasteleros.
 * El factor barco se calcula en base a éste.
 * @author David García Valero
 */
public class Velero extends Barco {
    
    // ATRIBUTO
    
    public double numeroMasteleros;
     
    // CONSTRUCTOR

    public Velero(String matricula, double eslora, int añoFabricacion, double numeroMasteleros) {
        super(matricula, eslora, añoFabricacion);
        this.matricula = matricula;
        this.eslora = eslora;
        this.añoFabricacion = añoFabricacion;
        this.numeroMasteleros = numeroMasteleros;
    }
    
    // MÉTODO
    
    public double calcularFactorBarco() {
        return (eslora*10)+(numeroMasteleros*5);
    }
}
