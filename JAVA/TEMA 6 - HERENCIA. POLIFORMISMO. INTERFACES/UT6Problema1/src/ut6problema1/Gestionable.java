package ut6problema1;

/**
 * En esta interfaz, asignarProyecto asigna un proyecto a un empleado Gestionable.
 * eliminarProyecto borra un proyecto de un empleado Gestionable.
 * listarProyectos lista los proyectos en pantalla de un empleado Gestionable.
 * @author David García Valero
 */
public interface Gestionable {
    public void asignarProyecto(UT6Problema1.Proyecto p);
    public void eliminarProyecto(UT6Problema1.Proyecto p);
    public void listarProyectos();
}
