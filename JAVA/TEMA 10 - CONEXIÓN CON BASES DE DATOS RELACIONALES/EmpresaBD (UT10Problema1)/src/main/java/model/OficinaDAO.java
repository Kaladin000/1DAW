package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaDAO {

    public ArrayList<Oficina> getAll(Connexio con) throws SQLException {
        ArrayList<Oficina> lista = new ArrayList<>();
        String SQL = "SELECT * FROM Oficines";
        PreparedStatement prepared = con.getPrepared(SQL);
        ResultSet rs = prepared.executeQuery();

        while (rs.next()) {
            int oficina = rs.getInt("oficina");
            String ciutat = rs.getString("ciutat");
            double superficie = rs.getDouble("superficie");
            double vendes = rs.getDouble("vendes");
            lista.add(new Oficina(oficina, ciutat, superficie, vendes));
        }

        return lista;
    }
    
    public int actualitzarCiutat(int numOficinaIn, String ciutat, Connexio connexio) throws SQLException {
        String sentenciaSQL = "UPDATE Oficines SET ciutat=? WHERE oficina=" + numOficinaIn;
        PreparedStatement prepared = connexio.getPrepared(sentenciaSQL);
        
        prepared.setString(1, ciutat);
        int resultado = prepared.executeUpdate();
        
        return resultado;
    }
    
    public int incrementarVendes(int numOficinaIn, double vendes, Connexio connexio) throws SQLException {
        String sentenciaSQL = "UPDATE Oficines SET vendes=? WHERE oficina=" + numOficinaIn;
        PreparedStatement prepared = connexio.getPrepared(sentenciaSQL);
        
        prepared.setDouble(1, vendes);
        int resultado = prepared.executeUpdate();
        
        return resultado;
    }
}
