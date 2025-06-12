import java.util.Scanner;
public class UT1Problema6{
     public static void main(String[] args){
          int precioBebida, dineroIntroducido, cambio; // Valores enteros del precio de la bebida, el dinero introducid, el cambio, y de las monedas que devolverá
          int monedas50, monedas20, monedas10, monedas5, monedas2, monedas1;
          Scanner input = new Scanner(System.in);
            System.out.println("- MÁQUINA DE BEBIDAS -");
            System.out.printf("----------------------\n");
            System.out.print("Inserte el precio en céntimos de la bebida que quieres: "); // input precio
          precioBebida = input.nextInt();
            System.out.print("Inserte el dinero en céntimos a la máquina: "); // input céntimos
          dineroIntroducido = input.nextInt();
          cambio = dineroIntroducido-precioBebida;
            System.out.println("Tu cambio: " + cambio + " céntimos"); // Se divide el cambio entre el valor de las monedas y se le resta el cambio al valor de las monedas devueltas
          monedas50 = cambio/50;
          cambio = cambio-(monedas50*50);
          monedas20 = cambio/20;
          cambio = cambio-(monedas20*20);
          monedas10 = cambio/10;
          cambio = cambio-(monedas10*10);
          monedas5 = cambio/5;
          cambio = cambio-(monedas5*5);
          monedas2 = cambio/2;
          cambio = cambio-(monedas2*2);
          monedas1 = cambio/1;
            System.out.println("\nMonedas de 50 céntimos devueltas: " + monedas50); // Output monedas devueltas
            System.out.println("Monedas de 20 céntimos devueltas: " + monedas20);
            System.out.println("Monedas de 10 céntimos devueltas: " + monedas10);
            System.out.println("Monedas de 5 céntimos devueltas: " + monedas5);
            System.out.println("Monedas de 2 céntimos devueltas: " + monedas2);
            System.out.println("Monedas de 1 céntimos devueltas: " + monedas1);        
 }
}