package AdminX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Conectar.SubirLibro;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.SystemColor;

public class SubirPDF extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Buscarpdf;
	private JButton ButtonSearch;
	private ElegirArchivo archivo = new ElegirArchivo();
	private JButton ButtonSearch_1;
	private JTextField FileName;
	private JTextField Codigo;
	@SuppressWarnings("rawtypes")
	private JComboBox Opciones;
	public String Generos []= {null , "Bases de datos", "Estructuras de datos", "Cálculo diferencial", "Cálculo Integral","Álgebra", "Matemáticas", "Autómatas, Gramaticas y lenguajes"};
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubirPDF frame = new SubirPDF();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("unchecked")
	public SubirPDF() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Buscarpdf = new JTextField();
		Buscarpdf.setEditable(false);
		Buscarpdf.setBounds(40, 29, 365, 20);
		panel.add(Buscarpdf);
		Buscarpdf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ruta de archivo");
		lblNewLabel.setBounds(184, 11, 89, 14);
		panel.add(lblNewLabel);
		
		ButtonSearch = new JButton("Buscar");
		ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscarpdf.setText(archivo.DireccionArchivo());
				if(!Buscarpdf.getText().equals(null) && Buscarpdf.getText().contains(".pdf")) {
					ButtonSearch_1.setEnabled(true);
					FileName.setEditable(true);
					Codigo.setEditable(true);			
				}
			}
		});
		ButtonSearch.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		ButtonSearch.setBackground(Color.LIGHT_GRAY);
		ButtonSearch.setBorder(new LineBorder(new Color(0x737373), 1));
		ButtonSearch.setBounds(316, 60, 89, 23);
		panel.add(ButtonSearch);
		
		FileName = new JTextField();
		FileName.setBounds(40, 60, 103, 20);
		FileName.setEditable(false);
		panel.add(FileName);
		FileName.setColumns(10);
		
		Codigo = new JTextField();
		Codigo.setEditable(false);
		Codigo.setColumns(10);
		Codigo.setBounds(40, 122, 103, 20);
		panel.add(Codigo);
		
		Opciones = new JComboBox(Generos);
		Opciones.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		Opciones.setBounds(40, 91, 103, 22);
		panel.add(Opciones);
		
		ButtonSearch_1 = new JButton("Subir");
		ButtonSearch_1.setEnabled(false);
		ButtonSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!FileName.equals(null) && !Codigo.equals(null) && !Buscarpdf.equals(null) && Opciones.getSelectedItem()!= null) {
					SubirLibro subir = new SubirLibro();
					if(subir.SubirPDF(FileName.getText(), ConvertirPDF(Buscarpdf.getText()), Codigo.getText(), (String) Opciones.getSelectedItem())) {
						JOptionPane.showMessageDialog(null, "¡PDF subido con éxito!");
					} else {
						JOptionPane.showMessageDialog(null, "Error al subir el archivo");
					}
					
				}
			}
		});
		ButtonSearch_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		ButtonSearch_1.setBorder(new LineBorder(new Color(0x737373), 1));
		ButtonSearch_1.setBackground(Color.LIGHT_GRAY);
		ButtonSearch_1.setBounds(316, 121, 89, 23);
		panel.add(ButtonSearch_1);
		
		btnNewButton = new JButton("<-");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminOptions admin = new AdminOptions();
				admin.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setBounds(40, 227, 45, 23);
		panel.add(btnNewButton);

	}
	
	
	public FileInputStream ConvertirPDF(String ruta_archivo) {
		File pdf = new File(ruta_archivo);
		FileInputStream PDF = null;
		try {
			PDF = new FileInputStream(pdf);
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Ruta de archivo no encontrada");
		}
		return PDF;		
	}
	

}
