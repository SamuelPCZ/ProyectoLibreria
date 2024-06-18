package Conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
	public Connection Conectar() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("Base De datos", "Usuario","Contraseña Base de Datos");
		} catch(ClassNotFoundException e) {
			System.out.println("Error en controlador");
			System.out.println(e.getMessage());
		} catch(SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		return con;
	}
}
