package examendgv_ra7;

/**
 *
 * @author David García Valero
 */
final public class CamionAsistencia extends Vehiculo {
    
    // ATRIBUTOS
    
    private Double capacidadCarga;
    private int ejes;
    
    // CONSTRUCTOR
    
    public CamionAsistencia(String numSerie, Double velocidadMax, Double velocidadActual, Double capacidadCarga, int ejes) {
        super(numSerie, velocidadMax, velocidadActual);
        this.capacidadCarga = capacidadCarga;
        this.ejes = ejes;
    }
    
    // MÉTODOS
    
    @Override
    public String tipoVehiculo() {
        return "Camión de asistencia";
    }
}
