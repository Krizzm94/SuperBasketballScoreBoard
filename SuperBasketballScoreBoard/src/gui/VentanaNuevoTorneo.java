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
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import logica.Torneo;

/**
 * @author Wolfran Pinzon
 * 
 */
public class VentanaNuevoTorneo {

		private JFrame frame;
		private JTextField JTextNombreTorneo;
		private VentanaPrincipal ventanaPrincipal;
		private VentanaTorneo ventanaTorneo;
		private JComboBox cmbEquipo;
		private JButton crear;
		private VentanaJugador ventanaJugador;

		/**
		 * Create the application.
		 */
		public VentanaNuevoTorneo(VentanaPrincipal ventanaPrincipal) {
			this.ventanaPrincipal=ventanaPrincipal;
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
			ventanaJugador = new VentanaJugador();



			JLabel lblJugador = new JLabel("NUEVO TORNEO");
			lblJugador.setForeground(new Color(255, 255, 255));
			lblJugador.setFont(new Font("LMS I Love This Game", Font.BOLD, 32));
			lblJugador.setBounds(81, 11, 383, 90);
			frame.getContentPane().add(lblJugador);
			crear = new JButton("CREAR");
			
			crear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(JTextNombreTorneo.getText().length()!=0){
						if(ventanaPrincipal.getGestion().validarNombreTorneo(JTextNombreTorneo.getText())==false){
							String nombreTorneo=JTextNombreTorneo.getText();
							int numEquipos=Integer.parseInt(cmbEquipo.getSelectedItem().toString());
							Torneo torneo=new Torneo(nombreTorneo, numEquipos, null, null);
							ventanaPrincipal.getGestion().agregarTorneo(torneo);
							ventanaPrincipal.getGestion().agregarTorneoSql(torneo);
//							getVentanaJugador().getCmbTorneo().addItem(nombreTorneo);
							JOptionPane.showMessageDialog(null, "Torneo creado exitosamente!",JTextNombreTorneo.getText(),JOptionPane.INFORMATION_MESSAGE);
							JTextNombreTorneo.setText("");
						}
						else{
							JOptionPane.showMessageDialog(null,JTextNombreTorneo.getText()+" El torneo ya existe");
						}
					}else{
						JOptionPane.showMessageDialog(null,"Campos vacios!!!","ERROR",JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			crear.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
			crear.setBounds(92, 265, 372, 58);
			frame.getContentPane().add(crear);

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
					ventanaPrincipal.getVentanaTorneo().cargarTorneos();
					ventanaPrincipal.getVentanaTorneo().getFrame().setVisible(true);

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
		 * @return the frame
		 */
		public JFrame getFrame() {
			return frame;
		}

		/**
		 * @param frame the frame to set
		 */
		public void setFrame(JFrame frame) {
			this.frame = frame;
		}

		/**
		 * @return the jTextNombreTorneo
		 */
		public JTextField getJTextNombreTorneo() {
			return JTextNombreTorneo;
		}

		/**
		 * @param jTextNombreTorneo the jTextNombreTorneo to set
		 */
		public void setJTextNombreTorneo(JTextField jTextNombreTorneo) {
			JTextNombreTorneo = jTextNombreTorneo;
		}

		/**
		 * @return the cmbEquipo
		 */
		public JComboBox getCmbEquipo() {
			return cmbEquipo;
		}

		/**
		 * @param cmbEquipo the cmbEquipo to set
		 */
		public void setCmbEquipo(JComboBox cmbEquipo) {
			this.cmbEquipo = cmbEquipo;
		}
		
		

	/**
		 * @return the crear
		 */
		public JButton getCrear() {
			return crear;
		}

		/**
		 * @param crear the crear to set
		 */
		public void setCrear(JButton crear) {
			this.crear = crear;
		}

		
	public VentanaJugador getVentanaJugador() {
			return ventanaJugador;
		}

		public void setVentanaJugador(VentanaJugador ventanaJugador) {
			this.ventanaJugador = ventanaJugador;
		}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNuevoTorneo window = new VentanaNuevoTorneo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
