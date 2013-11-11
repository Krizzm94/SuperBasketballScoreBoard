import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class ventanaJugador {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaJugador window = new ventanaJugador();
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
	public ventanaJugador() {
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
		
		JLabel lblJugador = new JLabel("JUGADOR");
		lblJugador.setFont(new Font("LMS I Love This Game", Font.PLAIN, 25));
		lblJugador.setBounds(189, 30, 189, 43);
		frame.getContentPane().add(lblJugador);
		
		JButton btnNewButton = new JButton("AGREGAR");
		btnNewButton.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		btnNewButton.setBounds(0, 289, 290, 58);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		btnEliminar.setBounds(284, 289, 290, 58);
		frame.getContentPane().add(btnEliminar);
		
		JLabel lblSeleccioneElTorneo = new JLabel("Seleccione el Torneo");
		lblSeleccioneElTorneo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 12));
		lblSeleccioneElTorneo.setBounds(68, 106, 235, 27);
		frame.getContentPane().add(lblSeleccioneElTorneo);
		
		JLabel lblSeleccioneElEquipo = new JLabel("Seleccione el Equipo");
		lblSeleccioneElEquipo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 12));
		lblSeleccioneElEquipo.setBounds(68, 160, 235, 27);
		frame.getContentPane().add(lblSeleccioneElEquipo);
		
		JLabel lblIngreseElNumero = new JLabel("Ingrese el Numero");
		lblIngreseElNumero.setFont(new Font("LMS I Love This Game", Font.PLAIN, 12));
		lblIngreseElNumero.setBounds(68, 214, 235, 27);
		frame.getContentPane().add(lblIngreseElNumero);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(359, 106, 127, 20);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(359, 160, 127, 20);
		frame.getContentPane().add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(359, 217, 127, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRegresar = new JButton();
		ImageIcon icnReg = new ImageIcon("back1.png");
		btnRegresar.setIcon(icnReg);
		btnRegresar.setBounds(10, 11, 45, 45);
		frame.getContentPane().add(btnRegresar);
	}
}
