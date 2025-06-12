import java.util.Scanner;  // DAVID GARCÍA VALERO
public class UT1Problema1{
     public static void main(String[] args){
          System.out.println("Bienvenido a la calculadora geométrica de TechVille, debe introducir los datos para calcular el área y perímetro de su círculo, su triángulo y su cuadrado");
           final double pi = Math.PI;
           double radio, áreaCírculo, perímetroCírculo;
           double alturaTriángulo, baseTriángulo, áreaTriángulo, perímetroTriángulo;
           double lado1Triángulo, lado2Triángulo, lado3Triángulo;
           double baseRectángulo, alturaRectángulo, áreaRectángulo, perímetroRectángulo;
             Scanner input = new Scanner(System.in);
               System.out.println("Dime el valor del radio de su círculo: "); //Área y Perímetro del Círculo
                 radio = input.nextDouble();
                áreaCírculo = pi*Math.pow(radio, 2);
                perímetroCírculo = 2*pi*radio;
               System.out.println("Dime el valor de la altura de su triángulo: ");  //Área y Perímetro del Triángulo
                 alturaTriángulo = input.nextDouble();
               System.out.println("Dime el valor de la base de su triángulo: ");
                 baseTriángulo = input.nextDouble();
               System.out.println("Dime el valor de el primero de tres lados del triángulo: ");
                 lado1Triángulo = input.nextDouble();
               System.out.println("Dime el valor de el segundo de tres lados del triángulo: ");
                 lado2Triángulo = input.nextDouble();
               System.out.println("Dime el valor de el tercero de tres lados del triángulo: ");
                 lado3Triángulo = input.nextDouble();
                áreaTriángulo = (baseTriángulo*alturaTriángulo)/2;
                perímetroTriángulo = lado1Triángulo+lado2Triángulo+lado3Triángulo;
               System.out.println("Dime el valor de la altura de su rectángulo "); //Área y Perímetro del Rectángulo
                 alturaRectángulo = input.nextDouble();
               System.out.println("Dime el valor de la base de su rectángulo ");
                 baseRectángulo = input.nextDouble();
                áreaRectángulo = baseRectángulo*alturaRectángulo;
                perímetroRectángulo = 2*(baseRectángulo+alturaRectángulo);
             System.out.printf("El área de su círculo es %.2f y su perímetro es %.2f el área de su triángulo es %.2f y su perímetro es %.2f el área de su rectángulo es %.2f y su perímetro es %.2f", áreaCírculo, perímetroCírculo, áreaTriángulo, perímetroTriángulo, áreaRectángulo, perímetroRectángulo); //Output de áreas y perímetros

               System.out.println("\nSi quieres calcular la hipotenusa continúe añadiendo datos, en caso contrario, puede cerrar el programa"); //Hipotenusa del Triángulo
           double cateto1, cateto2, hipotenusa;  
               System.out.println("Dime el valor del primer cateto del triángulo ");
                 cateto1 = input.nextDouble();
               System.out.println("Dime el valor del segundo cateto del triángulo ");
                 cateto2 = input.nextDouble();
                hipotenusa = Math.sqrt(Math.pow(cateto1, 2)+Math.pow(cateto2, 2));
             System.out.printf("La hipotenusa de su triángulo es %.2f", hipotenusa); 

               System.out.println("\nSi quieres calcular el área y perímetro de un pentágono continúe añadiendo datos, en caso contrario, puede cerrar el programa"); //Área y Perímetro Pentágono
           double apotema, ladoPentágono;
           double áreaPentágono, perímetroPentágono; 
               System.out.println("Dime el valor del apotema del pentágono ");
                 apotema = input.nextDouble();
               System.out.println("Dime el valor del lado del pentágono ");
                 ladoPentágono = input.nextDouble();
                perímetroPentágono = ladoPentágono*5;
                áreaPentágono = (perímetroPentágono*apotema)/2;
             System.out.printf("El área de su pentágono es %.2f y su perímetro %.2f", áreaPentágono, perímetroPentágono);

             System.out.println("\nGracias por usar la calculadora geométrica de TechVille");       
 }
}
