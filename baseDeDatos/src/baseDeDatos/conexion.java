package baseDeDatos;

import java.sql.*;

public class conexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "Rafael1998"); 
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from persona");
			
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
			con.close();
		} 
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
