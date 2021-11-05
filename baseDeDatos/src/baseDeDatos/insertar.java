package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class insertar {
	
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
	    		
	        Statement s = c.createStatement()) {
		      int nFil = s.executeUpdate("INSERT INTO CLIENTES (DNI,APELLIDOS,CP) VALUES "
		              										+ "('78901234X','GARCIA','44126'),"
		              										+ "('89012345E','RODRIGUEZ', null),"
		              										+ "('56789012B','ANDUJAR','29730'),"
		              										+ "('09876543K','PEREZ', null);");
	
		      System.out.println(nFil + " Filas insertadas.");
	
		    } 
	    catch (SQLException e) {
	      muestraErrorSQL(e);
	    } 
	    catch (Exception e) {
	      e.printStackTrace(System.err);
	    }
	    System.out.println();
	}

}
