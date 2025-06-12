package p53.joc;

import p53.joc.enums.EstatCasella;

/**
 *
 * @author DAVID GARCÍA VALERO
 */
public class Jugador {
    
    // ATRIBUTOS
    
    private EstatCasella color;
    
    // CONSTRUCTORES
    
    public Jugador(EstatCasella color) {
        this.color = color;
    }
    
    // MÉTODOS
    
    public void cantarVictoria() {
        System.out.println("¡El jugador " + color + " ha ganado!");
    }
    
    public String errorPosada(Tabla tabla, Coordenada coordenada) {
        String errorPosada = null;
        if (!tabla.estaOcupada(coordenada)) {
            return null;
        } else {
            errorPosada = "Coordenada ocupada en la tabla";
            return errorPosada;
        }
    }
    
    public Coordenada recollirCoordenadaPosadaValida(Tabla tabla) {
        Coordenada coordenada = new Coordenada();
        boolean coordenadaRecogida = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                coordenada = new Coordenada(i+1,j+1);
                if (tabla.estaOcupada(coordenada)) {
                    System.out.println("La coordenada " + "[" + i+1 + ", " + j+1 + "]" + " está ocupada");
                } else if (!tabla.estaOcupada(coordenada)) {
                    coordenadaRecogida = true;
                    break;
                }
            }
            if (coordenadaRecogida == true) {
                break;
            }
        }
        return coordenada;
    }
    
    public void posarFitxa(Tabla tabla) {
        Jugador jugador = new Jugador(color);
        System.out.println("Pone el jugador con " + color);
        Coordenada coordenada = new Coordenada();
        coordenada = jugador.recollirCoordenadaPosadaValida(tabla);
        tabla.posarFitxa(coordenada, color);
    }
}
