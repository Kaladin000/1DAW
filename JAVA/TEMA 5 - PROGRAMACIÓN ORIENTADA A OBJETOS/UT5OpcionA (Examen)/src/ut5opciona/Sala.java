/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut5opciona;

/**
 *
 * @author David García Valero
 */
public class Sala {
   // ATRIBUTOS
    
    private String nombre;
    private int capacidad;
    private boolean reservada;
    
    // CONSTRUCTOR
    
    public Sala(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.reservada = false;
    }
    
    public Sala(String nombre, int capacidad, boolean reservada) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.reservada = reservada;
    }
    
    // MÉTODOS
    
    public Boolean reservar() {
        boolean estabaReservada = false;
        if (this.reservada == true) {
            estabaReservada = true;
        } else if (this.reservada == false) {
            estabaReservada = false;
        }
        this.reservada = true;
        return estabaReservada;
    }
    
    public void liberar() {
        this.reservada = false;
    }
    
    public void mostrarEstado() {
        System.out.println("Esta es la sala " + this.nombre + " su capacidad es de " + this.capacidad + " y este parámetro booleano muestra si está reservada: " + this.reservada);
    }
    
    public boolean isReservada() {
        return this.reservada;
    }
}
