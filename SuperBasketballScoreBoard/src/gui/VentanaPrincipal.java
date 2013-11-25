package gui;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import logica.GestionTorneo;


public class VentanaPrincipal {

	private JFrame VentanaPrincipal;
	private VentanaJugador ventanaJugador;
	private VentanaTorneo ventanaTorneo;
	private VentanaNuevoTorneo ventanaNuevoTorneo; 
	private VentanaEquipo ventanaEquipo;
	private VentanaIrTorneo ventanaIrTorneo;
	private VentanaMarcador ventanaMarcador;
	private GestionTorneo gestion;
	private String torneo;
	private String local;
	private String visitante;

	/**
	 * constructor
	 */
	public VentanaPrincipal() {
		gestion=new GestionTorneo();
		ventanaTorneo=new VentanaTorneo(this);
		ventanaNuevoTorneo=new VentanaNuevoTorneo(this);
		ventanaIrTorneo=new VentanaIrTorneo(this);
		ventanaMarcador=new VentanaMarcador(this);
		inicializar();
	}

	/**
	 * Iicializamos los componentes
	 */
	private void inicializar() {
		VentanaPrincipal = new JFrame();
		VentanaPrincipal.getContentPane().setBackground(new Color(0, 0, 0));
		VentanaPrincipal.setBounds(100, 100, 580, 350);
		VentanaPrincipal.setLocationRelativeTo(null);
		VentanaPrincipal.setResizable(false);
		VentanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VentanaPrincipal.setUndecorated(true);
		VentanaPrincipal.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		VentanaPrincipal.getContentPane().setLayout(null);

		JButton btnTorneo = new JButton();
		btnTorneo.setToolTipText("Aqui puedes agregar, eliminar y consultar torneos.");
		btnTorneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal.setVisible(false);
				ventanaTorneo.getFrame().setVisible(true);
			}
		});
		ImageIcon icnTorneo = new ImageIcon("imagenes/torneoN.png");
		btnTorneo.setIcon(icnTorneo);
		btnTorneo.setBounds(10, 71, 273, 127);
		VentanaPrincipal.getContentPane().add(btnTorneo);


		JButton btnJugador = new JButton();
		btnJugador.setToolTipText("Aqui puedes agregar y eliminar jugadores si tienes torneos y equipos creados.");
		btnJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal.setVisible(false);
				ventanaJugador = new VentanaJugador();
				ventanaJugador.getFrame().setVisible(true);

			}
		});	
		ImageIcon icnVentanaPrincipal = new ImageIcon("imagenes/jugadorN.png");
		btnJugador.setIcon(icnVentanaPrincipal);
		btnJugador.setBounds(10, 209, 273, 127);
		VentanaPrincipal.getContentPane().add(btnJugador);

		JButton btnInfo = new JButton();
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton de Informacion");
			}
		});
		ImageIcon icnInfo = new ImageIcon("imagenes/infoN.png");
		btnInfo.setIcon(icnInfo);
		btnInfo.setBounds(295, 209, 273, 127);
		VentanaPrincipal.getContentPane().add(btnInfo);

		JButton btnEquipo = new JButton();
		btnEquipo.setToolTipText("Aqui puedes agregar y eliminar equipos con torneos creados previamnte.");
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaEquipo = new VentanaEquipo();
				VentanaPrincipal.setVisible(false);
				ventanaEquipo.getVentanaEquipo().setVisible(true);
			}
		});
		ImageIcon icnEquipo = new ImageIcon("imagenes/equipoN.png");
		btnEquipo.setIcon(icnEquipo);
		btnEquipo.setBounds(295, 71, 273, 127);
		VentanaPrincipal.getContentPane().add(btnEquipo);

		JLabel lblSuperBasketballScoreboard = new JLabel("Super BasketBall\r\nScoreBoard");
		lblSuperBasketballScoreboard.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lblSuperBasketballScoreboard.setForeground(Color.WHITE);
		lblSuperBasketballScoreboard.setBounds(10, 11, 505, 62);
		VentanaPrincipal.getContentPane().add(lblSuperBasketballScoreboard);

		final Icon icono  =  new ImageIcon("imagenes/power.png");
		JButton btnClose = new JButton();
		btnClose.setIcon(new ImageIcon("imagenes/close.png"));
		btnClose.setToolTipText("SALIR");
		btnClose.setBounds(543, 5, 30, 30);
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int salir = JOptionPane.showConfirmDialog(null,
														"<html><center><font SIZE='5' face='Verdana' color=black> ¿SEGURO QUE DESEA <p>SALIR DE LA APP?</font></center></html>",
														"SALIR!!!", 
														JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,icono);
				if (salir == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}


			}
		}
				);
		VentanaPrincipal.getContentPane().add(btnClose);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 574, 347);
		VentanaPrincipal.getContentPane().add(lblNewLabel);
	}

	public JFrame getVentanaPrincipal() {
		return VentanaPrincipal;
	}

	public void setVentanaPrincipal(JFrame ventanaPrincipal) {
		VentanaPrincipal = ventanaPrincipal;
	}

	/**
	 * @return the ventanaJugador
	 */
	public VentanaJugador getVentanaJugador() {
		return ventanaJugador;
	}

	/**
	 * @param ventanaJugador the ventanaJugador to set
	 */
	public void setVentanaJugador(VentanaJugador ventanaJugador) {
		this.ventanaJugador = ventanaJugador;
	}

	/**
	 * @return the gestion
	 */
	public GestionTorneo getGestion() {
		return gestion;
	}

	/**
	 * @param gestion the gestion to set
	 */
	public void setGestion(GestionTorneo gestion) {
		this.gestion = gestion;
	}

	public VentanaEquipo getVentanaEquipo() {
		return ventanaEquipo;
	}

	public void setVentanaEquipo(VentanaEquipo ventanaEquipo) {
		this.ventanaEquipo = ventanaEquipo;
	}

	/**
	 * @return the ventanaTorneo
	 */
	public VentanaTorneo getVentanaTorneo() {
		return ventanaTorneo;
	}

	/**
	 * @param ventanaTorneo the ventanaTorneo to set
	 */
	public void setVentanaTorneo(VentanaTorneo ventanaTorneo) {
		this.ventanaTorneo = ventanaTorneo;
	}

	/**
	 * @return the ventanaMarcador
	 */
	public VentanaMarcador getVentanaMarcador() {
		return ventanaMarcador;
	}

	/**
	 * @param ventanaMarcador the ventanaMarcador to set
	 */
	public void setVentanaMarcador(VentanaMarcador ventanaMarcador) {
		this.ventanaMarcador = ventanaMarcador;
	}

	/**
	 * @return the ventanaNuevoTorneo
	 */
	public VentanaNuevoTorneo getVentanaNuevoTorneo() {
		return ventanaNuevoTorneo;
	}

	/**
	 * @param ventanaNuevoTorneo the ventanaNuevoTorneo to set
	 */
	public void setVentanaNuevoTorneo(VentanaNuevoTorneo ventanaNuevoTorneo) {
		this.ventanaNuevoTorneo = ventanaNuevoTorneo;
	}

	/**
	 * @return the ventanaIrTorneo
	 */
	public VentanaIrTorneo getVentanaIrTorneo() {
		return ventanaIrTorneo;
	}

	/**
	 * @param ventanaIrTorneo the ventanaIrTorneo to set
	 */
	public void setVentanaIrTorneo(VentanaIrTorneo ventanaIrTorneo) {
		this.ventanaIrTorneo = ventanaIrTorneo;
	}

	/**
	 * @return the torneo
	 */
	public String getTorneo() {
		return torneo;
	}

	/**
	 * @param torneo the torneo to set
	 */
	public void setTorneo(String torneo) {
		this.torneo = torneo;
	}

	
	
	/**
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * @return the visitante
	 */
	public String getVisitante() {
		return visitante;
	}

	/**
	 * @param visitante the visitante to set
	 */
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.VentanaPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
				);
	}


}
