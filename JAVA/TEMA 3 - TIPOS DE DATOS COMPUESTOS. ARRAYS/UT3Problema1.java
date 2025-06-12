package ut3problema1;
import java.util.Scanner;

/**
 *
 * @author David García Valero
 */
public class UT3Problema1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("TENSIÓN ARTERIAL");
        System.out.println("----------------");
        System.out.println("Introduce las medidas: ");
        
        
        // Introduzco dos arrays para cada tipo de medición
        
        double[] medidasSistólicas = new double[5];
        double[] medidasDiastólicas = new double[5];
        
        /* Si al final del bucle for seguido de este while todos los valores de las parejas son 0, se repetirá obligatoriamente el bucle for hasta que tenga
           una pareja válida */
        
        do {
            
            // Bucle con input para el valor de las medidas
            
            for (int i = 0; i < medidasSistólicas.length; i++) {
                
                // Si no es un Double la medida no tendrá valor (=0)
                
                if (input.hasNextDouble()) {
                    medidasSistólicas[i] = input.nextDouble();
                    if (medidasSistólicas[i] == 0) { // Si se introduce un 0 el bucle finaliza
                        break;
                    }
                } else {
                    medidasSistólicas[i] = 0;
                    input.nextLine(); // limpia la línea si se introduce un carácter
                }
                if (input.hasNextDouble()) {
                    medidasDiastólicas[i] = input.nextDouble();
                    if (medidasSistólicas[i] == 0) {
                        break;
                    }
                } else {
                    medidasDiastólicas[i] = 0; 
                    input.nextLine();
                }
                
                /* Si alguna medida es menor a 3 o mayor a 22, Si alguna medida diastólica es mayor que su pareja Sistólica o Si alguna de las dos medidas
                 ya no tiene valor (=0):
                 La pareja dejará de tener valor (=0) */
                
                if (medidasDiastólicas[i] < 3 || medidasDiastólicas[i] > 22 || medidasDiastólicas[i] > medidasSistólicas[i]) {
                    medidasDiastólicas[i] = 0;
                }
                
                if (medidasSistólicas[i] < 3 || medidasSistólicas[i] > 22 || medidasDiastólicas[i] == 0) {
                    medidasSistólicas[i] = 0;
                }
                
                if (medidasSistólicas[i] == 0) {
                    medidasDiastólicas[i] = 0;
                }
            } if (medidasSistólicas[0]==0 && medidasSistólicas[1]==0 && medidasSistólicas[2]==0 && medidasSistólicas[3]==0 && medidasSistólicas[4]==0) {
                System.out.println("Todas las parejas introducidas son inválidas, necesitas mínimo una pareja válida, vuelve a intentarlo\n");
            } 
        } while (medidasSistólicas[0]==0 && medidasSistólicas[1]==0 && medidasSistólicas[2]==0 && medidasSistólicas[3]==0 && medidasSistólicas[4]==0);
        
    System.out.println("\n1.- Sistólica máxima");
    System.out.println("2.- Diastólica mínima"); 
    System.out.println("3.- Más compensada"); 
    System.out.println("4.- Tensión media"); 
    System.out.println("5.- Salir\n"); 
        
    System.out.println("Seleccione la opción deseada:");
        
    int valorMenú = input.nextInt();    
        
    while (valorMenú!=5) {    
        
        // Valores mínimos, máximos, tensión más compensada y media
        
        double sistólicaMáxima = 0; double diastólicaDeSisMáx = 0; // Sistólica máxima
        
        double diastólicaMínima = 23; double sistólicaDeDiasMín = 0; // Diastólica mínima
        
        double diferenciaMínima = 23; // Tensión más compensada
        
        double diastólicaCompensada = 0; double sistólicaCompensada = 0; 
        
        int a = 0; int b = 0; int c = 0;
        String[] tiposDePresión = {"Óptima", "Normal", "Normal - Alta", "Grado 1", "Grado 2", "Grado 3", "Sistólica aislada", "No contemplada"};
        String tipoPresiónA = ""; String tipoPresiónB = ""; String tipoPresiónC = "";
        
        double mediaSistólica = 0; double mediaDiastólica = 0; // Tensión media
        double sumaSistólicas = 0; double sumaDiastólicas = 0;
        int parejasVálidas = 0;
        
        for (int j = 0; j < medidasSistólicas.length; j++) {
            
            // Solo empezará a calcular valores si la medida de la pareja es válida (!=0)
            
            if (medidasSistólicas[j]!=0) {
                
                parejasVálidas++;
                
                /* Determinación del tipo de Presión (String[a,b,c] correlacionado con unos valores int únicos a,b,c,
                   cada uno de ellos relacionado con un String único (tipoPresiónA,B,C). 
                   El tipo de presión irá asignado a cada una de las 3 medidas pedidas*/
                
                if (medidasSistólicas[j]<12 && medidasDiastólicas[j]<8) {
                    a = 0; b = 0; c = 0;
                } else if (medidasSistólicas[j]>=12 && medidasSistólicas[j]<=12.9 && medidasDiastólicas[j]>=8 && medidasDiastólicas[j]<=8.4) {
                    a = 1; b = 1; c = 1;
                } else if (medidasSistólicas[j]>=13 && medidasSistólicas[j]<=13.9 && medidasDiastólicas[j]>=8.5 && medidasDiastólicas[j]<=8.9) {
                    a = 2; b = 2; c = 2;
                } else if (medidasSistólicas[j]>=14 && medidasSistólicas[j]<=15.9 && medidasDiastólicas[j]>=9 && medidasDiastólicas[j]<=9.9) {
                    a = 3; b = 3; c = 3;
                } else if (medidasSistólicas[j]>=16 && medidasSistólicas[j]<=17.9 && medidasDiastólicas[j]>=10 && medidasDiastólicas[j]<=10.9) {
                    a = 4; b = 4; c = 4;
                } else if (medidasSistólicas[j]>=18 && medidasDiastólicas[j]>=11) {
                    a = 5; b = 5; c = 5;
                } else if (medidasSistólicas[j]>=14 && medidasDiastólicas[j]<9) {
                    a = 6; b = 6; c = 6;
                } else {
                    a = 7; b = 7; c = 7;
                }
                
                // Cálculo de sistólica máxima
                
                if (medidasSistólicas[j]>=sistólicaMáxima) {
                    sistólicaMáxima = medidasSistólicas[j];
                    diastólicaDeSisMáx = medidasDiastólicas[j];
                    tipoPresiónA = tiposDePresión[a];
                }
                
                // Cálculo de diastólica mínima
                
                if (medidasDiastólicas[j]<=diastólicaMínima) {
                    diastólicaMínima = medidasDiastólicas[j];
                    sistólicaDeDiasMín = medidasSistólicas[j];
                    tipoPresiónB = tiposDePresión[b]; 
                }
                
                // Cálculo de tensión más compensada
                
                double diferencia = Math.abs(medidasSistólicas[j]-(medidasDiastólicas[j]*2)); // Uso math.abs para no tener valores negativos
                
                if (diferencia<=diferenciaMínima) { // Se guardan los valores de las medidas cuya diferencia de medidas (teniendo en cuenta que la diastólica es x2) sea menor
                    diferenciaMínima = diferencia;
                    sistólicaCompensada = medidasSistólicas[j];
                    diastólicaCompensada = medidasDiastólicas[j];
                    tipoPresiónC = tiposDePresión[c]; 
                } 
                
                // Cálculo de la media
                
                sumaSistólicas = medidasSistólicas[j] + sumaSistólicas;
                sumaDiastólicas = medidasDiastólicas[j] + sumaDiastólicas;
                
                mediaSistólica = sumaSistólicas/parejasVálidas;
                mediaDiastólica = sumaDiastólicas/parejasVálidas;      
            }
               
            
            // La última sentencia de las 5 instancias del bucle, donde se muestran los valores en formato
            
            if (j==4) {
                if (valorMenú == 1) {
                    System.out.printf("%.1f %.1f %s", sistólicaMáxima, diastólicaDeSisMáx, tipoPresiónA);
                }
                if (valorMenú == 2) {
                    System.out.printf("%.1f %.1f %s", sistólicaDeDiasMín, diastólicaMínima, tipoPresiónB);
                }
                if (valorMenú == 3) {
                    System.out.printf("%.1f %.1f %s", sistólicaCompensada, diastólicaCompensada, tipoPresiónC);
                }
                if (valorMenú == 4) {
                    System.out.printf("%.1f %.1f", mediaSistólica, mediaDiastólica);
                }
            }
        }
        System.out.println("\nSeleccione la opción deseada:");
        valorMenú = input.nextInt();
        if (valorMenú>5 || valorMenú<1) {
            System.out.println("ERROR");
        } else if (valorMenú==5) {
            System.out.println("FIN DEL PROGRAMA");
        }
    }    
    } 
}

