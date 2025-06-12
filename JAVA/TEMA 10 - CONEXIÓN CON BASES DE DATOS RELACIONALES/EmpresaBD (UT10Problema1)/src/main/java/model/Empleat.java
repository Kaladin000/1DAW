package model;

import java.time.LocalDate;

public class Empleat {
    private final int numemp;
    private final String nom;
    private final int edat;
    private final int oficina;
    private final String ocupacio;
    private final LocalDate contracte;
    
    public Empleat(int numemp, String nom, int edat, int oficina, String ocupacio, LocalDate contracte) {
        this.numemp = numemp;
        this.nom = nom;
        this.edat = edat;
        this.oficina = oficina;
        this.ocupacio = ocupacio;
        this.contracte = contracte;
    }
    
    public int getEdat() {
        return this.edat;
    }
    
    public String getNom() {
        return this.nom;
    }
    
    public int getNumemp() {
        return this.numemp;
    }
    
    public int getOficina() {
        return this.oficina;
    }
    
    public String getOcupacio() {
        return this.ocupacio;
    }
    
    public LocalDate getContracte() {
        return this.contracte;
    }
    
    public String toString() {
        return "Oficina{" + "numemp=" + numemp + ", nom=" + nom + ", edat=" + edat + ", oficina=" + oficina + ", ocupacio=" + ocupacio + ", contracte=" + contracte +'}';
    }
}
