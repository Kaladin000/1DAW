package ut6problema2;

/**
 * Subclase de Barco, tiene un atributo único,
 * potencia.
 * El factor barco se calcula en base a éste.
 * @author David García Valero
 */
public class EmbarcacionDeportiva extends Barco {

    // ATRIBUTO
    
    public int potencia;
    
    // CONSTRUCTOR
    
    public EmbarcacionDeportiva(String matricula, double eslora, int añoFabricacion, int potencia) {
        super(matricula, eslora, añoFabricacion);
        this.matricula = matricula;
        this.eslora = eslora;
        this.añoFabricacion = añoFabricacion;
        this.potencia = potencia;
    }
    
    // MÉTODO
    
    public double calcularFactorBarco() {
        return (eslora*10)+(potencia/2);
    }
}
