/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut4problema1;
import java.util.Scanner;
/**
 *
 * @author David García Valero
 */
public class UT4Problema1 {
    Scanner input = new Scanner(System.in);
    private static String títulos[] = new String[1000];
    public static void main(String[] args) {
        UT4Problema1 programa = new UT4Problema1();
        programa.inicio();
    }
        public void inicio() {
            System.out.println("GESTIÓN DE TÍTULOS DE LA BIBLIOTECA");
            System.out.println("-----------------------------------");
            System.out.println("1. Añadir un título");
            System.out.println("2. Eliminar un título");
            System.out.println("3. Buscar un título");
            System.out.println("4. Ver la colección");
            System.out.println("5. Ordenar alfabéticamente");
            System.out.println("6. Salir");
            int menú = 0;
            while (menú!=6) {
                
                System.out.println("\nSelecciona una opción: ");
                
                // VALIDACIÓN NUM MENÚ
                
                while (!input.hasNextInt()) {
                    System.out.println("Has introducido un número incorrecto.");
                    input.next();
                } menú=input.nextInt();
                while (menú<=0 || menú>6) {
                    System.out.println("Has introducido un número incorrecto.");
                    if (!input.hasNextInt()) {
                        input.next();
                    } menú=input.nextInt();
                }
                
                // SELECCIÓN MENÚ
                
                if (menú==1) {
                    funciónTítulos.añadir();
                } else if (menú==2) {
                    funciónTítulos.eliminar();
                } else if (menú==3) {
                    funciónTítulos.buscar();
                } else if (menú==4) {
                    funciónTítulos.verColección();
                } else if (menú==5) {
                    funciónTítulos.ordenadoBurbuja(títulos);
                } else if (menú==6) {
                    System.out.println("FIN DEL PROGRAMA");
                    break;
                }
            }
        }
    public class funciónTítulos {
        static Scanner input = new Scanner(System.in);
        public static void añadir() { // MÉTODO PARA AÑADIR TÍTULOS
            System.out.println("Introduce el título para el libro: ");
            String títuloAñadir = inputTítulo();
            int x = 0; // La variable x define si ya existe el título. 0 == existe ; 1 == no existe
            
            // ¿STRING DUPLICADO?
            
            for (int i = 0; i < títulos.length; i++) {
                if (títuloAñadir.equals(títulos[i])) {
                    System.out.println("ERROR: El título del libro introducido ya está en la colección.");
                    break;
                }
                if (títulos.length-1 == i) {
                    x++; // Si en la última instancia del bucle no hay coincidencias, el título no existe ; x==1
                } 
            }
            
            // ASIGNAR STRING AL ARRAY TÍTULOS
            
            if (x==1) { // El if se cumple si no existe el título
                for (int i = 0; i < títulos.length; i++) {
                    if (títulos[i]==null) { // El título seleccionado se añade al primer valor null (vacío/no existente)
                        títulos[i] = títuloAñadir;
                        System.out.println("Se ha añadido el título del libro correctamente.");
                        break;
                    } if (títulos.length-1 == i) {
                        System.out.println("ERROR: La colección está completa");
                    }
                }
            }
        }
        public static void eliminar() { // MÉTODO PARA ELIMINAR TÍTULOS
            System.out.println("Introduce el título del libro a eliminar: ");
            String títuloEliminar = inputTítulo();
            
            int x=0; // Establezco x = 0. Si después del bucle x=0, no se ha encontrado un libro. Si x = 1, el título a eliminar existe
            for (int i = 0; i < títulos.length; i++) {
                if (títuloEliminar.equals(títulos[i])) {
                    System.out.println("Título eliminado correctamente");
                    títulos[i] = null;
                    x++; // x=1, existe el libro.
                } 
                if (x==1 && títulos[i]!=null) {
                    títulos[i-1] = títulos[i]; // Se asigna el título del libro actual al anterior libro
                    títulos[i] = null; // El título actual pasa a ser nulo
                } 
                if (i == 0 && títulos[i]==null && x==0) { // Si en la primera instacia del bucle el primer string del array es nulo significa que no hay colección, ya que no hay un primer libro asignado
                    System.out.println("ERROR: La colección está vacía.");
                    x++; x++; // Anulo la variable x, la dejo sin utilidad.
                    break;
                }
            } if (x==0) {
                System.out.println("El libro " + '"' + títuloEliminar + '"' + " no se encuentra en la colección.");
            }
        }
        public static void buscar() { // MÉTODO PARA BUSCAR TÍTULOS
            System.out.println("Introduce el título del libro a buscar: ");
            String títuloBuscar = inputTítulo();
            
            int x=0; // Establezco x = 0. Si después del bucle x=0, no se ha encontrado un libro.
            for (int i = 0; i < títulos.length; i++) {
                if (títuloBuscar.equals(títulos[i])) {
                    System.out.println("El libro " + '"' + títulos[i] + '"' + " se encuentra en la colección.");
                    x++; // x=1, existe el libro.
                    break;
                } if (i == 0 && títulos[i]==null) { // Si en la primera instacia del bucle el primer string del array es nulo significa que no hay colección, ya que no hay un primer libro asignado
                    System.out.println("ERROR: La colección está vacía.");
                    x++; x++; // Anulo la variable x, la dejo sin utilidad.
                    break;
                }
            } if (x==0) {
                System.out.println("El libro " + '"' + títuloBuscar + '"' + " no se encuentra en la colección.");
            }
        }
        public static void verColección() { // MÉTODO PARA VER LA COLECCIÓN
            for (int i = 0; i < títulos.length; i++) {
                if (i == 0 && títulos[i]!=null) {
                    System.out.println("Títulos en la colección:");
                }
                if (títulos[i]!=null) { // Si el título existe, se mostrará
                    System.out.println(i+1 + ". " + títulos[i] + "."); // Formato de salida del título
                } if (i == 0 && títulos[i]==null) { // Si en la primera instacia del bucle el primer string del array es nulo significa que no hay colección, ya que no hay un primer libro asignado
                    System.out.println("ERROR: La colección está vacía.");
                    break;
                }
            }
        }
        public static String inputTítulo() { // MÉTODO PARA EL INPUT DE LOS TÍTULOS
            String título = input.nextLine();
            while (título.equals("")) { // Si el espacio introducido está vacío, tendrá que introducir otra vez
                System.out.println("No has introducido un título, vuelve a intentarlo.");
                título = input.nextLine();
            } título = título.toUpperCase(); // Paso a mayúsculas el título, para evitar errores
            return título;
        }
        public static void ordenadoBurbuja(String[] array) { // MÉTODO PARA ORDENAR LOS TÍTULOS
            for (int i = 0; i < array.length; i++) {
                for (int j = i+1; j < array.length; j++) {
                    if (array[i]!=null && array[j]!=null) { // Establezco que los valores del array a intercambiar no sean nulos para evitar errores
                        if (array[i].compareTo(array[j])>0) { // Si el primer string es lexicográficamente mayor que el segundo string, éstos se intercambian
                            System.out.println(array[i].compareTo(array[j]));
                            String stringAnterior = array[i];
                            array[i] = array[j];
                            array[j] = stringAnterior;
                        }
                    }
                }
            } if (array[0]==null) {
                System.out.println("ERROR: La colección está vacía.");
            } else if (array[0]!=null) {
                System.out.println("Colección ordenada correctamente");
            }
        }
    }
}
            