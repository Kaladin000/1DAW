package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleatDAO {

    public void afegir(Empleat empleat, Connexio connexio) throws SQLException {
        String sql2 = "INSERT INTO Empleats (numemp, nom, edat, oficina, ocupacio, contracte) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement prepared2 = connexio.getPrepared(sql2);
        
        prepared2.setInt(1, empleat.getNumemp());
        prepared2.setString(2, empleat.getNom());
        prepared2.setInt(3, empleat.getEdat());
        prepared2.setInt(4, empleat.getOficina());
        prepared2.setString(5, empleat.getOcupacio());
        prepared2.setDate(6, Date.valueOf(empleat.getContracte()));
        
        boolean empleadoRepe = empleadoRepe(empleat, connexio);
        boolean existixOficina = existixOficina(empleat, connexio);
        
        if (empleadoRepe == false && existixOficina == true) {
            prepared2.executeUpdate();
            System.out.println("Empleado introducido correctamente");
        } else if (empleadoRepe == true) {
            System.out.println("El empleado introducido está repetido, no se ha introducido a la base de datos");
        } else if (existixOficina == false) {
            System.out.println("El empleado introducido tiene un número de oficina inexistente, no se ha introducido a la base de datos");
        } else if (empleadoRepe == true && existixOficina == false) {
            System.out.println("El empleado introducido tiene un número de oficina inexistente y está repetido, no se ha introducido a la base de datos");
        }
    }
    
    public boolean empleadoRepe(Empleat empleat, Connexio connexio) throws SQLException {
        
        String sql1 = "SELECT * FROM Empleats";
        PreparedStatement prepared1 = connexio.getPrepared(sql1);
        ResultSet rs1 = prepared1.executeQuery();
        
        Boolean empleadoRepe = false;
        while (rs1.next()) {
            if (empleat.getNumemp() == rs1.getInt("numemp")) {
                empleadoRepe = true;
                break;
            } 
        }
        
        return empleadoRepe;
    }
    
    public boolean existixOficina(Empleat empleat, Connexio connexio) throws SQLException {
        
        String sql1 = "SELECT * FROM Oficines";
        PreparedStatement prepared1 = connexio.getPrepared(sql1);
        ResultSet rs1 = prepared1.executeQuery();
        
        Boolean existixOficina = false;
        while (rs1.next()) {
            if (empleat.getOficina() == rs1.getInt("oficina")) {
                existixOficina = true;
                break;
            } 
        }
        
        return existixOficina;
        
    }
    
    public int moure(int numOficinaIn, int numOficinaOut, Connexio connexio) throws SQLException {
        String sentenciaSQL = "UPDATE Empleats SET oficina=? WHERE oficina=" + numOficinaIn;
        PreparedStatement prepared = connexio.getPrepared(sentenciaSQL);
        
        prepared.setInt(1, numOficinaOut);
        int resultado = prepared.executeUpdate();
        
        return resultado;
    }
    
    public int eliminar(int numemp, Connexio connexio) throws SQLException {
        String sentenciaSQL = "DELETE FROM Empleats WHERE numemp=" + numemp;
        PreparedStatement prepared = connexio.getPrepared(sentenciaSQL);
        
        int resultado = prepared.executeUpdate();
        
        return resultado;
    }
    
}
