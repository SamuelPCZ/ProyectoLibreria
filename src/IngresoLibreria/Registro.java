package IngresoLibreria;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Conectar.Conectar;
import Conectar.logs;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JTextField CorreoT;
	private JTextField clave;
	private JTextField claveconf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Imagenes\registro.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 353, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrarse");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setBounds(139, 11, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(74, 41, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		usuario = new JTextField();
		usuario.setBounds(182, 38, 103, 20);
		contentPane.add(usuario);
		usuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(74, 108, 73, 14);
		contentPane.add(lblNewLabel_2);
		
		clave = new JTextField();
		clave.setBounds(182, 105, 103, 20);
		contentPane.add(clave);
		clave.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("<html>Confirmar<br/>contraseña<html>");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel_2_1_1.setBounds(74, 134, 73, 33);
		contentPane.add(lblNewLabel_2_1_1);
		
		claveconf = new JTextField();
		claveconf.setBounds(182, 139, 103, 20);
		contentPane.add(claveconf);
		claveconf.setColumns(10);
		
		JButton Boton = new JButton("Registrarse");
		Boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Boton.setBackground(new Color(116,198,157));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Boton.setBackground(new Color(192, 192, 192));
			}
		});
		Boton.setFont(new Font("Arial", Font.PLAIN, 11));
		Boton.setBackground(new Color(192, 192, 192));
		Boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!clave.getText().equals(claveconf.getText())) {
					JOptionPane.showMessageDialog(null, "Las claves tienen que coincidir");
				} else if(!CorreoT.getText().contains("@") && !CorreoT.getText().contains(".com")) {
					JOptionPane.showMessageDialog(null, "Ingrese una dirección de correo valida");
				} else {
					logs login = new logs(usuario.getText(), clave.getText(), CorreoT.getText());
					if(login.send()) {
						JOptionPane.showMessageDialog(null, "Registro exitoso");
						Ingreso in = new Ingreso();
						in.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Algo anda mal...");
					}
				}
			}
		});
		Boton.setBounds(182, 182, 103, 23);
		contentPane.add(Boton);
		
		JLabel Correo = new JLabel("Correo");
		Correo.setFont(new Font("Arial", Font.PLAIN, 11));
		Correo.setBounds(74, 75, 46, 14);
		contentPane.add(Correo);
		
		CorreoT = new JTextField();
		CorreoT.setBounds(182, 72, 103, 20);
		contentPane.add(CorreoT);
		CorreoT.setColumns(10);
		
		JButton atras = new JButton("<-");
		atras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				atras.setBackground(new Color(248,96,96));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				atras.setBackground(SystemColor.activeCaptionBorder);
			}
		});
		atras.setBackground(SystemColor.activeCaptionBorder);
		atras.setFont(new Font("Arial", Font.PLAIN, 11));
		atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ingreso i = new Ingreso();
				i.setVisible(true);
			}
		});
		atras.setBounds(10, 182, 46, 23);
		contentPane.add(atras);
	}
}
