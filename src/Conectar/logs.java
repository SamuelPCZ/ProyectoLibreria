package Conectar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class logs {
	
	private String Usuario;
	private String Clave;
	private String Correo;
	private Connection cn = null;
	private Conectar conect = new Conectar();
	private Statement sentences = null;
	
	public logs(String user, String password, String mail) {
		this.Usuario = user;
		this.Clave = password;
		this.Correo = mail;
	}
	
	public logs() {
		
	}
	
	public boolean send() {	
		try {
			cn = conect.Conectar();
			sentences = cn.createStatement();
			String enviar = "insert into registro (Usuario, Clave, Correo) values ('"+ Usuario + "','" + Clave + "','" +Correo +"')";
			sentences.executeUpdate(enviar);
			
			sentences.close();
			cn.close();
			return true;
		}catch(SQLException e){
			if(e.getSQLState().equals("1062")) {
				JOptionPane.showMessageDialog(null, "El Usuario ya está registrado");
			} 
			return false;
		}
	}
	
	public void mostrarID() {
		try {
			cn = conect.Conectar();
			sentences = cn.createStatement();
			String id = "select idUsuario from registro where Usuario = '" + Usuario + "'";
			ResultSet mostrar = sentences.executeQuery(id);
			 while (mostrar.next()) {
			        String Id = mostrar.getString("idUsuario");
			        JOptionPane.showMessageDialog(null, "Su id es: " + Id);
			   }
			sentences.close(); 
			mostrar.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int checkLogIn(String user, String password) {
		String passwsql = null;
		int id = 0;
		try {
			cn = conect.Conectar();
			sentences = cn.createStatement();
			String sentence = "select Clave from registro where Usuario = '" + user + "'";
			ResultSet muestra = sentences.executeQuery(sentence);			
			
			while(muestra.next()) {
				passwsql = muestra.getString("Clave");
			}
			
			
			sentence = "select idUsuario from registro where Usuario = '" + user + "'";
			muestra = sentences.executeQuery(sentence);
			while (muestra.next()) {
			    id = muestra.getInt("idUsuario");
			}
			sentences.close(); 
			muestra.close();
			cn.close();	
			System.out.println(password + " "+ passwsql);
			if (password.equals(passwsql)) return id;
			else return -1;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return -1;
		}
		
	}
	
}
