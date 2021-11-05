package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class select {
	
	public static void muestraErrorSQL(SQLException e) {
	    System.err.println("SQL ERROR mensaje: " + e.getMessage());
	    System.err.println("SQL Estado: " + e.getSQLState());
	    System.err.println("SQL codigo especifico: " + e.getErrorCode());
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String basedatos = "prueba";
	    String host = "localhost";
	    String port = "3306";
	    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
	    String user = "root";
	    String pwd = "Rafael1998";

	    try (
	      Connection c = DriverManager.getConnection(urlConnection, user, pwd);
	      Statement s = c.createStatement();
	      ResultSet rs = s.executeQuery("SELECT * FROM CLIENTES")) {

	      int i=1;
	      
	      while (rs.next()) {
	        System.out.println("[" + (i++) + "]");        
	        System.out.println("DNI: " + rs.getString("DNI"));
	        System.out.println("Apellidos: " + rs.getString("APELLIDOS"));
	        System.out.println("CP: " + rs.getString("CP"));
	      }

	    } 
	    catch (SQLException e) {
	      muestraErrorSQL(e);
	    } 
	    catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	}

}
