/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

/**
 * @author Wolfran Pinzon
 * 
 */
public class VentanaNuevoTorneo {

		private JFrame frame;
		private JTextField JTextNombreTorneo;
		private VentanaPrincipal ventanaPrincipal;
		private JComboBox cmbEquipo;

		/**
		 * Create the application.
		 */
		public VentanaNuevoTorneo() {
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



			JLabel lblJugador = new JLabel("NUEVO TORNEO");
			lblJugador.setForeground(new Color(255, 255, 255));
			lblJugador.setFont(new Font("LMS I Love This Game", Font.BOLD, 32));
			lblJugador.setBounds(81, 11, 383, 90);
			frame.getContentPane().add(lblJugador);

			JButton btnNewButton = new JButton("CREAR");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnNewButton.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
			btnNewButton.setBounds(92, 265, 372, 58);
			frame.getContentPane().add(btnNewButton);

			JLabel lblSeleccioneElTorneo = new JLabel("Nombre");
			lblSeleccioneElTorneo.setForeground(new Color(255, 255, 255));
			lblSeleccioneElTorneo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 23));
			lblSeleccioneElTorneo.setBounds(44, 126, 192, 39);
			frame.getContentPane().add(lblSeleccioneElTorneo);

			JLabel lblSeleccioneElEquipo = new JLabel("Numero Equipos");
			lblSeleccioneElEquipo.setForeground(new Color(255, 255, 255));
			lblSeleccioneElEquipo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 23));
			lblSeleccioneElEquipo.setBounds(42, 204, 318, 45);
			frame.getContentPane().add(lblSeleccioneElEquipo);

			this.cmbEquipo = new JComboBox();
			cmbEquipo.setModel(new DefaultComboBoxModel(new String[] {"4", "6", "8", "10", "12"}));
			cmbEquipo.setMaximumRowCount(5);
			cmbEquipo.setFont(new Font("Lucida Bright", Font.PLAIN, 16));
			cmbEquipo.setBounds(400, 212, 127, 33);
			frame.getContentPane().add(cmbEquipo);

			JTextNombreTorneo = new JTextField();
			JTextNombreTorneo.setBounds(302, 129, 223, 39);
			frame.getContentPane().add(JTextNombreTorneo);
			JTextNombreTorneo.setColumns(10);

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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevoTorneo window = new VentanaNuevoTorneo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
