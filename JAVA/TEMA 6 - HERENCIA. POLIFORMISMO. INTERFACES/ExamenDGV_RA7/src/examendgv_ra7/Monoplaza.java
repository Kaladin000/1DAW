package examendgv_ra7;

/**
 *
 * @author David García Valero
 */
public class Monoplaza extends Vehiculo implements Penalizable {
    
    // ATRIBUTOS
    
    private Boolean tieneAleron;
    private Double cargaAerodinamica;
    
    // CONSTRUCTOR
    
    public Monoplaza(String numSerie, Double velocidadMax, Double velocidadActual, Boolean tieneAleron, Double cargaAerodinamica) {
        super(numSerie, velocidadMax, velocidadActual);
        this.tieneAleron = tieneAleron;
        this.cargaAerodinamica = cargaAerodinamica;
    }
    
    // MÉTODOS
    
    @Override
    public void acelerar(Double cantidad){
        cantidad = cantidad*this.cargaAerodinamica;
        super.acelerar(cantidad);
    }
    
    
    @Override
    public int calcularPenalizacion() {
        int penalizacion = 0;
        if (super.getVelocidadActual() > 120.00) {
            penalizacion = (int) Math.round(((super.getVelocidadActual()-120)/10));
        } return penalizacion;
    }
    
    @Override
    public String tipoVehiculo() {
        return "Monoplaza";
    }
}
