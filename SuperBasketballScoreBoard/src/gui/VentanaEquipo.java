package gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Estilos.FormaBoton;


public class VentanaEquipo {

	private JFrame VentanaEquipo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipo window = new VentanaEquipo();
					window.VentanaEquipo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * constructor
	 */
	public VentanaEquipo() {
		inicializar();
	}

	/**
	 * Iicializamos los componentes
	 */
	private void inicializar() {
		VentanaEquipo = new JFrame();
		VentanaEquipo.getContentPane().setBackground(new Color(0, 0, 0));
		VentanaEquipo.setBounds(100, 100, 580, 376);
		VentanaEquipo.setResizable(false);
		VentanaEquipo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VentanaEquipo.getContentPane().setLayout(null);
		
		
		
		JButton btnNuevo = new FormaBoton( "Boton" );
		btnNuevo.setHorizontalAlignment(SwingConstants.LEADING);
		btnNuevo.setFont(new Font("Snap ITC", Font.PLAIN, 28));
		btnNuevo.setText("NUEVO");
		btnNuevo.setBackground(new Color(255, 250, 250));
		btnNuevo.setForeground(new Color(255, 69, 0));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "aaaa");		
				}
		});
//		ImageIcon icnNuevo = new ImageIcon("imagenes/nuevo.png");
//		btnNuevo.setIcon(icnNuevo);
		btnNuevo.setBounds(10, 71, 273, 127);
		VentanaEquipo.getContentPane().add(btnNuevo);
		
		
		
		JButton btnBorrar = new FormaBoton( "Boton" );
		btnBorrar.setText("BORRAR");
		btnBorrar.setHorizontalAlignment(SwingConstants.LEADING);
		btnBorrar.setForeground(new Color(255, 69, 0));
		btnBorrar.setFont(new Font("Snap ITC", Font.PLAIN, 28));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton Equipo");
			}
		});
//		ImageIcon icnEquipo = new ImageIcon("imagenes/borrar.png");
//		btnBorrar.setIcon(icnEquipo);
		btnBorrar.setBounds(295, 71, 273, 127);
		VentanaEquipo.getContentPane().add(btnBorrar);
		
		JButton btnAtras = new FormaBoton( "Boton" );
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAtras.setHorizontalAlignment(SwingConstants.LEADING);
		btnAtras.setFont(new Font("Snap ITC", Font.PLAIN, 28));
		btnAtras.setText("ATRAS");
		btnAtras.setForeground(new Color(255, 69, 0));
		btnAtras.setBounds(10, 209, 273, 127);
		VentanaEquipo.getContentPane().add(btnAtras);
//		ImageIcon icnAtras = new ImageIcon("imagenes/atras.png");
//		btnAtras.setIcon(icnEquipo);
		
		JButton btnListar = new FormaBoton( "Boton" );
		btnListar.setFont(new Font("Snap ITC", Font.PLAIN, 28));
		btnListar.setText("LISTAR");
		btnListar.setHorizontalAlignment(SwingConstants.LEADING);
		btnListar.setForeground(new Color(255, 69, 0));;
		btnListar.setBounds(295, 209, 273, 127);
		VentanaEquipo.getContentPane().add(btnListar);
		
		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblEquipo.setBackground(new Color(255, 245, 238));
		lblEquipo.setForeground(new Color(255, 69, 0));
		lblEquipo.setBounds(219, 28, 147, 31);
		VentanaEquipo.getContentPane().add(lblEquipo);
		//ImageIcon icnInfo = new ImageIcon("ima57, 209, 135.png");
		//btnListar.setIcon(icnEquipo);
		
	}

	public JFrame getVentanaPrincipal() {
		return VentanaEquipo;
	}

	public void setVentanaPrincipal(JFrame ventanaPrincipal) {
		VentanaEquipo = ventanaPrincipal;
	}
}
