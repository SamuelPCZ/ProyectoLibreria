package IngresoLibreria;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class labeldetails {
	public labeldetails() {
		
	}
	
	//Metodo para ajustar el tamaño de una imagen con base al tamaño del JButton
	public Icon resizableIcon(String url, JButton boton) {
		ImageIcon icon1 = new ImageIcon(url); 
		int anchoBoton = boton.getWidth();
		int altoBoton = boton.getHeight();
		
		ImageIcon finalIcon = new ImageIcon(icon1.getImage().getScaledInstance(anchoBoton, altoBoton, Image.SCALE_SMOOTH));
		return finalIcon;
		
	}
	
	//Metodo para ajustar el tamaño de una imagen con base al tamaño del JLabel
	public Icon resizableLabel(Image image, JLabel imagen) {
		ImageIcon icon1 = new ImageIcon(image);
		int ancho = imagen.getWidth();
		int alto = imagen.getHeight();
		
		ImageIcon finalIcon = new ImageIcon(icon1.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
		return finalIcon;
	}
}
