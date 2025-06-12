package model;

public class Oficina {
    private final int oficina;
    private final String ciutat;
    private final double superficie;
    private final double vendes;
    
    public Oficina(int oficina, String ciutat, double superficie, double vendes) {
        this.oficina = oficina;
        this.ciutat = ciutat;
        this.superficie = superficie;
        this.vendes = vendes;
    }
    
    public String getCiutat() {
        return ciutat;
    }
    
    public double getSuperficie() {
        return superficie;
    }
    
    public String toString() {
        return "Oficina{" + "oficina=" + oficina + ", ciutat=" + ciutat + ", superficie=" + superficie + ", vendes=" + vendes + '}';
    }
}
