package dao;

import dto.Asignatura;
import java.util.ArrayList;
import java.util.List;

public class AsignaturaDAO {

    public static List<Asignatura> getAll() {
        List<Asignatura> asignaturas = new ArrayList<>();
        asignaturas.add(new Asignatura("Cálculo", 1, 5));
        asignaturas.add(new Asignatura("Física", 1, 4));
        asignaturas.add(new Asignatura("Programación básica", 1, 6));
        asignaturas.add(new Asignatura("Sistemas operativos", 2, 5));
        asignaturas.add(new Asignatura("Algoritmia", 2, 6));
        asignaturas.add(new Asignatura("Arquitectura de computadores", 2, 5));
        asignaturas.add(new Asignatura("Bases de datos", 3, 5));
        asignaturas.add(new Asignatura("Redes", 3, 5));
        asignaturas.add(new Asignatura("Programación orientada a objetos", 3, 6));
        asignaturas.add(new Asignatura("Introducción a la inteligencia artificial", 4, 5));
        return asignaturas;
    }
}
