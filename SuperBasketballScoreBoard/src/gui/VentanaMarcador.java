package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;


public class VentanaMarcador {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMarcador window = new VentanaMarcador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMarcador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 376);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("00:00");
		label.setFont(new Font("LED BOARD", Font.BOLD, 70));
		label.setBounds(151, 17, 290, 89);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("00");
		label_1.setFont(new Font("LED BOARD", Font.BOLD, 70));
		label_1.setBounds(50, 117, 116, 89);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("00");
		label_2.setFont(new Font("LED BOARD", Font.BOLD, 70));
		label_2.setBounds(429, 117, 116, 89);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("1");
		label_3.setFont(new Font("LED BOARD", Font.BOLD, 60));
		label_3.setBounds(272, 117, 50, 74);
		frame.getContentPane().add(label_3);
		
		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTeam.setBounds(50, 205, 46, 14);
		frame.getContentPane().add(lblTeam);
		
		JLabel lblTiempo = new JLabel("TIEMPO");
		lblTiempo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTiempo.setBounds(270, 186, 60, 20);
		frame.getContentPane().add(lblTiempo);
		
		JLabel label_5 = new JLabel("TEAM:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(429, 205, 46, 14);
		frame.getContentPane().add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(50, 246, 103, 36);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("FALTA");
		btnNewButton.setBounds(166, 246, 103, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnPunto = new JButton("1 PUNTO");
		btnPunto.setBounds(50, 300, 103, 36);
		frame.getContentPane().add(btnPunto);
		
		JButton btnPunto_1 = new JButton("-1 PUNTO");
		btnPunto_1.setBounds(166, 300, 103, 36);
		frame.getContentPane().add(btnPunto_1);
		
		JButton btnFalta = new JButton("FALTA");
		btnFalta.setBounds(326, 246, 103, 36);
		frame.getContentPane().add(btnFalta);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(442, 246, 103, 36);
		frame.getContentPane().add(comboBox_1);
		
		JButton button = new JButton("-1 PUNTO");
		button.setBounds(442, 300, 103, 36);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("1 PUNTO");
		button_1.setBounds(326, 300, 103, 36);
		frame.getContentPane().add(button_1);
		
		JButton btnRegresar = new JButton();
		ImageIcon icnReg = new ImageIcon("imagenes/back1.png");
		btnRegresar.setIcon(icnReg);
		btnRegresar.setBounds(10, 11, 50, 50);
		frame.getContentPane().add(btnRegresar);
		
		JButton btnHome = new JButton();
		ImageIcon icnHome = new ImageIcon("imagenes/home.png");
		btnHome.setIcon(icnHome);
		btnHome.setBounds(514, 17, 50, 50);
		frame.getContentPane().add(btnHome);
	}
}
