package gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import java.awt.Color;

import logica.Torneo;


public class VentanaJugador {

	private JFrame frame;
	private JTextField txtNumero;
	private VentanaPrincipal ventanaPrincipal;
	private JComboBox cmbEquipo;
	private JComboBox cmbTorneo;

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
		frame.setBounds(100, 100, 580, 350);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.getContentPane().setLayout(null);

		this.cmbTorneo = new JComboBox();
		cmbTorneo.setBounds(401, 106, 127, 27);
		frame.getContentPane().add(cmbTorneo);

		this.cmbEquipo = new JComboBox();
		cmbEquipo.setBounds(401, 160, 127, 27);
		frame.getContentPane().add(cmbEquipo);

		JLabel lblJugador = new JLabel("JUGADOR");
		lblJugador.setForeground(new Color(255, 255, 255));
		lblJugador.setFont(new Font("LMS I Love This Game", Font.BOLD, 30));
		lblJugador.setBounds(134, 11, 219, 43);
		frame.getContentPane().add(lblJugador);

		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if((cmbEquipo.getSelectedItem())== null || cmbTorneo.getSelectedItem() == null || getTxtNumero().getText().length()==0){				
					JOptionPane.showMessageDialog(null,"Por Favor llene"+"\n"+"todos los campos","Campos Vacios",JOptionPane.WARNING_MESSAGE );
				}else{
					JOptionPane.showMessageDialog(null,"esta bn" );
				}
			}
		}
				);
		btnAgregar.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		btnAgregar.setBounds(0, 289, 290, 58);
		frame.getContentPane().add(btnAgregar);

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

		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				char caracter = e.getKeyChar();
				if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
				{
					e.consume();
					JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
				}
				if (txtNumero.getText().length() >= 2) {
				e.setKeyChar('\0');
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		txtNumero.setBounds(401, 214, 127, 27);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

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

	public JComboBox getCmbEquipo() {
		return cmbEquipo;
	}

	public void setCmbEquipo(JComboBox cmbEquipo) {
		this.cmbEquipo = cmbEquipo;
	}

	public JComboBox getCmbTorneo() {
		return cmbTorneo;
	}

	public void setCmbTorneo(JComboBox cmbTorneo) {
		this.cmbTorneo = cmbTorneo;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}


}
