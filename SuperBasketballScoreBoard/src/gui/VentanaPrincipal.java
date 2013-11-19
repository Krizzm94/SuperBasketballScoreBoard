package gui;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.GestionTorneo;


public class VentanaPrincipal {

	private JFrame VentanaPrincipal;
	private VentanaJugador ventanaJugador;
	private GestionTorneo gestion;

	
	/**
	 * constructor
	 */
	public VentanaPrincipal() {
		gestion=new GestionTorneo();
		inicializar();
	}

	/**
	 * Iicializamos los componentes
	 */
	private void inicializar() {
		VentanaPrincipal = new JFrame();
		VentanaPrincipal.getContentPane().setBackground(new Color(0, 0, 0));
		VentanaPrincipal.setBounds(100, 100, 580, 376);
		VentanaPrincipal.setLocationRelativeTo(null);
		VentanaPrincipal.setResizable(false);
		VentanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VentanaPrincipal.getContentPane().setLayout(null);

		JButton btnTorneo = new JButton();
		btnTorneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Oprimio el Boton de torneo");		
			}
		});
		ImageIcon icnTorneo = new ImageIcon("imagenes/torneo.png");
		btnTorneo.setIcon(icnTorneo);
		btnTorneo.setBounds(10, 71, 273, 127);
		VentanaPrincipal.getContentPane().add(btnTorneo);


		JButton btnJugador = new JButton();
		btnJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaPrincipal.setVisible(false);
				ventanaJugador = new VentanaJugador();
				ventanaJugador.getFrame().setVisible(true);

			}
		});
		ImageIcon icnVentanaPrincipal = new ImageIcon("imagenes/jugador.png");
		btnJugador.setIcon(icnVentanaPrincipal);
		btnJugador.setBounds(10, 209, 273, 127);
		VentanaPrincipal.getContentPane().add(btnJugador);

		JButton btnInfo = new JButton();
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton de Informacion");
			}
		});
		ImageIcon icnInfo = new ImageIcon("imagenes/info.png");
		btnInfo.setIcon(icnInfo);
		btnInfo.setBounds(295, 209, 273, 127);
		VentanaPrincipal.getContentPane().add(btnInfo);

		JButton btnEquipo = new JButton();
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton Equipo");
			}
		});
		ImageIcon icnEquipo = new ImageIcon("imagenes/equipo.png");
		btnEquipo.setIcon(icnEquipo);
		btnEquipo.setBounds(295, 71, 273, 127);
		VentanaPrincipal.getContentPane().add(btnEquipo);

		JLabel lblSuperBasketballScoreboard = new JLabel("Super BasketBall ScoreBoard");
		lblSuperBasketballScoreboard.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lblSuperBasketballScoreboard.setForeground(Color.WHITE);
		lblSuperBasketballScoreboard.setBounds(35, 29, 530, 25);
		VentanaPrincipal.getContentPane().add(lblSuperBasketballScoreboard);

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

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.VentanaPrincipal.setVisible(true);
					System.out.println(window.getGestion().listarTorneos());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
}
