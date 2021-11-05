package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class resultSetPreparedStatement {
	
	public static void muestraErrorSQL(SQLException e) {
	    System.err.println("SQL ERROR mensaje: " + e.getMessage());
	    System.err.println("SQL Estado: " + e.getSQLState());
	    System.err.println("SQL codigo: " + e.getErrorCode());
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
	    
	    Statement stmt = null;
		ResultSet rs = null;
	    
	    try {
	    	Connection conn = DriverManager.getConnection(urlConnection, user, pwd);
	    	stmt = conn.createStatement();

	    	stmt.executeUpdate("DROP TABLE IF EXISTS coche");
	    	stmt.executeUpdate(
	    			"CREATE TABLE coche ("
	    		    + "id INT NOT NULL AUTO_INCREMENT, "
	    		    + "marca VARCHAR(64), PRIMARY KEY (id))");

	    	PreparedStatement sInsert = conn.prepareStatement("INSERT INTO coche (marca) VALUES (?)",
	    			PreparedStatement.RETURN_GENERATED_KEYS); 

	    	sInsert.setString(1, "Toyota");
	    	sInsert.executeUpdate();

	    	int autoIncKeyFromApi = -1;

	    	rs = sInsert.getGeneratedKeys();

	    	if (rs.next()) {
	    		autoIncKeyFromApi = rs.getInt(1);
	    	} 
	    	else {
	    		// throw an exception from here
	    	}

	    	System.out.println("Key returned from getGeneratedKeys():" + autoIncKeyFromApi);
	    		    
	    } 
	    catch (SQLException e) {
	    	e.printStackTrace();			
		} 
	    finally {
	    	if (rs != null) {
	    		try {
	    			rs.close();
	    		} 
	    		catch (SQLException ex) {
	    		    // ignore
	    		}
	    	}
	    	if (stmt != null) {
	    		try {
	    			stmt.close();
	    		 } 
	    		catch (SQLException ex) {
	    		     // ignore
	    		}
	    	}
	      }
	    System.out.println();
	}

}
