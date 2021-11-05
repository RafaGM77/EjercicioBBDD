package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class update {
	
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
			int filas = s.executeUpdate("UPDATE clientes SET CP = '28702' WHERE DNI = '09876543K'");
			System.out.println(filas + " filas modificadas");*/
			
			//Con preparesStatment
			PreparedStatement ps = c.prepareStatement("UPDATE clientes SET CP = ? WHERE DNI = ?");
			
			ps.setString(1, "28703");
			ps.setString(2, "89012345E");
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
