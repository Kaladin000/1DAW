/*David García Valero */

package interval;
import java.util.Scanner;

class Interval {

    private double inferior;
    private double superior;

    /**
     * Proporciona un interval amb els límits inferior i superior que li donem
     * @param inferior
     * @param superior 
     */
    public Interval(double inferior, double superior) {
       this.inferior = inferior;
       this.superior = superior;
    }

    /**
     * Proporciona un interval amb límit superior que li donem
     * @param superior 
     */
    public Interval(double superior) {
      this.superior = superior;
      this.inferior = 0;
    }

    /**
     * Proporciona un interval a partir d'un altre (copia)
     * @param interval 
     */
    public Interval(Interval interval) {
        this.inferior = interval.inferior;
        this.superior = interval.superior;
    }

    /**
     * Proporciona un interval amb límits per defecte.
     */
    public Interval() {
        this.inferior = 0;
        this.superior = 10;
    }

    /**
     * Clona l'interval
     * @return 
     */
    public Interval clone() {
        return new Interval(inferior, superior);
    }

    /**
     * Longitud de l'interval
     * @return 
     */
    public double longitud() {
        double longitud = Math.abs(superior-inferior);
        return longitud;
    }

    /**
     * Mou els límits de l'interval segons el que indiquem
     * @param moviment 
     */
    public void moure(double moviment) {
       this.superior = moviment+superior;
       this.inferior = inferior+moviment;
    }

    /**
     * Obtiene l'interval mogut segons el moviment proporcionat
     * @param moviment
     * @return 
     */
    public Interval mogut(double moviment) {
        return new Interval(moviment+superior,inferior+moviment);
    }

    /**
     * Determina si el valor está dintre de l'interval
     * @param valor
     * @return 
     */
    public boolean inclou(double valor) {
        boolean inclou = false;
        if (valor >= inferior && valor <= superior) {
            inclou = true;
        }
        return inclou;
    }

    /**
     * Determina si l'interval proporcionat está inclòs en l'interval
     * @param interval
     * @return 
     */
    public boolean inclou(Interval interval) {
        boolean inclou = false;
        if (interval.inferior >= inferior && interval.inferior <= superior && interval.superior >= inferior && interval.superior <= superior) {
            inclou = true;
        }
        return inclou;
    }

    /**
     * Determina si dos intervals són iguals
     * @param interval
     * @return 
     */
    public boolean equals(Interval interval) {
        boolean equals = false;
        if (interval.inferior == inferior && interval.superior == superior) {
            equals = true;
        }
        return equals;
    }

    /**
     * Obté l'interval que intersecta
     * @param interval
     * @return 
     */
    public Interval interseccio(Interval interval) {
        Interval intervalIntersecta = new Interval(inferior,superior);
        boolean intersecta = interval.intersecta(intervalIntersecta);
        if (intersecta == false) {
            return null;
        } else {
            double inferiorResultado = 0;
            double superiorResultado = 0;
            if (inferior >= interval.inferior) {
                inferiorResultado = inferior;
            } else if (interval.inferior >= inferior) {
                inferiorResultado = interval.inferior;
            }
            if (superior <= interval.superior) {
                superiorResultado = superior;
            } else if (interval.superior <= superior) {
                superiorResultado = interval.superior;
            }
            return new Interval(inferiorResultado,superiorResultado);
        }
    }

    /**
     * Determina si un interval intersecta amb el nostre
     * @param interval
     * @return 
     */
    public boolean intersecta(Interval interval) {
        boolean intersecta = false;
        // Si intersectan del primero al segundo
        if (interval.inferior < inferior && interval.superior >= inferior || interval.superior > superior && interval.inferior <= superior) {
            intersecta = true;
        }
        // Si intersectan del segundo al primero
        if (inferior < interval.inferior && superior >= interval.inferior || superior > interval.superior && inferior <= interval.superior) {
            intersecta = true;
        }
        // Si intersectan y el segundo está dentro del primero
        if (interval.inferior >= inferior && interval.inferior <= superior && interval.superior >= inferior && interval.superior <= superior) {
            intersecta = true;
        }
        // Si intersectan y el primero está dentro del segundo
        if (inferior >= interval.inferior && inferior <= interval.superior && superior >= interval.inferior && superior <= interval.superior) {
            intersecta = true;
        }
        return intersecta;
    }

    /**
     * Transforma l'interval en el seu oposat.
     */
    public void oposar() {
        double temporal = inferior;
        this.inferior = superior;
        this.superior = temporal;
    }

    /**
     * Augmenta la grandària de l'interval al doble de la seua longitud (ha de creixer igual pels dos extrems).
     */
    public void doblar() {
       Interval doblarInterval = new Interval(inferior,superior);
       double longitud = doblarInterval.longitud();
       doblarInterval.superior = longitud/2+superior;
       doblarInterval.inferior = inferior-longitud/2;
       this.inferior = doblarInterval.inferior;
       this.superior = doblarInterval.superior;
    }

    /**
     * Demana a l'usuari que introduïsca els límits de l'interval
     */
    public void recollir() {
       Scanner input = new Scanner(System.in);
       System.out.println("Introduce el límite inferior: ");
       while (!input.hasNextDouble()) {
           System.out.println("No has introducido un número válido. Introduce el límite inferior: ");
           input.next();
       } double inferiorInput = input.nextDouble();
       System.out.println("Introduce el límite superior: ");
       while (!input.hasNextDouble()) {
           System.out.println("No has introducido un número válido. Introduce el límite superior: ");
           input.next();
       } double superiorInput = input.nextDouble();
       input.nextLine();
       this.inferior = inferiorInput;
       this.superior = superiorInput;
    }

    /** Mostra l'interval amb el format [limitInferior, limitSuperior].
     * 
     */
    public void mostrar() {
        System.out.println("[" + inferior + ", " + superior + "]");
    }

    /**
     * Obté els subintervals en grandàries iguals segons els trossos proporcionats
     * @param trossos
     * @return 
     */
    public Interval[] trossejar(int trossos) {
        Interval intervalArray[] = new Interval[trossos];
        Interval intervalActual = new Interval(inferior,superior);
        double longitud = intervalActual.longitud();
        double tamanyoPartes = longitud/trossos;
        double inferiorActual = inferior;
        for (int i = 0; i < trossos; i++) {
            intervalArray[i] = new Interval(inferiorActual,inferiorActual+tamanyoPartes);
            inferiorActual += tamanyoPartes;
        }
        return intervalArray;
    }
    
    /**
     * Comparar en longitud dos intervalos, de izquierda a derecha, intervalo del método es X que intervalo parámetro
     */
    public String comparar(Interval interval) {
        String comparar = null;
        Interval intervalComparar = new Interval(inferior,superior);
        double longitudIntervalComparar = intervalComparar.longitud();
        double longitudInterval = interval.longitud();
        if (longitudIntervalComparar > longitudInterval) {
            comparar = "mayor";
        } else if (longitudIntervalComparar < longitudInterval) {
            comparar = "menor";
        } else if (longitudIntervalComparar == longitudInterval) {
            comparar = "igual";
        } return comparar;
    }
    
    /**
     * Une dos intervalos si están superpuestos
     */
    public Interval unir(Interval interval) {
        Interval intervalUnir = new Interval(inferior,superior);
        String comparar = intervalUnir.comparar(interval);
        if (!comparar.equals("igual")) {
            return null;
        } else {
            return new Interval(inferior,superior);
        }
    }
}
