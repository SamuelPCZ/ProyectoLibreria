
package Libreria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Conectar.SubirLibro;
import IngresoLibreria.Ingreso;
import IngresoLibreria.labeldetails;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Button;


public class Eleccion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private labeldetails ajuste = new labeldetails();
	private SubirLibro libros = new SubirLibro();
	private JTextField textField;
	private JComboBox<String> Resultados = new JComboBox();
	private JButton btnAbrir;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleccion frame = new Eleccion("");
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
	public Eleccion(String UserName) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Imagenes/libro.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 410);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Eleccion.class.getResource("/Imagenes/libro.png")));
		lblNewLabel.setBounds(138, 11, 150, 143);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido " + UserName);
		lblNewLabel_1.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(138, 180, 160, 14);
		contentPane.add(lblNewLabel_1);
		
		Resultados.setBounds(21, 267, 387, 22);
		contentPane.add(Resultados);
		Resultados.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(21, 212, 298, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resultados = llenarBox(Resultados, libros, textField);
				btnAbrir.setVisible(true);
			}
		});
		btnNewButton.setBounds(319, 212, 89, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<-");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ingreso in = new Ingreso();
				in.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1.setBounds(10, 11, 45, 23);
		contentPane.add(btnNewButton_1);
		
		btnAbrir = new JButton("abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int libro = Resultados.getSelectedIndex();
				abrirPDF(libros.Coincidencias(textField.getText()).get(libro).pdf);
			}
		});
		btnAbrir.setBounds(319, 300, 89, 20);
		btnAbrir.setVisible(false);
		contentPane.add(btnAbrir);
		
		
	}
	
	
	public void abrirPDF(File abrir) {
		try {
			Desktop.getDesktop().open(abrir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  JComboBox<String> llenarBox(JComboBox <String> Resultados, SubirLibro libros, JTextField textField) {
		Resultados.removeAllItems();
		if(!libros.Coincidencias(textField.getText()).equals(null)) {
			for(Libro Nombre : libros.Coincidencias(textField.getText())) {
				Resultados.addItem(Nombre.titulo);
			}
			Resultados.setVisible(true);		
		} else {
			JOptionPane.showMessageDialog(null, "NO hay resultados para su busqueda");
		}
		return Resultados;
	}
}
