package examendgv_ra6;

import java.util.Comparator;
import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 *
 * @author David García Valero
 */
public class Main {
    public static void main(String[] args) {
        
        // 1.
        
        System.out.println("--1--\n");
        
        PersonaDAO.getAll().stream()
                .flatMap(p -> p.getIdiomas().stream())
                .sorted(comparing(p -> p.toString().length()))
                .distinct()
                .forEach(System.out::println);
        
        System.out.println();
        
        // 2.
        
        System.out.println("--2--\n");
        
        PersonaDAO.getAll().stream()
                .map(Persona::getEdad)
                .max(naturalOrder())
                .ifPresent(System.out::println);
        
        System.out.println();
        
        // 3.
        
        System.out.println("--3--\n");
        
        Map <String, List<Persona>> mapa1 = PersonaDAO.getAll().stream()
                .collect(Collectors.groupingBy(p -> p.getIdiomas().getFirst(), Collectors.mapping(Function.identity(), Collectors.toList())));
        
        System.out.println(mapa1 + "\n");
        
        // 4.
        
        System.out.println("--4--\n");
        
        Map <String, List<String>> mapa2 = PersonaDAO.getAll().stream()
                .collect(Collectors.groupingBy(p -> p.getIdiomas().getFirst(), Collectors.mapping(p -> p.getNombre().toUpperCase(), Collectors.toList())));
        
        System.out.println(mapa2 + "\n");
        
    }
    
}
