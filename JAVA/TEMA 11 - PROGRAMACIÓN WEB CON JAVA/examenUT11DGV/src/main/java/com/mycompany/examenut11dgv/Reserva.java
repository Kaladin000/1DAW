/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenut11dgv;

/**
 *
 * @author examenprog
 */
public class Reserva {
    
    // ATRIBUTOS
    
    public String nombre;
    public String tipo;
    public int noches;
    public int huespedes;
    public double precioNoche;
    public String fecha;
    
    // CONSTRUCTOR
    
    public Reserva(String nombre, String tipo, int noches, int huespedes, double precioNoche, String fecha) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.noches = noches;
        this.huespedes = huespedes;
        this.precioNoche = precioNoche;
        this.fecha = fecha;
    }
    
    // MÉTODOS
    
    public double getPrecioTotal() {
        double precioTotal = 0.00;
        if (this.huespedes <= 2) {
            precioTotal = this.noches * (precioNoche);
        } else if (this.huespedes >= 2) {
            precioTotal = this.noches * (precioNoche+((this.huespedes-2)*10));
        } return precioTotal;
    }
}
