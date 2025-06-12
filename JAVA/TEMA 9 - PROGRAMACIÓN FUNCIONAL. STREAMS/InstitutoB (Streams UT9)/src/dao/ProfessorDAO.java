package dao;

import dto.Asignatura;
import dto.Profesor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public static List<Profesor> getAll() {
        List<Asignatura> asignaturas = AsignaturaDAO.getAll();
        List<Profesor> profesores = new ArrayList<>();
        profesores.add(new Profesor("12345678A", "Grace Hopper", List.of(asignaturas.get(0))));
        profesores.add(new Profesor("23456789B", "Alan Turing", List.of(asignaturas.get(7))));
        profesores.add(new Profesor("34567890C", "Ada Lovelace", List.of(asignaturas.get(2))));
        profesores.add(new Profesor("45678901D", "Linus Torvalds", List.of(asignaturas.get(2), asignaturas.get(5))));
        profesores.add(new Profesor("67890123F", "Ada Yonath", List.of(asignaturas.get(3), asignaturas.get(6), asignaturas.get(9))));
        profesores.add(new Profesor("78901234G", "Donald Knuth", List.of(asignaturas.get(3), asignaturas.get(8), asignaturas.get(4))));

        return profesores;
    }
}
