package ut6problema2;

/**
 * Clase principal donde se ejecutan las pruebas de
 * alquiler de los distintos barcos.
 * @author David García Valero
 */
public class UT6Problema2 {
    public static void main(String[] args) {
        Barco velero = new Velero("ABC123", 12.5, 2020, 2);
        Barco deportivo = new EmbarcacionDeportiva("DEF456", 10.0, 2021, 200);
        Barco yate1 = new YateDeLujo("GHI789", 15, 2022, 300, 4);
        Barco yate2 = new YateDeLujo("CDE654", 13.5, 2024, 500, 2);

        Alquiler alquiler1 = new Alquiler("Joan Pérez", "12345678A", 4, "A1", velero);
        Alquiler alquiler2 = new Alquiler("Maria García", "87654321B", 5, "A2", deportivo);
        Alquiler alquiler3 = new Alquiler("Cephandrius Hoid", "25496388E", 10, "C3", yate1);
        Alquiler alquiler4 = new Alquiler("Zahel Vasher", "46315722E", 15, "D6", yate2);

        System.out.println("El precio de alquiler del velero es de: " + alquiler1.calcularPrecio() + "€");
        System.out.println("El precio de alquiler del deportivo es de: " + alquiler2.calcularPrecio() + "€");
        System.out.println("El precio de alquiler del yate 1 es de: " + alquiler3.calcularPrecio() + "€");
        System.out.println("El precio de alquiler del yate 2 es de: " + alquiler4.calcularPrecio() + "€");
    } 
}
