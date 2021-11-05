package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class conexion2 {
	
	private static String db_ = "prueba";
	private static String login_ = "root";
	private static String password_ = "Rafael1998";
	private static String url_ = "jdbc:mysql://localhost:3306/" + db_;
	private static Connection connection_;
	private static Statement st_ = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			//Class.forName("com.mysql.cj.jdbc.Driver");
			connection_ = DriverManager.getConnection(url_, login_, password_);
			if (connection_ != null) {
				st_ = connection_.createStatement();
				System.out.println("Conexion a base de datos " + db_ + " OK.");
			} else
				System.out.println("Conexion fallida . ");
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

}
