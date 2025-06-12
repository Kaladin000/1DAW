package com.mycompany.proyectomaven1;

/**
 * Clase cuya función principal es calcular el precio
 * final del alquiler de un amarre.
 * Almacena los atributos nombre, dni, días de alquiler,
 * posición en el amarre y tipoBarco.
 * @author David García Valero
 */
public class Alquiler {
    
    // ATRIBUTOS
    
    public String nombre;
    public String dni;
    public int dias;
    public String posicion;
    public Barco tipoBarco;
    
    // CONSTRUCTOR
    
    public Alquiler(String nombre, String dni, int dias, String posicion, Barco tipoBarco) {
        this.nombre = nombre;
        this.dni = dni;
        this.dias = dias;
        this.posicion = posicion;
        this.tipoBarco = tipoBarco;
    }
    
    // GETTERS
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getDni() {
        return this.dni;
    }
    
    public String getDias() {
        return "" + dias;
    }
    
    public String getPosicion() {
        return this.posicion;
    }
    
    public String getTipoBarco() {
        return this.tipoBarco.toString();
    }
    
    public String getPreu() {
        return this.calcularPrecio() + " €";
    }
    
    // MÉTODO calcular precio
    
    /**
     * Calcula el el precio del alquiler, teniendo en cuenta
     * el factor barco y los días de amarre.
     * A este precio final se le descuenta un 5%, un 10% o
     * un 15% si los días alquilados son 5, 10 o 15 respectivamente.
     * @return precio final del alquiler
     */
    
    public double calcularPrecio() {
        double precioFinal = dias*(tipoBarco.calcularFactorBarco());
        if (dias >=5 && dias <10) {
            precioFinal = precioFinal-(precioFinal*0.05);
        } else if (dias >=10 && dias <15) {
            precioFinal = precioFinal-(precioFinal*0.1);
        } else if (dias >=15) {
            precioFinal = precioFinal-(precioFinal*0.15);
        }
        return precioFinal;
    }
}
