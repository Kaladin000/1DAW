/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut7opciona;

/**
 *
 * @author David García Valero
 */
public class CuentaBancaria{
    // ATRIBUTOS
    
    private String titular;
    private double saldo;
    
    // CONSTRUCTOR
    
    public CuentaBancaria(String titular) {
        this.titular = titular;
        saldo = 0;
    }
    
    // MÉTODOS
    
    public void ingresar(double cantidad) {
        try {
            if (cantidad <= 0) {
                throw new CantidadInvalidaException("La cantidad a ingresar es inválida");
            }
            this.saldo = this.saldo + cantidad;
        }
        catch (CantidadInvalidaException e) {
            System.out.println("La cantidad a ingresar es inválida");
        }
    }
    
    public void retirar(double cantidad) {
        try {
            if (cantidad <= 0) {
                throw new CantidadInvalidaException("La cantidad a retirar es inválida");
            } 
        }
        catch (CantidadInvalidaException e1) {  
            System.out.println("La cantidad a retirar es inválida");
        }
        
        try {
            if (saldo < cantidad) {
                throw new SaldoInsuficienteException("El saldo es insuficiente");
            }
            this.saldo = this.saldo - cantidad;
        }
        catch (SaldoInsuficienteException e) {
            System.out.println("El saldo es insuficiente");
        }
        
    }
}

