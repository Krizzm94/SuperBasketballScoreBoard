package gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;


public class VentanaJugador {

	private JFrame frame;
	private JTextField textField;
	private VentanaPrincipal ventanaPrincipal;
	private JComboBox cmbEquipo;
	private JComboBox cmbTorneo;
	private JLabel jlbl_Fondo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJugador window = new VentanaJugador();
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
	public VentanaJugador() {
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
		lblJugador.setForeground(new Color(255, 255, 255));
		lblJugador.setFont(new Font("LMS I Love This Game", Font.BOLD, 30));
		lblJugador.setBounds(134, 11, 219, 43);
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
		lblSeleccioneElTorneo.setForeground(new Color(255, 255, 255));
		lblSeleccioneElTorneo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lblSeleccioneElTorneo.setBounds(10, 106, 369, 27);
		frame.getContentPane().add(lblSeleccioneElTorneo);

		JLabel lblSeleccioneElEquipo = new JLabel("Seleccione el Equipo");
		lblSeleccioneElEquipo.setForeground(new Color(255, 255, 255));
		lblSeleccioneElEquipo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lblSeleccioneElEquipo.setBounds(10, 160, 369, 27);
		frame.getContentPane().add(lblSeleccioneElEquipo);

		JLabel lblIngreseElNumero = new JLabel("Ingrese el Numero");
		lblIngreseElNumero.setForeground(new Color(255, 255, 255));
		lblIngreseElNumero.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lblIngreseElNumero.setBounds(10, 214, 369, 27);
		frame.getContentPane().add(lblIngreseElNumero);

		this.cmbTorneo = new JComboBox();
		cmbTorneo.setBounds(401, 106, 127, 27);
		frame.getContentPane().add(cmbTorneo);

		this.cmbEquipo = new JComboBox();
		cmbEquipo.setBounds(401, 160, 127, 27);
		frame.getContentPane().add(cmbEquipo);

		textField = new JTextField();
		textField.setBounds(401, 214, 127, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnRegresar = new JButton();
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);

			}
		});
		ImageIcon icnReg = new ImageIcon("imagenes/back1.png");
		btnRegresar.setIcon(icnReg);
		btnRegresar.setBounds(10, 11, 45, 45);
		frame.getContentPane().add(btnRegresar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 574, 347);
		frame.getContentPane().add(lblNewLabel);


	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


}
