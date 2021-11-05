package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class preparedStatement {
	
	public static void muestraErrorSQL(SQLException e) {
	    System.err.println("SQL ERROR mensaje: " + e.getMessage());
	    System.err.println("SQL Estado: " + e.getSQLState());
	    System.err.println("SQL c�digo especifico: " + e.getErrorCode());
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
	      PreparedStatement sInsert = c.prepareStatement("INSERT INTO CLIENTES(DNI,APELLIDOS,CP) VALUES (?,?,?);")) {

	      sInsert.setString(1, "51542023M");
	      sInsert.setString(2, "Martin");
	      sInsert.setInt(3, 28502);

	      sInsert.executeUpdate();

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
