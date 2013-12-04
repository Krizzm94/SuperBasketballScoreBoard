package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Window;

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

import Estilos.FormaBotonCircular;
import Estilos.hiloTransportador;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Informacion extends JFrame{
	JLabel txtInfo;
	 hiloTransportador ht;
	 private VentanaPrincipal ventanaPrincipal;
	 private JFrame frame;
	/**
	 * Launch the application.
	 */
	
	
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
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
		txtInfo = new JLabel();
    	
		txtInfo.setFont(new Font("Varsity Playbook", Font.PLAIN, 18));
		txtInfo.setForeground(Color.WHITE);
		txtInfo.setBackground(Color.BLACK);
		txtInfo.setBounds(1, 1000, 500, 700);
		
		txtInfo.setText("<html>Si eres fan del baloncesto y te gusta<br>nseguir los partidos al detalle y llevando<br> tu propio marcador, esta es tu aplicaci\u00F3n. <br>El marcador m\u00E1s sencillo para poder llevar<br> el tiempo, la anotaci\u00F3n, faltas y dem\u00E1s <br>elementos b\u00E1sicos cuando no te quieres<br> perder nada de la acci\u00F3n en la pista. <br>Sin complejas estad\u00EDsticas ni miles de botones<br> que te quitan tiempo de lo verdaderamente<br> interesante, el juego. <br>Puedes llevar el control de multitud de<br> aspectos del partido: <br>- Tiempo total por periodo. <br>- Anotaci\u00F3n de cada uno de los equipos. <br>- Control de faltas realizadas, a nivel<br> individual <br>                   INTRUCCIONES <br>. presione la opcion NUEVO TORNEO para crear un<br>nuevo evento.<br>.Ingrese los datos del torneo:\"nombre, numero de quipos ,etc\" <br>.luego agregue los equipos participantes en la opcion equipo.<br>.Ingrese los datos requeridos, es necesario tener encuenta el <br>nombre de el toneo ya que a este sera el q se le asigne este equipo<br>.Ahora ingrese a la opcion jugador y creelo ingresando los datos <br>.En la opcion partido puedes crar los partidos que desees <br> en el torneo que prefieras.<br>En la opcion juagador ingresa tus jugadores sin mayor dificulad,<br> solo selecciona el torneo donde se encuenatra el equipo, <br> tambien selecciona el equipo al que el jugador pertenecera,<br>  ten en cuenta el numero de juagadores.<br> Y asi ya puedes realizar el torneo que haz estado soñando el <br> programa te organizara los encuentros y en la opcion Torneo <br> visualizaras los datos de tu torneo e ingresaras para iniciar el encuentro <html> ");
		 ht=new hiloTransportador(this);
		  ht.start();
		txtInfo.setHorizontalAlignment( SwingConstants.CENTER );
		frame.getContentPane().setLayout(null);
	   
	
		
		JButton btnVolver = new FormaBotonCircular("");
		btnVolver.setToolTipText("Devuelve al menu anterior");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);
				
			}
		});
		ImageIcon icnReg = new ImageIcon("imagenes/backF.png");
		btnVolver.setIcon(icnReg);
		btnVolver.setBounds(10, 11, 50, 50);
		frame.getContentPane().add(btnVolver);
	   JLabel informacion = new JLabel("");
	   informacion.setBounds(1, 0, 579, 80);
	   informacion.setIcon(new ImageIcon("imagenes/fondoLInfo.png"));
	   frame.getContentPane().add(informacion);
		
	   frame.getContentPane().add(txtInfo);
	   frame.getContentPane().setLayout(null);
	   frame.getContentPane().add(txtInfo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 580, 350);
		frame.getContentPane().add(lblNewLabel);
		
		

	}

	public JLabel getTxtInfo() {
		return txtInfo;
	}
	public Informacion() throws HeadlessException {
		super();
	}
	
	
}
