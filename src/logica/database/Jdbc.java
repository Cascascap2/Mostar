package logica.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Jdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/mostar?useSSL=false";
		String user = "root";
		String pass = "root";
		
		try {
			System.out.println("Connecting to database...");
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection successful");			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
