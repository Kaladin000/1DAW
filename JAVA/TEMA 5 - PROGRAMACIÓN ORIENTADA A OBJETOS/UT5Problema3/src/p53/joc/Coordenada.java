package p53.joc;

/**
 *
 * @author DAVID GARCÍA VALERO
 */

import java.util.Scanner;
import p53.util.Interval;

public class Coordenada {
    
    // ATRIBUTOS
    
    private int fila;
    private int columna;
    private final Interval LÍMITES = new Interval(1,3);
    
    // CONSTRUCTORES
    
    public Coordenada() {
    }
    
    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    // MÉTODOS
    
    public int getFila() {
        return fila;
    }
    
    public int getColuma() {
        return columna;
    }
    
    public boolean validar() {
        Interval validarInterval = new Interval(fila,columna);
        boolean validar = LÍMITES.inclou(validarInterval);
        return validar;
    }
    
    public Coordenada recollir() {
        Coordenada coordenadaRecoger = new Coordenada();
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce fila: ");
        while (!input.hasNextInt()) {
            System.out.println("No has introducido un número válido. Introduce fila: ");
            input.next();
        } int filaInput = input.nextInt();
        System.out.println("Introduce columna: ");
        while (!input.hasNextDouble()) {
            System.out.println("No has introducido un número válido. Introduce columna: ");
            input.next();
        } int columnaInput = input.nextInt();
        
        input.nextLine();
        coordenadaRecoger.fila = filaInput;
        coordenadaRecoger.columna = columnaInput;
        boolean validar = coordenadaRecoger.validar();
        
        // Validar que esté dentro de los límites
        
        while (validar == false) {
            while (!input.hasNextInt()) {
                System.out.println("No has introducido un número válido. Introduce fila: ");
                input.next();
            } filaInput = input.nextInt();
            System.out.println("Introduce columna: ");
            while (!input.hasNextDouble()) {
                System.out.println("No has introducido un número válido. Introduce columna: ");
                input.next();
            } columnaInput = input.nextInt();
        
            input.nextLine();
            coordenadaRecoger.fila = filaInput;
            coordenadaRecoger.columna = columnaInput;
            validar = coordenadaRecoger.validar();
        }
        return coordenadaRecoger;
    }
}