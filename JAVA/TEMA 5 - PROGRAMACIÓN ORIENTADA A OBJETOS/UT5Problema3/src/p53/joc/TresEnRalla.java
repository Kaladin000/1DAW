package p53.joc;

import p53.joc.enums.EstatCasella;

/**
 *
 * @author DAVID GARCÍA VALERO
 */
public class TresEnRalla {
    
    // ATRIBUTOS
    
    private Tabla tabla;
    private Jugador[] jugadores;
    private Turno turno;
    
    // CONSTRUCTORES
    
    public TresEnRalla() {
        this.tabla = new Tabla();
        this.jugadores  = new Jugador[2];
        this.turno = new Turno();
    }
    
    // MÉTODOS
    
    public void jugar() {
        
        System.out.println("¡Bienvenido al juego del tres en ralla!");
        System.out.println("---------------------------------------");
        System.out.println("");
        
        for (int i = 0; i < jugadores.length; i++) {
            if (i==0) {
                jugadores[i] = new Jugador(EstatCasella.XS);
            } else if (i==1) {
                jugadores[i] = new Jugador(EstatCasella.OS);
            }
        }
        
        Coordenada coordenada = new Coordenada();
        
        while (!tabla.hihaTresEnRatlla()) {
            
            System.out.println("Estado actual de la partida: ");
            tabla.mostrarTabla();
        
            if (1 == turno.toca()) {
                System.out.println("Turno de XS");
                coordenada = coordenada.recollir();
                while (tabla.estaOcupada(coordenada)) {
                    System.out.println("Has introducido una coordenada ocupada, vuelve a intentarlo");
                    coordenada = coordenada.recollir();
                }
                tabla.posarFitxa(coordenada, EstatCasella.XS);
                turno.canviar();
            } else if (0 == turno.toca()) {
                System.out.println("Turno de OS");
                coordenada = coordenada.recollir();
                while (tabla.estaOcupada(coordenada)) {
                    System.out.println("Has introducido una coordenada ocupada, vuelve a intentarlo");
                    coordenada = coordenada.recollir();
                }
                tabla.posarFitxa(coordenada, EstatCasella.OS);
                turno.canviar();
            }
            
            if (tabla.hihaTresEnRatlla()) {
                System.out.println("");
                if (tabla.hihaTresEnRatlla(EstatCasella.XS)) {
                    jugadores[0].cantarVictoria();
                } else if (tabla.hihaTresEnRatlla(EstatCasella.OS)) {
                    jugadores[1].cantarVictoria();
                }
                tabla.mostrarTabla();
            }
            
            if (tabla.estaPle()) {
                tabla.buidar();
            }
        
        }
    }
    
    public static void main(String[] args) {
        TresEnRalla tresenralla = new TresEnRalla();
        tresenralla.jugar();
    }
}
