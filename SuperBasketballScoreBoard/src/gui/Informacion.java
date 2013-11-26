package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;

import Estilos.hiloTransportador;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Informacion  extends JFrame{
	JLabel lblInformacion;
	JLabel txtInfo;
	 hiloTransportador ht;
	 private VentanaPrincipal ventanaPrincipal;
	 private JFrame frame;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Informacion(VentanaPrincipal v) {
		frame=new JFrame();
		this.ventanaPrincipal=v;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setBounds(100, 100, 580, 350);
		frame.getContentPane().setLayout(null);
	    lblInformacion = new JLabel("INFORMACION");
	    lblInformacion.setBackground(new Color(153, 102, 51));
		lblInformacion.setBounds(147, 27, 267, 28);
		lblInformacion.setFont(new Font("LMS I Love This Game", Font.PLAIN, 27));
		txtInfo = new JLabel();
		txtInfo.setBounds(1, -128, 433, 350);
		txtInfo.setText("<html>Si eres fan del baloncesto y te gusta<br>nseguir los partidos al detalle y llevando<br> tu propio marcador, esta es tu aplicaci\u00F3n. <br>El marcador m\u00E1s sencillo para poder llevar<br> el tiempo, la anotaci\u00F3n, faltas y dem\u00E1s <br>elementos b\u00E1sicos cuando no te quieres<br> perder nada de la acci\u00F3n en la pista. <br>Sin complejas estad\u00EDsticas ni miles de botones<br> que te quitan tiempo de lo verdaderamente<br> interesante, el juego. <br>Puedes llevar el control de multitud de<br> aspectos del partido: <br>- Tiempo total por periodo. <br>- Anotaci\u00F3n de cada uno de los equipos. <br>- Control de faltas realizadas, a nivel<br> individual <br>                   INTRUCCIONES <br>. presione la opcion NUEVO TORNEO para crear un<br>nuevo evento.<br>.Ingrese los datos del torneo:\"nombre, numero de quipos ,etc\" <br>.luego agregue los equipos participantes en la opcion equipo.<br>.Ingrese los datos requeridos, es necesario tener encuenta el <br>nombre de el toneo ya que a este sera el q se le asigne este equipo<br>.Ahora ingrese a la opcion jugador y creelo ingresando los datos <br>.En la opcion partido <html> ");
		txtInfo.setHorizontalAlignment( SwingConstants.CENTER );
		frame.getContentPane().setLayout(null);
		 ht=new hiloTransportador(this);
		  ht.start();
		  frame. getContentPane().add(txtInfo);
		  frame.getContentPane().add(lblInformacion);
		  frame.getContentPane().setLayout(null);
		  frame.getContentPane().add(txtInfo);
		
		JScrollPane jScrollPane = new JScrollPane(txtInfo);
		jScrollPane.setBounds(66, 82, 452, 184);
		frame.getContentPane().add(jScrollPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondoInfo.png"));
		lblNewLabel.setBounds(0, 0, 580, 350);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);
				
			}
		});
		btnVolver.setBounds(226, 294, 89, 23);
		frame.getContentPane().add(btnVolver);

	}

	public JLabel getTxtInfo() {
		return txtInfo;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
	
}
