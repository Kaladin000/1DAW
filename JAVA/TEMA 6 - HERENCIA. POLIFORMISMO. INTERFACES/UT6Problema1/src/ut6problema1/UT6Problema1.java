package ut6problema1;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * También almacena las clases que interactúan con Empleado y sus subclases:
 * Proyecto, CalculadoraSalario y GestorPersonal.
 * @author David García Valero
 */
public class UT6Problema1 {
    
    public static Scanner input = new Scanner(System.in);
    
    /**
     * Almacena los detalles de un proyecto, el inicio y el término del mismo, el presupuesto
     * asociado y una lista de Empleados que trabajan en el proyecto
     */
    
    public static class Proyecto {
        
        // ATRIBUTOS
        
        public String nombre;
        public LocalDate fechaInicio;
        public LocalDate fechaTermino;
        public double presupuesto;
        public Empleado[] empleados = new Empleado[700];
        
        // CONSTRUCTOR
        
        public Proyecto(String nombre, LocalDate fechaInicio, LocalDate fechaTermino, double presupuesto) {
            this.nombre = nombre;
            this.fechaInicio = fechaInicio;
            this.fechaTermino = fechaTermino;
            this.presupuesto = presupuesto;
        }
        
        // MÉTODOS
        
        /**
         * Añade un empleado al proyecto
         * @param e Empleado a añadir
         */
        
        public void añadirEmpleado(Empleado e) {
            for (int i = 0; i < empleados.length; i++) {
                if (i>0) {
                    if (this.empleados[i-1] != null && this.empleados[i] == null && this.empleados[i-1] != e) {
                        this.empleados[i] = e;
                    }
                } else if (i==0) {
                    if (this.empleados[i] == null) {
                        this.empleados[i] = e;
                    }
                }
            }
        }
        
        /**
         * Elimina un empleado del proyecto
         * @param e Empleado a eliminar
         */
        
        public void eliminarEmpleado(Empleado e) {
            for (int i = 0; i < empleados.length; i++) {
                if (this.empleados[i] == e) {
                    this.empleados[i] = null;
                }
            }
        }
        
        /**
         * Muestra por pantalla los empleados asociados al proyecto
         */
        
        public void listarEmpleados() {
            String listaEmpleados = "";
            for (int i = 0; i < empleados.length; i++) {
                if (i > 0 && this.empleados[i] != null) {
                    listaEmpleados = listaEmpleados.concat(", ");
                }
                if (this.empleados[i] != null) {
                   listaEmpleados = listaEmpleados.concat(empleados[i].nombre);
                   listaEmpleados = listaEmpleados.concat(" ");
                   listaEmpleados = listaEmpleados.concat(empleados[i].apellido);
                }
            } System.out.println(listaEmpleados);
        }
    }
    
    /**
     * Tiene los métodos que calculan los distintos bonus de cada tipo de empleado, 
     * teniendo en cuenta la variable que impulsa este bonus. 
     */
    
    public class CalculadoraSalario {
        
        // MÉTODOS
        
        public static double calcularBonusDesarrolador(Desarrollador d, int horasExtra) {
            double salarioHora = d.salarioBase/12/4/7/8;
            return (salarioHora*1.75)*horasExtra;
        }
        
        public static double calcularBonusDiseñador(Diseñador d, int proyectosCompletados) {
            double bonusPorProyecto = d.salarioBase*0.01;
            return (bonusPorProyecto*proyectosCompletados);
        }
        
        public static double calcularBonusGerente(GerenteProyecto g, int proyectosGestionados) {
            double bonusPorProyecto = g.salarioBase*0.03;
            return (bonusPorProyecto*proyectosGestionados);
        }
        
        public static double calcularBonusDirector(DirectorTecnico d, double rendimientoDepartamento) {
            double bonusSalarioBase = d.salarioBase*0.003;
            return (bonusSalarioBase*rendimientoDepartamento);
        }
    }
    
    /**
     * Almacena los empleados principales del sistema y lleva a cabo métodos
     * con ellos.
     */
    
    public static class GestorPersonal {
        
        // ATRIBUTOS
        
        public Empleado[] empleados = new Empleado[700];
        
        // MÉTODOS
        
        /**
         * Añade un empleado a la lista de empleados del gestor
         * @param e Empleado a añadir
         */
        
        public void añadirEmpleado(Empleado e) {
            for (int i = 0; i < empleados.length; i++) {
                if (i>0) {
                    if (this.empleados[i-1] != null && this.empleados[i] == null && this.empleados[i-1] != e) {
                        this.empleados[i] = e;
                    }
                } else if (i==0) {
                    if (this.empleados[i] == null) {
                        this.empleados[i] = e;
                    }
                }
            }
        }
        
        /**
         * Elimina un empleado de la lista de empleados del gestor
         * @param e Empleado a eliminar
         */
        
        public void eliminarEmpleado(Empleado e) {
            for (int i = 0; i < empleados.length; i++) {
                if (this.empleados[i] == e) {
                    this.empleados[i] = null;
                }
            }
        }
        
        public void asignarProyecto(GerenteProyecto g, Proyecto p) {
            g.asignarProyecto(p);
        }
        
        public void asignarProyecto(DirectorTecnico d, Proyecto p) {
            d.asignarProyecto(p);
        }
        
        /**
         * Asigna una puntuación de evaluación a un empleado
         * @param e Empleado a añadir la puntuación
         * @param puntuacion puntuación int a añadir
         */
        
        public void realizarEvaluacion(Empleado e, int puntuacion) {
            e.puntuacionEvaluacion = puntuacion;
        }
        
        /**
         * Muesta los detalles de todos los empleados
         */
        
        public void mostrarDetallesEmpleados() {
            for (int i = 0; i < empleados.length; i++) {
                if (empleados[i] != null) {
                    empleados[i].mostrarDetalles();
                }
            }
        }
        
        /**
         * Calcula todos los salarios mediante inputs, mostrándolos por pantalla
         */
        
        public void calcularYmostrarSalarios() {
            for (int i = 0; i < empleados.length; i++) {
                if (empleados[i] != null) {
                    System.out.println(empleados[i].calcularSalario());
                }
            }
        }
    }
}
