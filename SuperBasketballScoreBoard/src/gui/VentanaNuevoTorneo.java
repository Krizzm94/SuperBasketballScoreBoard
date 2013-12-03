/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import Estilos.FormaBoton;

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



			JLabel lblJugador = new JLabel("NUEVO TORNEO");
			lblJugador.setForeground(new Color(255, 255, 255));
			lblJugador.setFont(new Font("Varsity Playbook", Font.PLAIN, 60));
			lblJugador.setBounds(110, 11, 383, 90);
			frame.getContentPane().add(lblJugador);
			crear = new FormaBoton("CREAR TORNEO");
			
			crear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(JTextNombreTorneo.getText().length()!=0){
						if(ventanaPrincipal.getGestion().validarNombreTorneo(JTextNombreTorneo.getText())==false){
							String nombreTorneo=JTextNombreTorneo.getText();
							int numEquipos=Integer.parseInt(cmbEquipo.getSelectedItem().toString());
							Torneo torneo=new Torneo(nombreTorneo, numEquipos, null, null);
							ventanaPrincipal.getGestion().agregarTorneo(torneo);
							ventanaPrincipal.getGestion().agregarTorneoSql(torneo);
							final Icon ic1 =  new ImageIcon("imagenes/check.png");
							JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Torneo creado<p>exitosamente.</font></center></html>",nombreTorneo,JOptionPane.PLAIN_MESSAGE,ic1);
							frame.setVisible(false);
							ventanaPrincipal.getVentanaTorneo().cargarTorneos();
							ventanaPrincipal.getVentanaEquipo().cargarTorneos();
							ventanaPrincipal.getVentanaJugador().cargarTorneos();
							ventanaPrincipal.getVentanaTorneo().getFrame().setVisible(true);
						}
						else{
							final Icon ic2  =  new ImageIcon("imagenes/denied.png");
							JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>El torneo ya existe.</font></center></html>","Ojo.",JOptionPane.PLAIN_MESSAGE,ic2);
						}
					}else{
						final Icon ic3  =  new ImageIcon("imagenes/denied.png");
						JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Campos Vacios.</font></center></html>","Error.",JOptionPane.PLAIN_MESSAGE,ic3);
					}
				}
			});
			crear.setFont(new Font("Varsity Playbook", Font.PLAIN, 35));
			crear.setBounds(92, 265, 372, 58);
			frame.getContentPane().add(crear);

			JLabel lblSeleccioneElTorneo = new JLabel("Nombre");
			lblSeleccioneElTorneo.setForeground(new Color(255, 255, 255));
			lblSeleccioneElTorneo.setFont(new Font("Varsity Playbook", Font.PLAIN, 45));
			lblSeleccioneElTorneo.setBounds(44, 126, 192, 39);
			frame.getContentPane().add(lblSeleccioneElTorneo);

			JLabel lblSeleccioneElEquipo = new JLabel("Numero Equipos");
			lblSeleccioneElEquipo.setForeground(new Color(255, 255, 255));
			lblSeleccioneElEquipo.setFont(new Font("Varsity Playbook", Font.PLAIN, 45));
			lblSeleccioneElEquipo.setBounds(42, 204, 318, 45);
			frame.getContentPane().add(lblSeleccioneElEquipo);

			this.cmbEquipo = new JComboBox();
			cmbEquipo.setModel(new DefaultComboBoxModel(new String[] {"4","8","16"}));
			cmbEquipo.setMaximumRowCount(5);
			cmbEquipo.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
			cmbEquipo.setBounds(400, 212, 127, 33);
			frame.getContentPane().add(cmbEquipo);

			JTextNombreTorneo = new JTextField();
			JTextNombreTorneo.setBounds(202, 129, 323, 45);
			JTextNombreTorneo.setColumns(20);
			JTextNombreTorneo.setFont(new Font("Varsity Playbook", Font.PLAIN, 40));
			frame.getContentPane().add(JTextNombreTorneo);
			

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

			JButton btnHome = new JButton();
			btnHome.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					final Icon ic2 =  new ImageIcon("imagenes/menu.png");
					int salir = JOptionPane.showConfirmDialog(null,"<html><center><font SIZE='5' face='Verdana' color=black>¿Seguro que desea<P>ir al menu principal?</font></center></html>"
															, "Ir al menu principal.", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,ic2);
					if (salir == JOptionPane.YES_OPTION)
					{
						getFrame().setVisible(false);
						ventanaPrincipal.getVentanaPrincipal().setVisible(true);
					}



				}
			});
			ImageIcon icnHome = new ImageIcon("imagenes/home.png");
			btnHome.setIcon(icnHome);
			btnHome.setBounds(514, 17, 50, 50);
			frame.getContentPane().add(btnHome);
			
			
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
