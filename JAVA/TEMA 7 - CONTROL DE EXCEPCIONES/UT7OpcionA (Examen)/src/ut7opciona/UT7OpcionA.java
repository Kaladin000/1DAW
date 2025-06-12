/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut7opciona;

/**
 *
 * @author David García Valero
 */
public class UT7OpcionA {
    public static void main(String[] args) throws CantidadInvalidaException, SaldoInsuficienteException {
        CuentaBancaria cuenta1 = new CuentaBancaria("David");
        
        cuenta1.ingresar(-1);
        
        System.out.println("Operación finalizada");
        
        cuenta1.retirar(-1);
        
        System.out.println("Operación finalizada");
        
        cuenta1.retirar(5);
        
        System.out.println("Operación finalizada");
    }
    
}
