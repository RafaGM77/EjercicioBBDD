package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class delete {
	
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
	    
	    try {
			Connection c = DriverManager.getConnection(urlConnection, user, pwd);
			
			//Con statment
			/*Statement s = c.createStatement();
			int filas = s.executeUpdate("delete from clientes where DNI = '51542023M'");
			System.out.println(filas + " filas modificadas");*/
			
			//Con preparedStatment
			PreparedStatement ps = c.prepareStatement("delete from clientes where DNI = ?");
			
			ps.setString(1, "51542023M");
			ps.executeUpdate();
			
			c.close();
		}
		catch (SQLException e) {
			muestraErrorSQL(e);
		} 
		catch (Exception e) {
			 e.printStackTrace(System.err);
		}
	}

}
