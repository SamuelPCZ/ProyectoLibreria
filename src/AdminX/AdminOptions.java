package AdminX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import IngresoLibreria.labeldetails;
import Libreria.Eleccion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class AdminOptions extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private labeldetails imagen = new labeldetails();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOptions frame = new AdminOptions();
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
	public AdminOptions() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminOptions.class.getResource("/Imagenes/admin.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Subir");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubirPDF subir = new SubirPDF();
				subir.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(69, 183, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leer");
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleccion e1 = new Eleccion("Samuel");
				e1.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(264, 183, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel ImagenDice = new JLabel();
		ImagenDice.setBounds(128, 11, 177, 161);
		ImagenDice.setIcon(imagen.resizableLabel(Toolkit.getDefaultToolkit().getImage(AdminOptions.class.getResource("/Imagenes/admin.png")), ImagenDice));
		contentPane.add(ImagenDice);
		
	}
}
