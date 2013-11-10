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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jugador window = new jugador();
					window.jugador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * constructor
	 */
	public jugador() {
		inicializar();
	}

	/**
	 * Iicializamos los componentes
	 */
	private void inicializar() {
		jugador = new JFrame();
		jugador.getContentPane().setBackground(new Color(0, 0, 0));
		jugador.setBounds(100, 100, 580, 376);
		jugador.setResizable(false);
		jugador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jugador.getContentPane().setLayout(null);
		
		JButton btnTorneo = new JButton();
		btnTorneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Oprimio el Boton de torneo");		
				}
		});
		ImageIcon icnTorneo = new ImageIcon("torneo.png");
		btnTorneo.setIcon(icnTorneo);
		btnTorneo.setBounds(10, 71, 273, 127);
		jugador.getContentPane().add(btnTorneo);
		
		
		JButton btnJugador = new JButton();
		btnJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton Jugador");
			}
		});
		ImageIcon icnJugador = new ImageIcon("jugador.png");
		btnJugador.setIcon(icnJugador);
		btnJugador.setBounds(10, 209, 273, 127);
		jugador.getContentPane().add(btnJugador);
		
		JButton btnInfo = new JButton();
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton de Informacion");
			}
		});
		ImageIcon icnInfo = new ImageIcon("info.png");
		btnInfo.setIcon(icnInfo);
		btnInfo.setBounds(295, 209, 273, 127);
		jugador.getContentPane().add(btnInfo);
		
		JButton btnEquipo = new JButton();
		btnEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton Equipo");
			}
		});
		ImageIcon icnEquipo = new ImageIcon("equipo.png");
		btnEquipo.setIcon(icnEquipo);
		btnEquipo.setBounds(295, 71, 273, 127);
		jugador.getContentPane().add(btnEquipo);
		
		JLabel lblSuperBasketballScoreboard = new JLabel("Super BasketBall ScoreBoard");
		lblSuperBasketballScoreboard.setFont(new Font("LMS I Love This Game", Font.PLAIN, 17));
		lblSuperBasketballScoreboard.setForeground(Color.WHITE);
		lblSuperBasketballScoreboard.setBounds(77, 29, 460, 19);
		jugador.getContentPane().add(lblSuperBasketballScoreboard);
		
	}
}
