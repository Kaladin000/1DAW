package examendgv_ra6;

import java.util.List;

public class Persona {
    private final String nombre;
    private final int edad;
    private final List<String> idiomas;

    public Persona(String nombre, int edad, List<String> idiomas) {
        this.nombre = nombre;
        this.edad = edad;
        this.idiomas = List.copyOf(idiomas);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años) " + idiomas;
    }
}
