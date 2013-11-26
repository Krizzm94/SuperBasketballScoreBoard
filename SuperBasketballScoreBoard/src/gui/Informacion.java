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
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;

import Estilos.hiloTransportador;
import java.awt.Color;

public class Informacion extends JFrame {
	JLabel lblInformacion;
	JLabel txtInfo;
	 hiloTransportador ht;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Informacion frame = new Informacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Informacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setBounds(100, 100, 580, 350);
		getContentPane().setLayout(null);
		
	    lblInformacion = new JLabel("INFORMACION");
	    lblInformacion.setBackground(new Color(153, 102, 51));
		lblInformacion.setBounds(147, 27, 267, 28);
		lblInformacion.setFont(new Font("LMS I Love This Game", Font.PLAIN, 27));
		getContentPane().setLayout(new FlowLayout());
		txtInfo = new JLabel();
		txtInfo.setBounds(52, -129, 457, 238);
		txtInfo.setText("<html>Si eres fan del baloncesto y te gusta<br>nseguir los partidos al detalle y llevando<br> tu propio marcador, esta es tu aplicaci\u00F3n. <br>El marcador m\u00E1s sencillo para poder llevar<br> el tiempo, la anotaci\u00F3n, faltas y dem\u00E1s <br>elementos b\u00E1sicos cuando no te quieres<br> perder nada de la acci\u00F3n en la pista. <br>Sin complejas estad\u00EDsticas ni miles de botones<br> que te quitan tiempo de lo verdaderamente<br> interesante, el juego. <br>Puedes llevar el control de multitud de<br> aspectos del partido: <br>- Tiempo total por periodo. <br>- Anotaci\u00F3n de cada uno de los equipos. <br>- Control de faltas realizadas, a nivel<br> individual <br>                   INTRUCCIONES <br>. presione la opcion NUEVO TORNEO para crear un<br>nuevo evento.<br>.Ingrese los datos del torneo:\"nombre, numero de quipos ,etc\" <br>.luego agregue los equipos participantes en la opcion equipo.<br>.Ingrese los datos requeridos, es necesario tener encuenta el <br>nombre de el toneo ya que a este sera el q se le asigne este equipo<br>.Ahora ingrese a la opcion jugador y creelo ingresando los datos <br>.En la opcion partido <html> ");
		txtInfo.setHorizontalAlignment( SwingConstants.CENTER );
		getContentPane().setLayout(null);
		 ht=new hiloTransportador(this);
		  ht.start();
		  getContentPane().add(txtInfo);
	  	getContentPane().add(lblInformacion);
		getContentPane().add(txtInfo);
		
		JScrollPane jScrollPane = new JScrollPane(txtInfo);
		jScrollPane.setBounds(66, 82, 452, 184);
		getContentPane().add(jScrollPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 580, 350);
		getContentPane().add(lblNewLabel);

	}

	public JLabel getTxtInfo() {
		return txtInfo;
	}
	
}
