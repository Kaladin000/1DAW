package dto;

import java.util.Objects;
public class Asignatura {
    private final String nombre;
    private final int curso;
    private final int horasSemanales;

    public Asignatura(String nombre, int curso, int horasSemanales) {
        this.nombre = nombre;
        this.curso = curso;
        this.horasSemanales = horasSemanales;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCurso() {
        return curso;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombre=" + nombre + ", curso=" + curso + ", horasSemanales=" + horasSemanales + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + this.curso;
        hash = 89 * hash + this.horasSemanales;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asignatura other = (Asignatura) obj;
        if (this.curso != other.curso) {
            return false;
        }
        if (this.horasSemanales != other.horasSemanales) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
}
