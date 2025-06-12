package ut6problema1;

import ut6problema1.UT6Problema1.CalculadoraSalario;

/**
 * Subclase de Empleado, como atributo único tiene un String lista de lenguajes
 * de programación que maneja el Desarrollador
 * @author David García Valero
 */
public class Desarrollador extends Empleado implements Evaluable {
        
        // ATRIBUTO
        
        public String[] lenguajes = new String[700];
        
        // CONSTUCTOR
        
        public Desarrollador(String nombre, String apellido, int id, double salarioBase, String[] lenguajes) {
            super(nombre, apellido, id, salarioBase);
            this.nombre = nombre;
            this.apellido = apellido;
            this.id = id;
            this.salarioBase = salarioBase;
            this.lenguajes = lenguajes;
            this.puntuacionEvaluacion = 0;
        }
        
        // MÉTODOS
        
        /**
         * Calcula el salario total en base al salario base y las
         * horas extras trabajadas del desarrollador.
         * @return devuelve el salario total del desarrollador
         */
        
        public double calcularSalario() {
            
            System.out.println("Introduce las horas extra trabajadas");
            while (!input.hasNextInt()) {
                System.out.println("ERROR. Has introducido un número incorrecto");
                input.next();
            } int horasExtra = input.nextInt();
            while (horasExtra < 0) {
                System.out.println("ERROR. Has introducido un número negativo");
                while (!input.hasNextInt()) {
                    System.out.println("ERROR. Has introducido un número incorrecto");
                    horasExtra = input.nextInt();
                }
                horasExtra = input.nextInt();
            } input.nextLine();
            
            double salario = this.salarioBase+CalculadoraSalario.calcularBonusDesarrolador(this, horasExtra);
            return (salario);
        }
        
        public void mostrarDetalles() {
            String detalles = "El desarrollador " + nombre + " " + apellido + " con id " + id + " tiene un salario base de " + salarioBase + "€" + " y maneja los siguientes lenguajes: ";
            for (int i = 0; i < lenguajes.length; i++) {
                if (i > 0) {
                    detalles = detalles.concat(", ");
                }
                detalles = detalles.concat(lenguajes[i]);
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
