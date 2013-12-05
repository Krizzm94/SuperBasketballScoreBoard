package gui;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import Estilos.FormaBoton;
import Estilos.FormaBotonCircular;

import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import logica.Equipo;
import logica.Torneo;
import logica.Jugador;
/**

* Esta clase permite visualizar la ventana jugador e insertar los datos de un jugador en un torneo y  equipo especifico

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */

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
					VentanaJugador window = new VentanaJugador(null);
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
	public VentanaJugador(VentanaPrincipal ventanaPrincipal) {
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

		this.cmbTorneo = new JComboBox();
		cmbTorneo.setBounds(401, 106, 127, 27);
		cmbTorneo.setFont(new Font("Varsity Playbook", Font.PLAIN, 20));
		frame.getContentPane().add(cmbTorneo);
		cmbTorneo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(cmbTorneo.getSelectedItem()!=null) {
					String torneo=cmbTorneo.getSelectedItem().toString();
					cargarEquipos(torneo);
				}
			}
		});

		this.cmbEquipo = new JComboBox();
		cmbEquipo.setBounds(401, 160, 127, 27);
		cmbEquipo.setFont(new Font("Varsity Playbook", Font.PLAIN, 20));
		frame.getContentPane().add(cmbEquipo);

		JLabel lblJugador = new JLabel("JUGADOR");
		lblJugador.setForeground(new Color(255, 255, 255));
		lblJugador.setFont(new Font("Varsity Playbook", Font.PLAIN, 60));
		lblJugador.setBounds(165, 13, 219, 70);
		frame.getContentPane().add(lblJugador);

		JButton btnAgregar = new FormaBoton( "AGREGAR" );;
		btnAgregar.addActionListener(new ActionListener() {
			
			/**
			 * funcion del boton para agregar un jugador 
			 */

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if((cmbEquipo.getSelectedItem())== null || cmbTorneo.getSelectedItem() == null || getTxtNumero().getText().length()==0){				
					final Icon ic3  =  new ImageIcon("imagenes/denied.png");
					JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Complete el Formulario.</font></center></html>","Ojo.",JOptionPane.PLAIN_MESSAGE,ic3);
				}
				else
				{
					String nombreTorneo = cmbTorneo.getSelectedItem().toString();
					String nombreEquipo = cmbEquipo.getSelectedItem().toString();
					String numero = txtNumero.getText();
					Jugador jugador = new Jugador(Integer.parseInt(numero));
					Equipo equi = ventanaPrincipal.getGestion().buscarTorneo(nombreTorneo).buscarEquipo(nombreEquipo);
					Jugador j=equi.buscarJugador(Integer.parseInt(numero));
					System.out.println(equi);
					if(equi.buscarJugador(Integer.parseInt(numero))!= null){
						final Icon ic2  =  new ImageIcon("imagenes/denied.png");
						JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>El Jugador ya existe.</font></center></html>","Error.",JOptionPane.PLAIN_MESSAGE,ic2);
						txtNumero.setText("");
					}
					else{
						equi.agregarJugador(jugador);
						ventanaPrincipal.getGestion().getJugadorDao().insertarJugador(jugador, nombreEquipo, nombreTorneo);
						final Icon ic1 =  new ImageIcon("imagenes/check.png");
						JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Jugador creado<p>exitosamente.</font></center></html>",numero,JOptionPane.PLAIN_MESSAGE,ic1);
						txtNumero.setText("");
						
					}
						
				}
			}
		}

				);
		btnAgregar.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		btnAgregar.setBounds(145, 280, 290, 58);
		frame.getContentPane().add(btnAgregar);

		JLabel lblSeleccioneElTorneo = new JLabel("Seleccione el Torneo");
		lblSeleccioneElTorneo.setForeground(new Color(255, 255, 255));
		lblSeleccioneElTorneo.setFont(new Font("Varsity Playbook", Font.PLAIN, 45));
		lblSeleccioneElTorneo.setBounds(10, 106, 369, 38);
		frame.getContentPane().add(lblSeleccioneElTorneo);

		JLabel lblSeleccioneElEquipo = new JLabel("Seleccione el Equipo");
		lblSeleccioneElEquipo.setForeground(new Color(255, 255, 255));
		lblSeleccioneElEquipo.setFont(new Font("Varsity Playbook", Font.PLAIN, 45));
		lblSeleccioneElEquipo.setBounds(10, 160, 369, 38);
		frame.getContentPane().add(lblSeleccioneElEquipo);

		JLabel lblIngreseElNumero = new JLabel("Ingrese el Numero");
		lblIngreseElNumero.setForeground(new Color(255, 255, 255));
		lblIngreseElNumero.setFont(new Font("Varsity Playbook", Font.PLAIN, 45));
		lblIngreseElNumero.setBounds(10, 214, 369, 38);
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
					final Icon ic1 =  new ImageIcon("imagenes/caution.png");
					JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Ingrese unicamente<p>caracteres numericos.</font></center></html>","No permitido.",JOptionPane.PLAIN_MESSAGE,ic1);
					
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
		txtNumero.setFont(new Font("Varsity Playbook", Font.PLAIN, 20));
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		/**
		 * funcion del boton para retornar a la ventana  principal 
		 */
		JButton btnRegresar = new FormaBotonCircular("");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);

			}
		});
		ImageIcon icnReg = new ImageIcon("imagenes/backF.png");
		btnRegresar.setIcon(icnReg);
		btnRegresar.setBounds(10, 11, 50, 50);
		frame.getContentPane().add(btnRegresar);
		
		/**
		 * Establece el fondo de la ventana 
		 */

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 574, 347);
		frame.getContentPane().add(lblNewLabel);

		cargarTorneos();
		//		cargarEquipos();
	}
	/**
	 * se cargan los torneos exixtentes en el jcombobox torneo   .
	 * 
	 */
	public void cargarTorneos(){
		cmbTorneo.removeAllItems();
		for(int i=0;i<ventanaPrincipal.getGestion().getTorneos().size();i++){
			cmbTorneo.addItem(ventanaPrincipal.getGestion().getTorneos().get(i).getNombre());				
		}
	}
	/**
	 * se cargan los equipos  exixtentes en el jcombobox equipo   .
	 * 
	 */
	public void cargarEquipos(String torneo){
		cmbEquipo.removeAllItems();
		Torneo tor= ventanaPrincipal.getGestion().buscarTorneo(torneo);
		for(int i=0;i<tor.getEquipos().size();i++){
			if(tor.getEquipos().get(i)!=null){
				cmbEquipo.addItem(tor.getEquipos().get(i).getNombre());				

			}
		}
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
