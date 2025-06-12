/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interval;

/**
 *
 * @author Kaladin
 */
public class PruebaInterval {
    public static void main(String[] args) {
        Interval intervalo1 = new Interval(-1,7);
        Interval[] intervalArray = intervalo1.trossejar(4);
        for (int i = 0; i < intervalArray.length; i++) {
            intervalArray[i].mostrar();
        }
        Interval intervaloUnir = intervalo1.unir(intervalo1);
        intervaloUnir.mostrar();
    }
}
