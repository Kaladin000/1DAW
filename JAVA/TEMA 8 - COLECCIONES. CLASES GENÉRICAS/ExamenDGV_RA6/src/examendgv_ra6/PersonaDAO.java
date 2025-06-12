package examendgv_ra6;

import java.util.List;

public class PersonaDAO {
    public static List<Persona> getAll() {
        return List.of(
            new Persona("Ana", 30, List.of("Español", "Inglés")),
            new Persona("Luis", 25, List.of("Inglés", "Francés")),
            new Persona("María", 40, List.of("Español", "Alemán")),
            new Persona("John", 28, List.of("Inglés", "Español")),
            new Persona("Claire", 35, List.of("Francés", "Alemán"))
        );
    }
}
