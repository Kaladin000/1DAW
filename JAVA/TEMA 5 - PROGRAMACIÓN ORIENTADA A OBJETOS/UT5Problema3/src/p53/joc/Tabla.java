package p53.joc;

import p53.joc.enums.EstatCasella;
import static p53.joc.enums.EstatCasella.BUIDA;
import static p53.joc.enums.EstatCasella.OS;
import static p53.joc.enums.EstatCasella.XS;

/**
 *
 * @author DAVID GARCÍA VALERO
 */
public class Tabla {
    
    // ATRIBUTOS
    
    private EstatCasella[][] casillas;
    private final int DIMENSIÓN = 3;
    
    // CONSTRUCTORES
    
    public Tabla() {
        this.casillas = new EstatCasella[DIMENSIÓN][DIMENSIÓN];
        buidar();
    }
    
    // MÉTODOS
    
    public boolean hihaTresEnRatlla(EstatCasella jugador) {
        boolean tresEnRalla = false;
        for (int i = 0; i < DIMENSIÓN; i++) {
            for (int j = 0; j < 1; j++) {
                if (casillas[i][j] == jugador && casillas[i][j+1] == jugador && casillas[i][j+2] == jugador) {
                    tresEnRalla = true;
                } else if (casillas[j][i] == jugador && casillas[j+1][i] == jugador && casillas[j+2][i] == jugador) {
                    tresEnRalla = true;
                } else if (i == 0 && casillas[j][i] == jugador && casillas[j+1][i+1] == jugador && casillas[j+2][i+2] == jugador) {
                    tresEnRalla = true;
                } else if (i == 0 && casillas[j+2][i] == jugador && casillas[j+1][i+1] == jugador && casillas[j][i+2] == jugador) {
                    tresEnRalla = true;
                }
            }
        } return tresEnRalla;
    }
    
    public boolean hihaTresEnRatlla() {
        boolean tresEnRalla = false;
        boolean tresEnRallaXS = hihaTresEnRatlla(XS);
        boolean tresEnRallaOS = hihaTresEnRatlla(OS);
        if (tresEnRallaXS || tresEnRallaOS) {
            tresEnRalla = true;
        }
        return tresEnRalla;
    }
    
    public boolean estaOcupada(Coordenada coordenada, EstatCasella jugador) {
        boolean ocupada = false;
        int fila = coordenada.getFila();
        int columna = coordenada.getColuma();
        for (int i = 0; i < DIMENSIÓN; i++) {
            for (int j = 0; j < DIMENSIÓN; j++) {
                if (i+1==fila && j+1==columna && casillas[i][j] == jugador) {
                    ocupada = true;
                }
            }
        } return ocupada;
    }
    
    public boolean estaOcupada(Coordenada coordenada) {
        boolean ocupada = true;
        int fila = coordenada.getFila();
        int columna = coordenada.getColuma();
        for (int i = 0; i < DIMENSIÓN; i++) {
            for (int j = 0; j < DIMENSIÓN; j++) {
                if (i+1==fila && j+1==columna && casillas[i][j] == BUIDA) {
                    ocupada = false;
                }
            }
        } return ocupada;
    }
    
    public void posarFitxa(Coordenada coordenada, EstatCasella jugador) {
        int fila = coordenada.getFila();
        int columna = coordenada.getColuma();
        for (int i = 0; i < DIMENSIÓN; i++) {
            for (int j = 0; j < DIMENSIÓN; j++) {
                if (i+1==fila && j+1==columna) {
                    casillas[i][j] = jugador;
                }
            }
        }
    }
    
    public void buidar() {
        EstatCasella casillaVacía = BUIDA;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                casillas[i][j] = casillaVacía;
            }
        }
    }
    
    public boolean estaPle() {
        boolean estaPle = true;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                if (casillas[i][j] == BUIDA) {
                    estaPle = false;
                }
            }
        } return estaPle;
    }
    
    // He añadido este método opcionalmente para poder mostrar mi tabla en el juego
    
    public void mostrarTabla() {
        for (int i = 0; i < 3; i++) {
            System.out.println("");
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                System.out.print(casillas[i][j]);
                if (j==2) {
                    System.out.print("|");
                }
            }
            if (i==2) {
                System.out.println("");
                System.out.println("");
            }
        }
    }
}
