package ut12problema1;

import java.util.ArrayList;
import java.util.Scanner;
import static ut12problema1.DadesMetereologiques.datos;

/**
 *
 * @author David García Valero
 */
public class UT12Problema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DadesMetereologiques.conseguirDatos();
        System.out.println();
        int menu = 0;

        while (menu != 5) {

            ArrayList<String> ciudades = new ArrayList<>(datos.keySet());
            System.out.println("---------- TEMPERATURES ----------");
            System.out.println("---- 1. MOSTRAR CIUTAT        ----");
            System.out.println("---- 2. MÁXIMA TEMPERATURA    ----");
            System.out.println("---- 3. MÍNIMA TEMPERATURA    ----");
            System.out.println("---- 4. MÁXIMA PRECIPITACIÓ   ----");
            System.out.println("---- 5. EIXIR                 ----");
            System.out.println("----------------------------------");
            System.out.println("Introdueix opció (1-5):");
            while (!input.hasNextInt()) {
                System.out.println("No has introducido un número entero");
                input.next();
            }
            menu = input.nextInt();
            while (menu < 1 || menu > 5) {
                System.out.println("No has introducido un número del uno al 5");
                while (!input.hasNextInt()) {
                    System.out.println("No has introducido un número entero");
                    input.next();
                }
                menu = input.nextInt();
            }
            input.nextLine();
            

            switch (menu) {
                case 1 -> {
                    System.out.println();
                    System.out.println("Introdueix ciutat: ");

                    String ciudad = input.nextLine();
                    
                    // Esto le pone mayúscula a la primera letra de la ciudad
                    
                    String cambiarCiudad = ciudad.toUpperCase();
                    ciudad = cambiarCiudad.charAt(0) + ciudad.substring(1);
                    System.out.println();

                    for (int i = 0; i < datos.size(); i++) {
                        if ((ciudades.get(i)).contains(ciudad)) {
                            String datosCiudad = datos.get(ciudades.get(i));
                            String[] registros = datosCiudad.split(";");

                            System.out.println(registros[0] + " (" + registros[1] + ")");
                            System.out.println("----------------------------------");
                            System.out.println("Temperatura màxima: " + registros[2] + "°C");
                            System.out.println("Hora T. máxima " + registros[3]);
                            System.out.println("Temperatura mínima: " + registros[4] + "°C");
                            System.out.println("Hora T. mínima " + registros[5]);
                            System.out.println("Diferència temperatures: " + (Double.parseDouble(registros[2]) - Double.parseDouble(registros[4])) + "°C");
                            System.out.println("Precipitació en litres: " + registros[6]);
                            System.out.println("----------------------------------");
                            System.out.println();
                        }
                    }

                }
                case 2 -> {
                    System.out.println();
                    Double temperaturaMaxima = 0.00;
                    String registro0 = "";
                    String registro1 = "";
                    String registro2 = "";
                    String registro3 = "";
                    String registro4 = "";
                    String registro5 = "";
                    String registro6 = "";
                    for (int i = 0; i < datos.size(); i++) {
                        String datosCiudad = datos.get(ciudades.get(i));
                        String[] registros = datosCiudad.split(";");
                        if (Double.parseDouble(registros[2]) >= temperaturaMaxima) {
                            temperaturaMaxima = Double.parseDouble(registros[2]);
                            registro0 = registros[0];
                            registro1 = registros[1];
                            registro2 = registros[2];
                            registro3 = registros[3];
                            registro4 = registros[4];
                            registro5 = registros[5];
                            registro6 = registros[6];
                        }

                        if (i == datos.size() - 2) {
                            System.out.println(registro0 + " (" + registro1 + ")");
                            System.out.println("----------------------------------");
                            System.out.println("Temperatura màxima: " + registro2 + "°C");
                            System.out.println("Hora T. máxima " + registro3);
                            System.out.println("Temperatura mínima: " + registro4 + "°C");
                            System.out.println("Hora T. mínima " + registro5);
                            System.out.println("Diferència temperatures: " + (Double.parseDouble(registro2) - Double.parseDouble(registro4)) + "°C");
                            System.out.println("Precipitació en litres: " + registro6);
                            System.out.println("----------------------------------");
                            System.out.println();
                        }
                    }
                }
                case 3 -> {
                    System.out.println();
                    Double temperaturaMinima = 0.00;
                    String registro0 = "";
                    String registro1 = "";
                    String registro2 = "";
                    String registro3 = "";
                    String registro4 = "";
                    String registro5 = "";
                    String registro6 = "";
                    for (int i = 0; i < datos.size(); i++) {
                        String datosCiudad = datos.get(ciudades.get(i));
                        String[] registros = datosCiudad.split(";");
                        if (Double.parseDouble(registros[4]) <= temperaturaMinima) {
                            temperaturaMinima = Double.parseDouble(registros[4]);
                            registro0 = registros[0];
                            registro1 = registros[1];
                            registro2 = registros[2];
                            registro3 = registros[3];
                            registro4 = registros[4];
                            registro5 = registros[5];
                            registro6 = registros[6];
                        }

                        if (i == datos.size() - 2) {
                            System.out.println(registro0 + " (" + registro1 + ")");
                            System.out.println("----------------------------------");
                            System.out.println("Temperatura màxima: " + registro2 + "°C");
                            System.out.println("Hora T. máxima " + registro3);
                            System.out.println("Temperatura mínima: " + registro4 + "°C");
                            System.out.println("Hora T. mínima " + registro5);
                            System.out.println("Diferència temperatures: " + (Double.parseDouble(registro2) - Double.parseDouble(registro4)) + "°C");
                            System.out.println("Precipitació en litres: " + registro6);
                            System.out.println("----------------------------------");
                            System.out.println();
                        }
                    }
                }
                case 4 -> {
                    System.out.println();
                    Double precipitacioMaxima = 0.00;
                    String registro0 = "";
                    String registro1 = "";
                    String registro2 = "";
                    String registro3 = "";
                    String registro4 = "";
                    String registro5 = "";
                    String registro6 = "";
                    for (int i = 0; i < datos.size(); i++) {
                        String datosCiudad = datos.get(ciudades.get(i));
                        String[] registros = datosCiudad.split(";");
                        if (Double.parseDouble(registros[6]) >= precipitacioMaxima) {
                            precipitacioMaxima = Double.parseDouble(registros[6]);
                            registro0 = registros[0];
                            registro1 = registros[1];
                            registro2 = registros[2];
                            registro3 = registros[3];
                            registro4 = registros[4];
                            registro5 = registros[5];
                            registro6 = registros[6];
                        }

                        if (i == datos.size() - 2) {
                            System.out.println(registro0 + " (" + registro1 + ")");
                            System.out.println("----------------------------------");
                            System.out.println("Temperatura màxima: " + registro2 + "°C");
                            System.out.println("Hora T. máxima " + registro3);
                            System.out.println("Temperatura mínima: " + registro4 + "°C");
                            System.out.println("Hora T. mínima " + registro5);
                            System.out.println("Diferència temperatures: " + (Double.parseDouble(registro2) - Double.parseDouble(registro4)) + "°C");
                            System.out.println("Precipitació en litres: " + registro6);
                            System.out.println("----------------------------------");
                            System.out.println();
                        }
                    }
                }
                case 5 -> {
                    break;
                }
            }
        }
    }

}
