package ut5opciona;

/**JavaApplication1JavaApplication1
 *
 * @author David García Valero
 */
public class UT5OpcionA {
    public static void main(String[] args) {
        Sala sala1 = new Sala("Lamaery", 40);
        Sala sala2 = new Sala("Yreamal", 70);
        
        sala1.mostrarEstado();
        sala2.mostrarEstado();
        
        Reserva reservador1 = new Reserva(sala1, "David García");
        
        reservador1.confirmarReserva();
        
        sala1.mostrarEstado();
        sala2.mostrarEstado();
        
        reservador1.confirmarReserva();
        
        reservador1.cancelarReserva();
        
        sala1.mostrarEstado();
        sala2.mostrarEstado();
        
        System.out.println("Cantidad de reservas de la sala Lamaery: " + reservador1.getCantidadReservas());
    }
    
}
