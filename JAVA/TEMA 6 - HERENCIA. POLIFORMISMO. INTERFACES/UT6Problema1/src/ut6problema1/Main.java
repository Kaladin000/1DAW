package ut6problema1;
import java.time.LocalDate;
import ut6problema1.Empleado;
import ut6problema1.UT6Problema1.GestorPersonal;
import ut6problema1.UT6Problema1.Proyecto;
import java.util.Scanner;

/**
 * Esta es la clase principal del proyecto, contiene todas las pruebas del sistema
 * y un menú de usuario, la extensión opcional.
 * @author David García Valero
 */

public class Main {
    public static void main(String[] args) {
        GestorPersonal gestor = new GestorPersonal();
        
        // DESARROLLADORES
        
        Desarrollador dev1 = new Desarrollador("Juan", "Castillo", 1001, 30000, new String[]{"Java", "Python"});
        Desarrollador dev2 = new Desarrollador("Lucía", "Botella", 1002, 34000, new String[]{"Java", "Python", "Javascript", "C#"});
        
        gestor.añadirEmpleado(dev1);
        gestor.añadirEmpleado(dev2);
        
        // DISEÑADORES
        
        Diseñador dis1 = new Diseñador("Ana", "Torres", 2001, 24000, new String[]{"Adobe Illustrator", "Procreate"});
        Diseñador dis2 = new Diseñador("Jose", "Luis", 2002, 24000, new String[]{"Adobe Illustrator", "Procreate", "Gimp"});
        
        gestor.añadirEmpleado(dis1);
        gestor.añadirEmpleado(dis2);
        
        // GERENTES
        
        GerenteProyecto ger1 = new GerenteProyecto("María", "Benedicta", 3001, 42000);
        GerenteProyecto ger2 = new GerenteProyecto("Mateo", "Ruiz", 3002, 42000);
        
        gestor.añadirEmpleado(ger1);
        gestor.añadirEmpleado(ger2);
        
        // DIRECTOR
        
        DirectorTecnico dir1 = new DirectorTecnico("Juan", "Castillo", 4001, 60000, "Diseño web");
        
        gestor.añadirEmpleado(dir1);
        
        DirectorTecnico dir2 = new DirectorTecnico("Prueba", "Eliminar", 4001, 60000, ""); 
        gestor.eliminarEmpleado(dir2);
        
        // PRUEBAS
        
        // EVALUACIÓN
        
        dev1.evaluar(80);
        dev2.evaluar(100);
        
        gestor.realizarEvaluacion(dis1, 65);
        gestor.realizarEvaluacion(dis2, 85);
        
        ger1.evaluar(98);
        ger2.evaluar(95);
        
        gestor.realizarEvaluacion(dir1, 100);
        
        int ev1 = dev1.obtenerEvaluacionActual();
        int ev2 = dev2.obtenerEvaluacionActual();
        int ev3 = dis1.obtenerEvaluacionActual();
        int ev4 = dis2.obtenerEvaluacionActual();
        int ev5 = ger1.obtenerEvaluacionActual();
        int ev6 = ger2.obtenerEvaluacionActual();
        int ev7 = dir1.obtenerEvaluacionActual();
        
        // CAMBIAR SALARIO BASE / CÁLCULOS SALARIO
        
        // dev1.setSalarioBase(); CAMBIA EL SALARIO BASE CON UN INPUT
        
        // gestor.calcularYmostrarSalarios(); CALCULA LOS BONUS EN BASE A LOS INPUTS, ESCOGE A LOS EMPLEADOS POR ORDEN DE LISTA, MUESTRA EL SALARIO TOTAL FINAL
        
        /* CALCULAR SALARIOS INDIVIDUALMENTE
        
        double sal1 = dev1.calcularSalario();
        double sal2 = dev2.calcularSalario();
        double sal3 = dis1.calcularSalario();
        double sal4 = dis2.calcularSalario();
        double sal5 = ger1.calcularSalario();
        double sal6 = ger2.calcularSalario();
        double sal7 = dir1.calcularSalario();
        
        */
        
        // PROYECTOS
        
        Proyecto pro1 = new Proyecto("Web de compras", LocalDate.of(2025,1,16), LocalDate.of(2025,6,16), 100000);
        ger1.asignarProyecto(pro1);
        ger1.eliminarProyecto(pro1);
        
        gestor.asignarProyecto(ger2, pro1);
        // ger2.listarProyectos(); MUESTRA LOS PROYECTOS ACTUALES DEL GERENTE 2
        
        pro1.añadirEmpleado(dev1);
        pro1.añadirEmpleado(dis1);
        pro1.añadirEmpleado(dis2);
        pro1.eliminarEmpleado(dis1);
        
        // pro1.listarEmpleados(); // MUESTRA LOS EMPLEADOS ASIGNADOS AL PROYECTO 1
        
        Proyecto pro2 = new Proyecto("Web de stock marketing", LocalDate.of(2025,1,16), LocalDate.of(2025,6,16), 100000);
        
        ger1.asignarProyecto(pro2);
        
        // MENÚ USUARIO (EX OPCIONAL)

        Scanner input = new Scanner(System.in);
        
        int menu = 0;
        
        while (menu != 4) {
            
            System.out.println("--------------------------------------");
            System.out.println("INTERACTÚA CON EL SISTEMA DE EMPLEADOS");
            System.out.println("1: MOSTRAR DETALLES DE LOS EMPLEADOS");
            System.out.println("2: MOSTRAR EVALUACIÓN DE LOS EMPLEADOS");
            System.out.println("3: CALCULAR Y MOSTRAR SALARIO DE LOS EMPLEADOS");
            System.out.println("4: SALIR");
            System.out.println("--------------------------------------");
            
            System.out.println("Introduce un número del menú");
            while (!input.hasNextInt()) {
                System.out.println("ERROR. Has introducido un número incorrecto");
                input.next();
            } menu = input.nextInt();
            while (menu <= 0 || menu >=5) {
                System.out.println("ERROR. Has introducido un número distinto");
                while (!input.hasNextInt()) {
                    System.out.println("ERROR. Has introducido un número incorrecto");
                    menu = input.nextInt();
                }
                menu = input.nextInt();
            } input.nextLine();
            
            if (menu == 1) {
                gestor.mostrarDetallesEmpleados();
                System.out.println("");
            } else if (menu == 2) {
                System.out.println(ev1 + ", " + dev1.nombre + " " + dev1.apellido);
                System.out.println(ev2 + ", " + dev2.nombre + " " + dev2.apellido);
                System.out.println(ev3 + ", " + dis1.nombre + " " + dis1.apellido);
                System.out.println(ev4 + ", " + dis2.nombre + " " + dis2.apellido);
                System.out.println(ev5 + ", " + ger1.nombre + " " + ger1.apellido);
                System.out.println(ev6 + ", " + ger2.nombre + " " + ger2.apellido);
                System.out.println(ev7 + ", " + dir1.nombre + " " + dir1.apellido);
                System.out.println("");
            } else if (menu == 3) {
                System.out.println("Calcula primero los ids 1001, 1002, luego los ids 2001, 2002, a continuación los ids 3001 y 3002 y por último el id 4001");
                double sal1 = dev1.calcularSalario();
                double sal2 = dev2.calcularSalario();
                double sal3 = dis1.calcularSalario();
                double sal4 = dis2.calcularSalario();
                double sal5 = ger1.calcularSalario();
                double sal6 = ger2.calcularSalario();
                double sal7 = dir1.calcularSalario();
                System.out.println("");
                System.out.println(sal1 + "€" + ", " + dev1.nombre + " " + dev1.apellido);
                System.out.println(sal2 + "€" + ", " + dev2.nombre + " " + dev2.apellido);
                System.out.println(sal3 + "€" + ", " + dis1.nombre + " " + dis1.apellido);
                System.out.println(sal4 + "€" + ", " + dis2.nombre + " " + dis2.apellido);
                System.out.println(sal5 + "€" + ", " + ger1.nombre + " " + ger1.apellido);
                System.out.println(sal6 + "€" + ", " + ger2.nombre + " " + ger2.apellido);
                System.out.println(sal7 + "€" + ", " + dir1.nombre + " " + dir1.apellido);
                System.out.println("");
            } else if (menu == 4) {
                break;
            }
        }
    }
}
