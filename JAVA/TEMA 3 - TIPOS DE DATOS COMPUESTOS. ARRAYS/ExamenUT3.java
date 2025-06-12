/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenut3;
import java.util.Random;
/**
 *
 * @author David García Valero
 */
public class ExamenUT3 {
    public static void main(String[] args) {
        Random temperaturaRandom = new Random();
        Double temperaturasPetrer[][] = new Double[7][2];
        Double temperaturasElda[][] = new Double[7][2];
        Double temperaturasNovelda[][] = new Double[7][2];
        
        Double temperaturaMínima = 41.11;
        Double temperaturaMáxima = 0.00;
        
        // ASIGNAR VALORES MÍNIMOS Y MÁXIMOS DE CADA CIUDAD
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                temperaturasPetrer[j][i] = temperaturaRandom.nextDouble(40);
                temperaturasElda[j][i] = temperaturaRandom.nextDouble(40);
                temperaturasNovelda[j][i] = temperaturaRandom.nextDouble(40);
            }
        }
        
        String días[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int díaMínima = 0;
        int díaMáxima = 0;
        
        String ciudades[] = {"Petrer", "Elda", "Novelda"};
        int ciudadNumMínima = 0;
        int ciudadNumMáxima = 0;
        
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 7; j++) {
                    
                    // MÍNIMAS
                    
                    if (temperaturasPetrer[j][i] < temperaturaMínima) {
                        temperaturaMínima = temperaturasPetrer[j][i];
                        díaMínima = j;
                        ciudadNumMínima = 0;
                    }
                    if (temperaturasElda[j][i] < temperaturaMínima) {
                        temperaturaMínima = temperaturasElda[j][i]; 
                        díaMínima = j;
                        ciudadNumMínima = 1;
                    }
                    if (temperaturasNovelda[j][i] < temperaturaMínima) {
                        temperaturaMínima = temperaturasNovelda[j][i]; 
                        díaMínima = j;
                       ciudadNumMínima = 2;
                    }
                    
                    // MÁXIMAS
                    
                    if (temperaturasPetrer[j][i] > temperaturaMáxima) {
                        temperaturaMáxima = temperaturasPetrer[j][i]; 
                        díaMáxima = j;
                        ciudadNumMáxima = 0;
                    }
                    if (temperaturasElda[j][i] > temperaturaMáxima) {
                        temperaturaMáxima = temperaturasElda[j][i]; 
                        díaMáxima = j;
                        ciudadNumMáxima = 1;
                    }
                    if (temperaturasNovelda[j][i] > temperaturaMáxima) {
                        temperaturaMáxima = temperaturasNovelda[j][i]; 
                        díaMáxima = j;
                        ciudadNumMáxima = 2;
                    }
                }
            }
            
            
            
            // IMPRIMIR
            
            System.out.printf("La temperatura más baja fue de %.1fºC, registrada en %s el %s\n", temperaturaMínima, ciudades[ciudadNumMínima], días[díaMínima]);
            System.out.printf("La temperatura más alta fue de %.1fºC, registrada en %s el %s\n", temperaturaMáxima,ciudades[ciudadNumMáxima], días[díaMáxima]);
    }
    
}
