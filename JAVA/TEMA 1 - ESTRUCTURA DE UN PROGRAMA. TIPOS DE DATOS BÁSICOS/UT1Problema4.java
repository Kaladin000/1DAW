import java.util.Scanner; // DAVID GARCÍA VALERO
public class UT1Problema4{
     public static void main(String[] args){
           double x, y, determinanteSistema, determinanteX, determinanteY; // Variables de los valores que necesito resolver ó encontrar
           double a, b, c, d, e, f; // Variables de valores que ya tengo proporcionados por la ecuación
           a=3.4; b=50.2; c=44.5; d=2.1; e=0.55; f=5.9;
           determinanteSistema = a*e-b*d; // Operaciones para dar con los determinantes y las incógnitas
           determinanteX = c*e-b*f;
           determinanteY = a*f-c*d;
           x = determinanteX/determinanteSistema;
           y = determinanteY/determinanteSistema;
            double comprobaciónY1, comprobaciónY2; // Variables de las dos ecuaciones para la verificación de los resultados sustituyendo la x
            comprobaciónY1 = (c-a*x)/b;
            comprobaciónY2 = (f-d*x)/e;      
             System.out.println("SISTEMA DE ECUACIONES LINEALES 2x2"); // Output resultados 2x2
             System.out.println("----------------------------------");
             System.out.println("3.4x + 50.2y = 44.5");
             System.out.println("2.1x + 0.55y = 5.9");
             System.out.println("\n\nSOLUCIÓN POR CRAMER");
             System.out.println("-------------------");
             System.out.printf("x = %.02f", x);
             System.out.printf("\ny = %.02f", y);
             System.out.println("\n\nCOMPROBACIÓN DADA POR LA 'x'");
             System.out.println("----------------------------");
             System.out.printf("y = %.02f", comprobaciónY1);
             System.out.printf("\ny = %.02f", comprobaciónY2);
             System.out.println("\n\nSi quiere solucionar una ecuación 2x2 mediante Cramer");
             System.out.println("usando sus propios valores, continúe, en caso contrario");
             System.out.println("puede cerrar el programa");
             System.out.println("el orden en la ecuación sería:");
             System.out.println("\na b = c");
             System.out.println("d e = f");
           Scanner input = new Scanner(System.in);
             System.out.println("\nIntroduzca el valor de a: ");
              a = input.nextDouble();
             System.out.println("\nIntroduzca el valor de b: ");
              b = input.nextDouble();
             System.out.println("\nIntroduzca el valor de c: ");
              c = input.nextDouble();
             System.out.println("\nIntroduzca el valor de d: ");
              d = input.nextDouble();
             System.out.println("\nIntroduzca el valor de e: ");
              e = input.nextDouble();
             System.out.println("\nIntroduzca el valor de f: ");
              f = input.nextDouble();
           determinanteSistema = a*e-b*d; // Operaciones para dar con los determinantes y las incógnitas
           determinanteX = c*e-b*f;
           determinanteY = a*f-c*d;
           x = determinanteX/determinanteSistema;
           y = determinanteY/determinanteSistema;
            comprobaciónY1 = (c-a*x)/b;
            comprobaciónY2 = (f-d*x)/e;
             System.out.println("\nSISTEMA DE ECUACIONES LINEALES"); // Output resultados
             System.out.println("------------------------------");
             System.out.printf("%.02fx + %.02fy = %.02f", a, b, c);
             System.out.printf("\n%.02fx + %.02fy = %.02f", d, e, f);
             System.out.println("\n\nSOLUCIÓN POR CRAMER");
             System.out.println("-------------------");
             System.out.printf("x = %.02f", x);
             System.out.printf("\ny = %.02f", y);
             System.out.println("\n\nCOMPROBACIÓN DADA POR LA 'x'");
             System.out.println("----------------------------");
             System.out.printf("y = %.02f", comprobaciónY1);
             System.out.printf("\ny = %.02f", comprobaciónY2);
             System.out.println("\n\nSi quiere solucionar una ecuación 3x3 mediante Cramer"); // Solución Cramer 3x3
             System.out.println("usando sus propios valores, continúe, en caso contrario");
             System.out.println("puede cerrar el programa");
             System.out.println("el orden en la ecuación sería:");
             System.out.println("\na b c = d");
             System.out.println("e f g = h");
             System.out.println("i j k = l");
           double g, h, i, j, k, l; // Variables añadidas para resolver el 3x3
           double z, determinanteZ;
             System.out.println("\nIntroduzca el valor de a: ");
              a = input.nextDouble();
             System.out.println("\nIntroduzca el valor de b: ");
              b = input.nextDouble();
             System.out.println("\nIntroduzca el valor de c: ");
              c = input.nextDouble();
             System.out.println("\nIntroduzca el valor de d: ");
              d = input.nextDouble();
             System.out.println("\nIntroduzca el valor de e: ");
              e = input.nextDouble();
             System.out.println("\nIntroduzca el valor de f: ");
              f = input.nextDouble();
             System.out.println("\nIntroduzca el valor de g: ");
              g = input.nextDouble();
             System.out.println("\nIntroduzca el valor de h: ");
              h = input.nextDouble();
             System.out.println("\nIntroduzca el valor de i: ");
              i = input.nextDouble();
             System.out.println("\nIntroduzca el valor de j: ");
              j = input.nextDouble();
             System.out.println("\nIntroduzca el valor de k: ");
              k = input.nextDouble();
             System.out.println("\nIntroduzca el valor de l: ");
              l = input.nextDouble();        
           determinanteSistema = (a*f*k+e*j*c+i*b*g)-(c*f*i+g*j*a+k*b*e); // Operaciones para dar con los determinantes y las incógnitas del 3x3
           determinanteX = (d*f*k+b*g*l+c*h*j)-(c*f*l+d*g*j+b*h*k);
           determinanteY = (a*h*k+e*l*c+i*d*g)-(c*h*i+g*l*a+k*d*e);
           determinanteZ = (a*f*l+b*h*i+d*e*j)-(d*f*i+a*h*j+b*e*l);
           x = determinanteX/determinanteSistema;
           y = determinanteY/determinanteSistema;
           z = determinanteZ/determinanteSistema;
             System.out.println("\nSISTEMA DE ECUACIONES LINEALES 3x3"); // Output resultados 3x3
             System.out.println("----------------------------------");
             System.out.printf("%.02fx + %.02fy + %.02fz = %.02f", a, b, c, d);
             System.out.printf("\n%.02fx + %.02fy + %.02fz = %.02f", e, f, g, h);
             System.out.printf("\n%.02fx + %.02fy + %.02fz = %.02f", i, j, k, l);
             System.out.println("\n\nSOLUCIÓN POR CRAMER");
             System.out.println("-------------------");
             System.out.printf("x = %.02f", x);
             System.out.printf("\ny = %.02f", y);
             System.out.printf("\nz = %.02f", z);
 }
}