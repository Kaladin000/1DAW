package examendgv_ra7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David García Valero
 */
public class CompeticionUtils {
    
    // MÉTODOS
    
    public List<Vehiculo> filterPenalizables(List<Vehiculo> lista) {
        List<Vehiculo> listaPenalizables = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) instanceof Penalizable) {
                listaPenalizables.add(lista.get(i));
            }
        } return listaPenalizables;
    }
    
    public String resumenEstado(List<Vehiculo> vehiculos) {
        int monoplazas = 0;
        int camionesAsistencia = 0;
        int penalizables = 0;
        int noPenalizables = 0;
        
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i) instanceof Monoplaza) {
                monoplazas++;
            } else if (vehiculos.get(i) instanceof CamionAsistencia) {
                camionesAsistencia++;
            }
            if (vehiculos.get(i) instanceof Penalizable) {
                penalizables++;
            } else {
                noPenalizables++;
            }
        }
        
        return "Monoplazas: " + monoplazas + " - Camiones Asistencia: " + camionesAsistencia + " - Penalizables: " + penalizables + " - No Penalizables: " + noPenalizables;
    }
}
