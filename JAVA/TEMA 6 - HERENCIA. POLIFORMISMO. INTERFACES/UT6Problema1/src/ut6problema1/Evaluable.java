package ut6problema1;

/**
 * En esta interfaz, evaluar asigna una puntuación int a un empleado.
 * obtenerEvaluacionActual devuelve el int que equivale a la puntuación
 * de un empleado.
 * @author David García Valero
 */
public interface Evaluable {
    public void evaluar(int puntuacion);
    public int obtenerEvaluacionActual();
}
