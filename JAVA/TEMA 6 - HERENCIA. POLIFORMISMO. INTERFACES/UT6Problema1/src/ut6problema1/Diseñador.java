package ut6problema1;

import ut6problema1.UT6Problema1.CalculadoraSalario;

/**
 * Subclase de Empleado, como atributo único tiene un String lista de herramientas
 * de diseño que maneja el Diseñador
 * @author David García Valero
 */
public class Diseñador extends Empleado implements Evaluable {
        
        // ATRIBUTO
        
        public String[] herramientas = new String[700];
        
        // CONSTUCTOR
        
        public Diseñador(String nombre, String apellido, int id, double salarioBase, String[] herramientas) {
            super(nombre, apellido, id, salarioBase);
            this.nombre = nombre;
            this.apellido = apellido;
            this.id = id;
            this.salarioBase = salarioBase;
            this.herramientas = herramientas;
            this.puntuacionEvaluacion = 0;
        }
        
        // MÉTODOS
        
        /**
         * Calcula el salario total en base al salario base y las
         * horas extras trabajadas del diseñador.
         * @return devuelve el salario total del diseñador
         */
        
        public double calcularSalario() {
            
            System.out.println("Introduce el número de proyectos completados");
            while (!input.hasNextInt()) {
                System.out.println("ERROR. Has introducido un número incorrecto");
                input.next();
            } int proyectosCompletados = input.nextInt();
            while (proyectosCompletados < 0) {
                System.out.println("ERROR. Has introducido un número negativo");
                while (!input.hasNextInt()) {
                    System.out.println("ERROR. Has introducido un número incorrecto");
                    proyectosCompletados = input.nextInt();
                }
                proyectosCompletados = input.nextInt();
            } input.nextLine();
            
            double salario = this.salarioBase+CalculadoraSalario.calcularBonusDiseñador(this, proyectosCompletados);
            return (salario);
        }
        
        public void mostrarDetalles() {
            String detalles = "El diseñador " + nombre + " " + apellido + " con id " + id + " tiene un salario base de " + salarioBase + "€" + " y maneja las siguientes herramientas: ";
            for (int i = 0; i < herramientas.length; i++) {
                if (i > 0) {
                    detalles = detalles.concat(", ");
                }
                detalles = detalles.concat(herramientas[i]);
            }
            System.out.println(detalles);
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
