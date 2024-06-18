package AdminX;

import java.io.File;

import javax.swing.JFileChooser;

public class ElegirArchivo {

	public ElegirArchivo() {
		
	}
	
	public String DireccionArchivo() {
		JFileChooser chooser = new JFileChooser();
		//chooser.showOpenDialog(null); // seleccionamos el archivo a abrir
		int response = chooser.showSaveDialog(null);
		
		if(response == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			String fileAddress = file.getAbsolutePath();
			return fileAddress;
		} else {
			return "";
		}
		
	}
}
