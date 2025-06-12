/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ut4problema2;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author David García Valero
 */
public class UT4Problema2 {
    private static final int LONGITUDPALABRA = leerRespuesta.longitudPalabra(); // Excepción de variable global para mi variable constante LONGITUD DE PALABRA
    public static void main(String[] args) {
        UT4Problema2 programa = new UT4Problema2();
        programa.inicio();
    }
    public void inicio() {
        String palabraSecreta = generarPalabra.palabraAleatoria();
        String respuestaUsuario = "";
        do { // Preguntará al usuario y generará una pista mientras que la respuesta del usuario no sea igual que la palabra secreta
        respuestaUsuario = leerRespuesta.respuesta();
        resolverRespuesta.generarPista(palabraSecreta, respuestaUsuario);
        } while (resolverRespuesta.respuestaCorrecta(palabraSecreta, respuestaUsuario) == false);
    }
    public class generarPalabra {
        public static char letraAleatoria() { // Tenemos en cuenta que el alfabeto inglés tiene 26 letras en total
            Random alfabeto = new Random();
            int numAlfabeto = alfabeto.nextInt(25); // Genera un num en base al total de letras
            String alfabetoInglés = "abcdefghijklmnopqrstuvwxyz";
            char letraAleatoria = 0;
            for (int i = 0; i < 26; i++) {
                if (numAlfabeto == i) {
                    letraAleatoria = alfabetoInglés.charAt(i); // Selecciona el carácter teniendo en cuenta el string del alfabeto y el num aleatorio
                }
            }
            return letraAleatoria;
        }
        public static String palabraAleatoria() {
            String palabra = "";
            for (int i = 0; i < LONGITUDPALABRA; i++) {
                char letra = letraAleatoria();
                String letraString = String.valueOf(letra); // la letra aleatoria pasa a ser String
                palabra = palabra.concat(letraString); // Concateno la letra al string palabra
            }
            return palabra;
        }
        
    }
    public class leerRespuesta {
        public static Scanner input = new Scanner (System.in);
        public static int longitudPalabra() { // Validación para la longitud de Palabra
            System.out.println("Elige la longitud de la palabra: ");
            while (!input.hasNextInt()) {
                System.out.println("No has introducido un número entero, vuelve a intentarlo: ");
                input.next();
            }
            int longitud = input.nextInt();
            while (longitud <=0) {
                System.out.println("Has introducido un número igual o menor a 0, vuelve a intentarlo: ");
                while (!input.hasNextInt()) {
                    System.out.println("No has introducido un número entero, vuelve a intentarlo: ");
                    input.next();
                } longitud = input.nextInt();
            } input.nextLine(); // Limpio la entrada
            return longitud;
        }
        public static String leerCadenaTexto() {
            String cadenaTexto = input.nextLine();
            return cadenaTexto;
        }
        public static String respuesta() {
            String respuesta = "";
            boolean letraMayus = true; // Establezco de base que si la respuesta tiene algún número o mayúscula la validación se repetirá
            boolean num = true;
            int caracterRaro = 0;
            System.out.println("\nEscribe " + LONGITUDPALABRA + " letras minúsculas: ");
            while (respuesta.length() != LONGITUDPALABRA || letraMayus == true || num == true || caracterRaro > 26*LONGITUDPALABRA-(LONGITUDPALABRA)) {
                caracterRaro = 0;
                respuesta = leerCadenaTexto();
                
                while (respuesta.length() != LONGITUDPALABRA) { // Si la palabra no tiene las mismas letras que la longitud de la palabra a encontrar tendrá que introducir de nuevo la palabra
                    System.out.println("Has de introducir " + LONGITUDPALABRA + " letras. Vuelve a intentarlo.");
                    respuesta = leerCadenaTexto();
                }
                
                boolean repetir = false;
                String alfabetoMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String alfabeto = "abcdefghijklmnopqrstuvwxyz";
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < LONGITUDPALABRA; j++) {
                        String nums = "0123456789"; // Puesto que hasNextDouble no se vuelve true si antes hay caracteres, prefiero identificar si "respuesta" tiene un carácter número
                        if (respuesta.charAt(j) == alfabetoMayus.charAt(i)) { // Si la respuesta tiene un número se repetira la validación
                            repetir = true;
                        }
                        if (i < 10) {
                            if (respuesta.charAt(j) == nums.charAt(i)) { // Si la respuesta tiene una mayúscula se repetira la validación
                                repetir = true;
                            }
                        }
                        if (respuesta.charAt(j) != alfabeto.charAt(i)) {
                            caracterRaro++; // Sumo el total de veces que existe una discrepancia entre la letra actual y la letra del alfabeto actual.
                                            // Hay un total de 26*LONGITUDPALABRA-LONGITUDPALABRA discrepancias si no existen caracteres raros.
                                            // Si hay alguna discrepancia de más, existe un caracter raro, por tanto se repetirá la validación.
                        } 
                    }
                                                                                                                        // EN LA ÚLTIMA INSTANCIA DEL BUCLE
                    if (i == 25 && repetir == false && caracterRaro <= 26*LONGITUDPALABRA-(LONGITUDPALABRA)) { // Si repetir no es true y caracterRaro no es true, se asignará dicha respuesta como válida
                        letraMayus = false;
                        num = false;
                    } else if (i == 25 && repetir == true || caracterRaro > 26*LONGITUDPALABRA-(LONGITUDPALABRA)) { // Si existe alguna discrepancia, se repite la validación
                        System.out.println("Has de introducir " + LONGITUDPALABRA + " letras. Vuelve a intentarlo.");
                    }
                }
            }
            return respuesta;
        }   
    }
    public class resolverRespuesta {
        public static boolean respuestaCorrecta(String S1, String S2) { // Si el primer string es igual que el segundo devuelve true, en caso contrario, false
            boolean respuestaCorrecta = false;
            if (S1.equals(S2)) {
                respuestaCorrecta = true;
            } else if (!S1.equals(S2)) {
                respuestaCorrecta = false;
            }
            return respuestaCorrecta;
        }
        public static void generarPista(String S1, String S2) {
            String resolverRespuesta = "La respuesta es [";
            String alfabeto = "abcdefghijklmnopqrstuvwxyz";
            int numStringS1 = 0;
            int numStringS2 = 0;
            int longitudResta = LONGITUDPALABRA;
            for (int i = 0; i < LONGITUDPALABRA; i++) {
                longitudResta -= 1;
                for (int k = 0; k < 26; k++) {
                    for (int j = 0; j < LONGITUDPALABRA-longitudResta; j++) { // Establezco el número de posición en el alfabeto de cada carácter 
                        if (S1.charAt(j) == alfabeto.charAt(k)) {
                            numStringS1 = k;
                        }
                        if (S2.charAt(j) == alfabeto.charAt(k)) {
                            numStringS2 = k;
                        }
                    }
                }
                if (S1.charAt(i) == S2.charAt(i)) {
                    resolverRespuesta = resolverRespuesta.concat("0"); // Si los caracteres son iguales mostrará un 0 como pista.
                } else if (Math.abs(numStringS1-numStringS2) < 10 && S1.charAt(i) != S2.charAt(i)) { // Si la diferencia de la posición de los dos caracteres en el alfabeto es menor que 10, mostrará un X como pista.
                    resolverRespuesta = resolverRespuesta.concat("X");
                } else {
                    resolverRespuesta = resolverRespuesta.concat("-"); // Si la diferencia es igual o mayor a 10, mostrará un - como pista.
                }
                if (i == LONGITUDPALABRA-1) {
                    resolverRespuesta = resolverRespuesta.concat("]. ");
                }
            }
            boolean respuestaCorrecta;
            respuestaCorrecta = respuestaCorrecta(S1,S2);
            if (respuestaCorrecta == true) {
                System.out.println(resolverRespuesta + "¡Has acertado!");
            } else if (respuestaCorrecta == false) {
                System.out.println(resolverRespuesta + "Inténtalo de nuevo");
            }
        }
    }
}
