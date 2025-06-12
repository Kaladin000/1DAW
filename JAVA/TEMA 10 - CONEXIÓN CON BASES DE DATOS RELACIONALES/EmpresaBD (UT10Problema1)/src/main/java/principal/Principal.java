package principal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;
import model.Connexio;
import model.Empleat;
import model.EmpleatDAO;
import model.Oficina;
import model.OficinaDAO;

public class Principal {

    public static void main(String[] args) {
        try {
            Scanner teclat = new Scanner(System.in);
            Connexio connexio = Connexio.getConnexio();

            // 1 - RESOLT
            ArrayList<Empleat> listaEmpleats = new ArrayList<>();
            String sql1 = "SELECT * FROM Empleats";
            PreparedStatement prepared1 = connexio.getPrepared(sql1);
            ResultSet rs1 = prepared1.executeQuery();
            while (rs1.next()) {
                int numeroEmpleat = rs1.getInt("numemp");
                String nom = rs1.getString("nom");
                int edat = rs1.getInt("edat");
                int oficina = rs1.getInt("oficina");
                String ocupacio = rs1.getString("ocupacio");
                LocalDate contracte = rs1.getDate("contracte").toLocalDate();
                System.out.println(numeroEmpleat + " - " + nom + " - " + edat + " - " + oficina + " - " + ocupacio + " - " + contracte);
                listaEmpleats.add(new Empleat(numeroEmpleat, nom, edat, oficina, ocupacio, contracte)); // Esto lo he hecho para el ejercicio 4
            }

            //2 - Implementa classes i mètodes que calguen.
            
            OficinaDAO oficinaDAO = new OficinaDAO();
            System.out.println(oficinaDAO.getAll(connexio).toString());
            
            

            //3 - Implementa classes i mètodes que calguen.
            
            System.out.print("Introdueix ciutat: ");
            String ciutatString = teclat.nextLine();
            
            
            Stream<Oficina> streamOficina = oficinaDAO.getAll(connexio).stream()
                    .filter(o -> o.getCiutat().equals(ciutatString));
            System.out.println(streamOficina.toList());

            //4
            
            System.out.print("Introdueix edat mínima: ");
            int minima = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix edat màxima: ");
            int maxima = teclat.nextInt();
            teclat.nextLine();
            
            Stream<Empleat> streamEmpleat = listaEmpleats.stream()
                    .filter(e -> e.getEdat() >= minima && e.getEdat() <= maxima);
            System.out.println(streamEmpleat.toList());

            //5
            
            
            /*
            
            
            System.out.print("Introdueix num empleat: ");
            while (!teclat.hasNextInt()) {
                System.out.print("Num invalid. Introdueix num empleat: ");
                teclat.next();
            } int numeroEmpleat = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix nom: ");
            String nom = teclat.nextLine();
            System.out.print("Introdueix edat: ");
            while (!teclat.hasNextInt()) {
                System.out.print("Num invalid. Introdueix edat: ");
                teclat.next();
            } int edat = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix codi oficina: ");
            while (!teclat.hasNextInt()) {
                System.out.print("Num invalid. Introdueix codi oficina: ");
                teclat.next();
            } int oficina = teclat.nextInt();
            teclat.nextLine();
            System.out.print("Introdueix ocupació: ");
            String ocupacio = teclat.nextLine();
            
            
            String sql2 = "INSERT INTO Empleats (numemp, nom, edat, oficina, ocupacio, contracte) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prepared2 = connexio.getPrepared(sql2);
            
            prepared2.setInt(1, numeroEmpleat);
            prepared2.setString(2, nom);
            prepared2.setInt(3, edat);
            prepared2.setInt(4, oficina);
            prepared2.setString(5, ocupacio);
            prepared2.setDate(6, Date.valueOf(LocalDate.now()));
            
            prepared2.executeUpdate();

            
            */
            
            
            //6-7-8 Implementa classes i mètodes que calguen.
            Empleat empleatAInserir = new Empleat(500, "Miriam", 25, 7, "Programador", LocalDate.now());
            new EmpleatDAO().afegir(empleatAInserir, connexio);

            // 9 Implementa classes i mètodes que calguen.
            
            // Captura adjunta.
            
            new EmpleatDAO().moure(3, 1, connexio);
            
            //10 Implementa classes i mètodes que calguen.
            new EmpleatDAO().eliminar(400, connexio);
            
            //11
            
            // Este ejercicio es el mismo que el 2. Captura adjunta
            System.out.println(oficinaDAO.getAll(connexio).toString());
            
            
            //12
            
            System.out.print("Introdueix una superficie mínima: ");
            int superficie = teclat.nextInt();
            teclat.nextLine();
            
            Stream<Oficina> streamOficina2 = oficinaDAO.getAll(connexio).stream()
                    .filter(o -> o.getSuperficie() > superficie);
            System.out.println(streamOficina2.toList());
            
            //13
            oficinaDAO.actualitzarCiutat(3, "Sax", connexio);
            
            //14
            oficinaDAO.incrementarVendes(3, 340000, connexio);

            connexio.getDatasource().close();

        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex);
        }

    }
}
