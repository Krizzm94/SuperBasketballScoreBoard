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


public class VentanaPrincipal {

	private JFrame VentanaPrincipal;
	private VentanaJugador ventanaJugador;

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
		});
	}

	/**
	 * constructor
	 */
	public VentanaPrincipal() {
		inicializar();
	}

	/**
	 * Iicializamos los componentes
	 */
	private void inicializar() {
		VentanaPrincipal = new JFrame();
		VentanaPrincipal.getContentPane().setBackground(new Color(0, 0, 0));
		VentanaPrincipal.setBounds(100, 100, 580, 376);
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
		lblSuperBasketballScoreboard.setFont(new Font("LMS I Love This Game", Font.PLAIN, 17));
		lblSuperBasketballScoreboard.setForeground(Color.WHITE);
		lblSuperBasketballScoreboard.setBounds(77, 29, 460, 19);
		VentanaPrincipal.getContentPane().add(lblSuperBasketballScoreboard);
		
	}

	public JFrame getVentanaPrincipal() {
		return VentanaPrincipal;
	}

	public void setVentanaPrincipal(JFrame ventanaPrincipal) {
		VentanaPrincipal = ventanaPrincipal;
	}
	
}
