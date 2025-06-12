package ut12problema1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author David García Valero
 */
public class DadesMetereologiques {

    static Scanner input = new Scanner(System.in);
    public static Map<String, String> datos = new HashMap<>();

    public static void conseguirDatos() {

        System.out.println("Introduce la fecha del archivo Aemet en formato AAAAMMDD");
        String fecha = input.nextLine();
        String ruta = "Aemet";
        ruta = ruta.concat(fecha) + ".csv";
        int a = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                int posicionPuntoYComa = linia.indexOf(";");
                String ciudad = linia.substring(0, posicionPuntoYComa);
                datos.put(ciudad, linia);
            }
        } catch (IOException ex) {
            System.out.println("No tenim dades per a eixa data");
            System.exit(0);
        }
    }

}
