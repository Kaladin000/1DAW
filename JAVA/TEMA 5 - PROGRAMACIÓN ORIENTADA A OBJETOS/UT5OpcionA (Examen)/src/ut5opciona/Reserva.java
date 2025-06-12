/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut5opciona;

/**
 *
 * @author David García Valero
 */
public class Reserva {
    // ATRIBUTOS
    
    private Sala sala;
    private String responsable;
    private int totalReservas;
    
    // CONSTRUCTOR
    
    public Reserva(Sala sala, String responsable) {
        this.sala = sala;
        this.responsable = responsable;
        this.totalReservas = 0;
    }
    
    // MÉTODOS
    
    public void confirmarReserva() {
        boolean estabaReservada = this.sala.reservar();
        if (estabaReservada == false) {
            totalReservas++;
            System.out.println("La reserva ha sido confimada por " + this.responsable);
        } else if (estabaReservada == true) {
            System.out.println("La sala no se ha podido reservar");
        }
    }
    
    public void cancelarReserva() {
        this.sala.liberar();
        System.out.println("La reserva de la sala ha sido cancelada");
    }
    
    public int getCantidadReservas() {
        return this.totalReservas;
    }
}
