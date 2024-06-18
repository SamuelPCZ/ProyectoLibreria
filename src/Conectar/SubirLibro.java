package Conectar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Libreria.Libro;

public class SubirLibro {

	private Connection cn = null;
	private Conectar conect = new Conectar();
	private PreparedStatement sentences = null;
	private File PDFtemp;
	public SubirLibro() {
		
	}
	
	public boolean SubirPDF(String titulo, FileInputStream pdf, String id, String tipo) {
		
		try {
			cn = conect.Conectar();
			String enviar = "insert into libros (name, ArchivoPDF, id, Genero) values ('"+ titulo + "', ? ,'" + id +"','" + tipo +"')";
			sentences = cn.prepareStatement(enviar);
			sentences.setBinaryStream(1, pdf);
			sentences.executeUpdate();	
			
			pdf.close();
			sentences.close();
			cn.close();
			return true;
		}catch(SQLException e){
			System.out.println("Algo anda mal...");
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			System.out.println("Error en el PDF");
			return false;
		}
	}
	
	public List<Libro> Coincidencias(String Buscar){
		List <Libro> lista = new ArrayList<>();
		
		try {
			cn = conect.Conectar();
			String enviar = "select name from libros where name like '%" + Buscar +"%'";
			sentences = cn.prepareStatement(enviar);
			ResultSet resultado = sentences.executeQuery();
			
			enviar = "select id from libros where name like '%" + Buscar +"%'";
			sentences = cn.prepareStatement(enviar);
			ResultSet resultado2 = sentences.executeQuery();
			
			enviar = "select ArchivoPDF from libros where name like '%" + Buscar +"%'";
			sentences = cn.prepareStatement(enviar);
			ResultSet resultado3 = sentences.executeQuery();
			while(resultado.next() && resultado2.next() && resultado3.next()) {
				String Nombre = resultado.getString("name");
				String id = resultado2.getString("id");
				InputStream PDF = resultado3.getBinaryStream("ArchivoPDF");
				
				try {
					PDFtemp = File.createTempFile("tempPDF", ".pdf");
					try (FileOutputStream outputStream = new FileOutputStream(PDFtemp)) {
	                     // Copiar los datos del InputStream al archivo temporal
	                     byte[] buffer = new byte[1024];
	                     int bytesRead;
	                     while ((bytesRead = PDF.read(buffer)) != -1) {
	                         try {
								outputStream.write(buffer, 0, bytesRead);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
	                     }
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 
				Libro book = new Libro(Nombre, id, PDFtemp);
				lista.add(book);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;
	}
}
