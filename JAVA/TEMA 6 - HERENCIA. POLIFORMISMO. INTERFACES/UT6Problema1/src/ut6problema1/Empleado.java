package ut6problema1;
import java.util.Scanner;

/**
 * String padre de las subclases Desarrollador, Diseñador, GerenteProyecto
 * y DirectorTecnico. Almacena detalles personales del empleado así como su
 * identificación principal y su salario base. Almacena una puntuación que podrá
 * asignar un Empleado Gestionable.
 * @author David García Valero
 */
public abstract class Empleado {
        
    public static Scanner input = new Scanner(System.in);
    
    // ATRIBUTOS
        
    protected String nombre;
    protected String apellido;
    protected int id;
    protected double salarioBase;
    protected int puntuacionEvaluacion;
        
    // CONSTRUCTOR
       
    public Empleado(String nombre, String apellido, int id, double salarioBase) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.salarioBase = salarioBase;
        this.puntuacionEvaluacion = 0;
    }
        
    // MÉTODOS
    
    /**
     * Devuelve un string con el nombre y apellido del empleado
     * @return String con el nombre completo del empleado
     */
    
    public String getNombreCompleto() {
        String nombreCompleto = this.nombre + " " + this.apellido;
        return nombreCompleto;
    }
        
    /**
     * Pide un input int, lo valida y actualiza el salario del empleado
     */
        
    public void setSalarioBase() {
        System.out.println("Introduce el salario base");
        while (!input.hasNextDouble()) {
            System.out.println("ERROR. Has introducido un número incorrecto");
            input.next();
        } double salario = input.nextDouble();
        while (salario < 0) {
            System.out.println("ERROR. Has introducido un número negativo");
            while (!input.hasNextDouble()) {
                System.out.println("ERROR. Has introducido un número incorrecto");
                salario = input.nextDouble();
            }
            salario = input.nextDouble();
        } input.nextLine();
        this.salarioBase = salario;
    }
        
    // MÉTODOS ABSTRACTOS
    
    /**
     * Calcula el salario total de un empleado en base a su tipo de bonus
     * @return Salario total del empleado
     */
    public abstract double calcularSalario();
    
    /**
     * Muestra los detalles completos del empleado.
     */
    public abstract void mostrarDetalles();
}
