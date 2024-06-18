package Libreria;

import java.io.File;

public class Libro {
	public String titulo;
	public String autor;
	public File pdf;
	
	public Libro(String titulo_, String autor_, File pdf_) {
		this.titulo = titulo_;
		this.autor = autor_;
		this.pdf = pdf_;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public File getPdf() {
		return pdf;
	}

	public void setPdf(File pdf) {
		this.pdf = pdf;
	}
	
	

}
