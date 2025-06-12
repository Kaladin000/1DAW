package examendgv_ra7;

/**
 *
 * @author David García Valero
 */
public abstract class Vehiculo {
    
    // ATRIBUTOS
    
    private String numSerie;
    private Double velocidadMax;
    private Double velocidadActual;
    
    // CONSTRUCTOR
    
    public Vehiculo(String numSerie, Double velocidadMax, Double velocidadActual) {
        this.numSerie = numSerie;
        this.velocidadMax = velocidadMax;
        this.velocidadActual = velocidadActual;
    }
    
    // MÉTODOS
    
    public Double getVelocidadActual() {
        return velocidadActual;
    }
    
    public void acelerar(Double cantidad) {
        if (cantidad >= 0) {
             this.velocidadActual = this.velocidadActual + cantidad;
        }
        if (this.velocidadActual > velocidadMax) {
            this.velocidadActual = velocidadMax;
        }
    }
    
    public void frenar(Double cantidad) {
        if (cantidad >= 0) {
             this.velocidadActual = this.velocidadActual - cantidad;
        }
        if (this.velocidadActual < 0.00) {
            this.velocidadActual = 0.00;
        }
    }
    
    final public void paradaEnBoxes() {
        this.velocidadActual = 0.00;
    }
    
    public abstract String tipoVehiculo();
    
    public String mostrarInfo() {
        return "Número de serie: " + this.numSerie + " - Velocidad máxima: " + this.velocidadMax + " - Velocidad actual: " + this.velocidadActual;
    }
}
