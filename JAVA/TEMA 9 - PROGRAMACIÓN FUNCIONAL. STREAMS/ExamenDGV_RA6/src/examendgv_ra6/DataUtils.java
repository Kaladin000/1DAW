package examendgv_ra6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author David García Valero
 */
public class DataUtils<T> {
    
    public LinkedHashSet<T> toLinkedHashSet(ArrayList<T> array) {
        LinkedHashSet<T> coleccion = new LinkedHashSet<>();
        
        for (int i = 0; i < array.size(); i++) {
            if (!coleccion.contains(array.get(i))) {
                coleccion.add(array.get(i));
            }
        } return coleccion;
    }
    
    public void registrar(Map asignaturaAlumnos, String asignatura, String alumno) {
        
        if (asignaturaAlumnos.get(asignatura) != null) {
            if (!asignaturaAlumnos.get(asignatura).toString().contains(alumno)) {
                asignaturaAlumnos.put(asignatura, asignaturaAlumnos.get(asignatura) + ", " + alumno);
            }
        } else {
            asignaturaAlumnos.put(asignatura, alumno);
        }
    }
    
}
