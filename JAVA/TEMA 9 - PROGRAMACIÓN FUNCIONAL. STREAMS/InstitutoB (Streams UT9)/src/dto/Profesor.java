package dto;

import java.util.List;
import java.util.Objects;

public class Profesor {

    private final String dni;
    private final String nombre;
    private final List<Asignatura> asignaturas;

    public Profesor(String dni, String nombre, List<Asignatura> asignaturas) {
        this.dni = dni;
        this.nombre = nombre;
        this.asignaturas = asignaturas;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    @Override
    public String toString() {
        return "Profesor{" + "dni=" + dni + ", nombre=" + nombre + ", asignaturas=" + asignaturas + '}';
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.dni);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.asignaturas);
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
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.asignaturas, other.asignaturas);
    }
    
    
    
    
}
