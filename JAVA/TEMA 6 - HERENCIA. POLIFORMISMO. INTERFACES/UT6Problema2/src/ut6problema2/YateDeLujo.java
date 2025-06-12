package ut6problema2;

/**
 * Subclase de Barco, tiene dos atributos únicos,
 * potencia y numCabinas.
 * El factor barco se calcula en base a ellos.
 * @author David García Valero
 */
public class YateDeLujo extends Barco {
    // ATRIBUTO
    
    public int potencia;
    public int numCabinas;
    
    // CONSTRUCTOR
    
    public YateDeLujo(String matricula, double eslora, int añoFabricacion, int potencia, int numCabinas) {
        super(matricula, eslora, añoFabricacion);
        this.matricula = matricula;
        this.eslora = eslora;
        this.añoFabricacion = añoFabricacion;
        this.potencia = potencia;
        this.numCabinas = numCabinas;
    }
    
    // MÉTODO
    
    public double calcularFactorBarco() {
        return (eslora*10)+((potencia/2)+(numCabinas*10));
    }
}
