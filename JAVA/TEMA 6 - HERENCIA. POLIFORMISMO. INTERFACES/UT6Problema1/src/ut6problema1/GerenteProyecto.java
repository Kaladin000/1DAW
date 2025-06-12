package ut6problema1;

import ut6problema1.UT6Problema1.CalculadoraSalario;
import ut6problema1.UT6Problema1.Proyecto;

/**
 * Subclase de Empleado, tiene implementada la interfície Gestionable, por lo tanto
 * es capaz de interactuar con su propia lista de proyectos, añadir, eliminar o listar
 * su lista
 * @author David García Valero
 */
public class GerenteProyecto extends Empleado implements Gestionable, Evaluable{
    
        // ATRIBUTO
        
        public Proyecto[] proyectos = new Proyecto[700];
        
        // CONSTUCTOR
        
        public GerenteProyecto(String nombre, String apellido, int id, double salarioBase) {
            super(nombre, apellido, id, salarioBase);
            this.nombre = nombre;
            this.apellido = apellido;
            this.id = id;
            this.salarioBase = salarioBase;
            this.puntuacionEvaluacion = 0;
        }
        
        // MÉTODOS
        
        /**
         * Calcula el salario total en base al salario base y los proyectos
         * gestionados por el gerente.
         * @return devuelve el salario total del gerente
         */
        
        public double calcularSalario() {
            
            System.out.println("Introduce el número de proyectos gestionados");
            while (!input.hasNextInt()) {
                System.out.println("ERROR. Has introducido un número incorrecto");
                input.next();
            } int proyectosGestionados = input.nextInt();
            while (proyectosGestionados < 0) {
                System.out.println("ERROR. Has introducido un número negativo");
                while (!input.hasNextInt()) {
                    System.out.println("ERROR. Has introducido un número incorrecto");
                    proyectosGestionados = input.nextInt();
                }
                proyectosGestionados = input.nextInt();
            } input.nextLine();
            
            double salario = this.salarioBase+CalculadoraSalario.calcularBonusGerente(this, proyectosGestionados);
            return (salario);
        }
        
        public void mostrarDetalles() {
            String detalles = "El gerente de proyectos " + nombre + " " + apellido + " con id " + id + " tiene un salario base de " + salarioBase + "€" + " y tiene asociados los siguientes proyectos: ";
            System.out.println(detalles);
            this.listarProyectos();
        }
        
        @Override
        public void asignarProyecto(Proyecto p) {
            for (int i = 0; i < proyectos.length; i++) {
                if (i>0) {
                    if (this.proyectos[i-1] != null && this.proyectos[i] == null && this.proyectos[i-1] != p) {
                        this.proyectos[i] = p;
                    }
                } else if (i==0) {
                    if (this.proyectos[i] == null) {
                        this.proyectos[i] = p;
                    }
                }
            }
        }
        
        @Override
        public void eliminarProyecto(Proyecto p) {
            for (int i = 0; i < proyectos.length; i++) {
                if (this.proyectos[i] == p) {
                    this.proyectos[i] = null;
                }
            }
        }
        
        @Override
        public void listarProyectos() {
            String listaProyectos = "";
            for (int i = 0; i < proyectos.length; i++) {
                if (i > 0 && this.proyectos[i] != null) {
                    listaProyectos = listaProyectos.concat(", ");
                }
                if (this.proyectos[i] != null) {
                   listaProyectos = listaProyectos.concat(proyectos[i].nombre);
                }
            } System.out.println(listaProyectos);
        }
        
        @Override
        public void evaluar(int puntuacion) {
            this.puntuacionEvaluacion = puntuacion;
        }
        
        @Override
        public int obtenerEvaluacionActual() {
            return (this.puntuacionEvaluacion);
        }
    }
