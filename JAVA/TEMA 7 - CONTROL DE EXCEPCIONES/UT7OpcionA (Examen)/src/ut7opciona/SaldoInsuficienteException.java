/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut7opciona;

/**
 *
 * @author David García Valero
 */
public class SaldoInsuficienteException extends Exception {
    // ATRIBUTOS
    
    public String message;
    public double numero;
    
    // CONSTRUCTOR
    
    public SaldoInsuficienteException(String message) {
        this.message = message;
    }
    
    // MÉTODOS
    
    @Override
    public String getMessage() {
        return this.message;
    }
}
