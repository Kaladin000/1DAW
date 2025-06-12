package principal;

import dao.*;
import dto.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {

    public static void main(String[] args) {

        // A) Muestra aquellos profesores que imparten más de dos asignaturas (muestra el objeto profesor completo) [0.5p]
        System.out.println("- A -");

        ProfessorDAO.getAll().stream()
                .filter(p -> p.getAsignaturas().size() > 2)
                .forEach(System.out::println);

        // B) Muestra el nombre de las asignaturas impartidas por todos los profesores, sin duplicados y ordenadas alfabéticamente. [0.5p]
        System.out.println("- B -");

        ProfessorDAO.getAll().stream()
                .flatMap(p -> p.getAsignaturas().stream())
                .map(Asignatura::getNombre)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // C) Recolecta y muestra un mapa (Map) donde se asocie para cada nombre de profesor la cantidad de asignaturas que imparte [1p]
        System.out.println("- C -");

        Map<String, Integer> mapa = ProfessorDAO.getAll().stream()
                .collect(Collectors.toMap(
                        Profesor::getNombre, // clave: nombre del profesor
                        p -> p.getAsignaturas().size() // valor: número de asignaturas
                ));

        System.out.println(mapa);

        // D) Recolecta y muestra un mapa (Map) donde se asocie para cada nombre de profesor la cantidad de horas de clase que imparte [1.5p]
        System.out.println("- D -");

        Map horasDeClase = ProfessorDAO.getAll().stream()
                .collect(Collectors.toMap(
                        Profesor::getNombre, // clave: nombre del profesor
                        p -> p.getAsignaturas().stream()
                                .mapToInt(a -> a.getHorasSemanales()) // mapeo de horas semanales
                                .sum() // suma total de horas
                ));

        System.out.println(horasDeClase);

        // E) Recolecta y muestra un mapa (Map) donde se asocie para cada DNI de profesor el curso más alto donde imparte clase (si no tiene ninguna asignatura asociada, el máximo curso será 0) [2p]
        System.out.println("- E -");

        Map cursoAlto = ProfessorDAO.getAll().stream()
                .collect(Collectors.toMap(Profesor::getDni, p -> p.getAsignaturas().stream()
                .map(a -> a.getCurso())
                .max(Comparator.naturalOrder())
                .orElse(0)
                ));

        System.out.println(cursoAlto);

        // F) Recolecta y muestra un mapa (Map) donde se asocie para cada curso los nombres de asignaturas de ese curso (separadas por un guión "-"). [2p]
        System.out.println("- F -");

        Map cursoAsignatura = AsignaturaDAO.getAll().stream()
                .collect(Collectors.groupingBy(
                        Asignatura::getCurso, // clave: número de curso
                        Collectors.mapping(
                                Asignatura::getNombre, // extraer nombre de la asignatura
                                Collectors.joining(" - ") // unir con guión
                        )
                ));

        cursoAsignatura.forEach((curso, asignatura) -> System.out.println(curso + " " + asignatura));

        // G) Recolecta y muestra un mapa (Map) donde se asocie para cada asignatura la lista de profesores que la imparten [2.5p]
        System.out.println("- G -");

        Map asignaturaProfesores = ProfessorDAO.getAll().stream()
                .flatMap(p -> p.getAsignaturas().stream()
                .map(a -> Map.entry(a, p))
                )
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(
                                Map.Entry::getValue,
                                Collectors.toList()
                        )
                )
                );
        
        asignaturaProfesores.forEach((asignatura, profesores) -> System.out.println(asignatura + " " + profesores)); 
    }
}