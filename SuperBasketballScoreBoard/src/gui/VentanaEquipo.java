package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;

import Estilos.FormaBoton;


public class VentanaEquipo {

	private JFrame VentanaEquipo;
	private VentanaIngresarEquipo nuevoEquipo;
	private VentanaPrincipal ventanaPrincipal;
	

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
		VentanaEquipo.setBounds(100, 100, 580, 350);
		VentanaEquipo.setResizable(false);
		VentanaEquipo.setLocationRelativeTo(null);
		VentanaEquipo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VentanaEquipo.setUndecorated(true);
		VentanaEquipo.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		VentanaEquipo.getContentPane().setLayout(null);
		
		
		
		JButton btnNuevo = new FormaBoton( "Boton" );
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnNuevo.setHorizontalAlignment(SwingConstants.LEADING);
		btnNuevo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		btnNuevo.setText("NUEVO");
		btnNuevo.setBackground(new Color(255, 250, 250));
		btnNuevo.setForeground(Color.DARK_GRAY);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo.setVisible(false);
				nuevoEquipo=new VentanaIngresarEquipo();
				nuevoEquipo.setVisible(true);
				
				
				}
		});
//		ImageIcon icnNuevo = new ImageIcon("imagenes/nuevo.png");
//		btnNuevo.setIcon(icnNuevo);
		btnNuevo.setBounds(10, 71, 273, 127);
		VentanaEquipo.getContentPane().add(btnNuevo);
		
		
		
		JButton btnBorrar = new FormaBoton( "Boton" );
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setText("BORRAR");	
		btnBorrar.setHorizontalAlignment(SwingConstants.LEADING);
		btnBorrar.setForeground(Color.DARK_GRAY);
		btnBorrar.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
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
		btnAtras.setBackground(Color.WHITE);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaPrincipal = new VentanaPrincipal();
				VentanaEquipo.setVisible(false);
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);
			}
		});
		btnAtras.setHorizontalAlignment(SwingConstants.LEADING);
		btnAtras.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		btnAtras.setText("ATRAS");
		btnAtras.setForeground(Color.DARK_GRAY);
		btnAtras.setBounds(10, 209, 273, 127);
		VentanaEquipo.getContentPane().add(btnAtras);
//		ImageIcon icnAtras = new ImageIcon("imagenes/atras.png");
//		btnAtras.setIcon(icnEquipo);
		
		JButton btnListar = new FormaBoton( "Boton" );
		btnListar.setBackground(Color.WHITE);
		btnListar.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		btnListar.setText("LISTAR");
		btnListar.setHorizontalAlignment(SwingConstants.LEADING);
		btnListar.setForeground(Color.DARK_GRAY);;
		btnListar.setBounds(295, 209, 273, 127);
		VentanaEquipo.getContentPane().add(btnListar);
		
		JLabel lblEquipo = new JLabel("EQUIPO");
		lblEquipo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 30));
		lblEquipo.setBackground(new Color(255, 245, 238));
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setBounds(201, 11, 166, 50);
		VentanaEquipo.getContentPane().add(lblEquipo);
		//ImageIcon icnInfo = new ImageIcon("ima57, 209, 135.png");
		//btnListar.setIcon(icnEquipo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 574, 347);
		VentanaEquipo.getContentPane().add(lblNewLabel);
		
	}

	public JFrame getVentanaPrincipal() {
		return VentanaEquipo;
	}

	public void setVentanaPrincipal(JFrame ventanaPrincipal) {
		VentanaEquipo = ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public JFrame getVentanaEquipo() {
		return VentanaEquipo;
	}

	public void setVentanaEquipo(JFrame ventanaEquipo) {
		VentanaEquipo = ventanaEquipo;
	}
	
	
	
}
