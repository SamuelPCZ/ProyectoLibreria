package IngresoLibreria;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AdminX.AdminOptions;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import Conectar.logs;
import Libreria.Eleccion;

import java.awt.SystemColor;

@SuppressWarnings("unused")
public class Ingreso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField User;
	private JPasswordField password;
	private JLabel lblNewLabel_2;
	private logs info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ingreso frame = new Ingreso();
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
	public Ingreso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("/Imagenes/papel.png"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Ingreso.class.getResource("/Imagenes/papel.png")));
		lblNewLabel.setBounds(107, 11, 154, 137);
		contentPane.add(lblNewLabel);
		
		User = new JTextField();
		User.setBounds(132, 195, 100, 20);
		contentPane.add(User);
		User.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(132, 242, 100, 20);
		contentPane.add(password);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(135, 178, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(134, 226, 72, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Registrarse");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro registro = new Registro(); // llamamos a la clase registro
				registro.setVisible(true);
				dispose();// hacemos que se dirija a la clase registro
			}
		});
		btnNewButton.setBounds(249, 273, 100, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ingresar");
		btnNewButton_1.setBackground(SystemColor.controlHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Eleccion options = new Eleccion(User.getText());
				AdminOptions openAdmin = new AdminOptions();
				info = new logs();
				
				int check = info.checkLogIn(User.getText(), password.getText());
				if(check == 1) {
					openAdmin.setVisible(true);
					dispose();
				} else if(check > 1) {
					options.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Usuario/contraseña Incorrectas");
				}
			}
		});
		btnNewButton_1.setBounds(132, 273, 100, 23);
		contentPane.add(btnNewButton_1);
	}
}
