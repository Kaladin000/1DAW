package p53.joc;

/**
 *
 * @author DAVID GARCÍA VALERO
 */
public class Turno {
    
    // ATRIBUTOS
    
    private int valor;
    
    // CONSTRUCTORES
    
    public Turno() {
        double valorDouble = Math.random();
        if (valorDouble>=0.5) {
            valorDouble = 1;
        } else if (valorDouble<0.5) {
            valorDouble = 0;
        }
        this.valor = (int)valorDouble;
    }
    
    // MÉTODOS
    
    public int toca() {
        return valor;
    }
    
    public int noToca() {
        int valorOpuesto = 0;
        if (valor == valorOpuesto) {
            valorOpuesto = 1;
        } else if (valor != valorOpuesto) {
            valorOpuesto = 0;
        }
        return valorOpuesto;
    }
    
    public void canviar() {
        this.valor = noToca();
    }
}
