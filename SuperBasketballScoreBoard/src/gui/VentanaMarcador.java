package gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Estilos.FormaBoton;
import Estilos.FormaBotonCircular;
import java.awt.Color;

import logica.Equipo;
import logica.Resultado;
import logica.Torneo;

/**

* Esta clase permite visualizar la ventana marcador,  agregar los putos marcados por cada equipo, cronometrar y manejar 
* variaciones de el tiempo "star, stop y reanudar".
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class VentanaMarcador  implements Runnable {

	private JFrame frame;
	private JLabel lblPuntosT1;
	private JLabel lblPuntosT2;
	private JLabel lblTiempo;
	private JLabel lblNroCuarto;
	private JComboBox jugadoresTeam1;
	private JComboBox jugadoresTeam2;
	private JButton btnPuntoTeam1;
	private JButton btnPuntoTeam_1;
	private JButton btnPuntoTeam2;
	private JButton btnPuntoTeam_2;
	private JButton btnFalta1;
	private JButton btnFalta2;
	private static int nuMin = 10; 
	private static int nuSeg = 0;
	private static int nuHora = 0;
	private static int puntaje1 = 0;
	private static int puntaje2 = 0;
	private int numeroCuarto=1;
	private VentanaPrincipal ventanaPrincipal;
	private boolean pause;
	private boolean stop;
	private Thread thread;
	private long speed;
	private JLabel lblTeam1;
	private JLabel lblTeam2;


	public long getSpeed() {
		return this.speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}



	/**
	 * Create the application.
	 */
	public VentanaMarcador(VentanaPrincipal ventanaP) {
		this.ventanaPrincipal=ventanaP;
		pause = false;
		stop = false;
		thread = new Thread(this);
		speed = 998;
		initialize();
	}
	/**
	 * implementacion de los instantes de tiempo, manejados en el cronometro y  especificacion de la duracion de estos  .
	 */
	public void run() {
		while (!stop) {

			for (; ;){//inicio del for infinito          
				if(nuSeg!=00) {//si no es el ultimo segundo
					nuSeg--;  //decremento el numero de segundos                                  
				}else{
					if(nuMin!=00){//si no es el ultimo minuto
						nuSeg=59;//segundos comienzan en 59
						nuMin--;//decremento el numero de minutos
					}else{
						if (nuHora!=00){
							nuHora--;//decremento el numero de horas
							nuMin=59;//minutos comienzan en 59
							nuSeg=59;//segundos comienzan en 59
						}else{  
							numeroCuarto++;
							if(numeroCuarto<=4) {
								getLblNroCuarto().setText(String.valueOf(numeroCuarto));

								lblTiempo.setText("10:00");
								nuMin = 10; 
								nuSeg = 00;
								nuHora = 0;
								final Icon ic1 =  new ImageIcon("imagenes/cuarto.png");
								JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>¡Fin del "+(numeroCuarto-1)+" cuarto!</font></center></html>","¡Finalizado!",JOptionPane.PLAIN_MESSAGE,ic1);
							}

							if(numeroCuarto==5) {
								stop();
								final Icon ic1 =  new ImageIcon("imagenes/cuarto.png");
								JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>¡Ha finalizado el Partido!</font></center></html>","¡Finalizado!",JOptionPane.PLAIN_MESSAGE,ic1);
								int Pl=Integer.parseInt(getLblPuntosT1().getText());
								int PV=Integer.parseInt(getLblPuntosT2().getText());
								int id=ventanaPrincipal.getIdPartido();
								String ganador="";
								if(Pl>PV) {
									ganador=ventanaPrincipal.getLocal();
								}else {
									ganador=ventanaPrincipal.getVisitante();	
								}
								Resultado resultado=new Resultado(ganador, Pl, PV, id);
								Torneo tor=ventanaPrincipal.getGestion().buscarTorneo(ventanaPrincipal.getTorneo());
								tor.agregarResultado(resultado);
								ventanaPrincipal.getGestion().getResultadoDao().insertarResultado(ventanaPrincipal.getTorneo(),resultado);
								frame.setVisible(false);
								ventanaPrincipal.getVentanaTorneo().getFrame().setVisible(true);

							}
							//----------------------------------------
							//seacabo el tiempo fin hilo  

						}

					}
				}   
				/**
				 * evalua el estado del cronometro.
				 */
				getLblTiempo().setText("0"+nuMin+":"+nuSeg);
				try {
					Thread.sleep(speed);
				} catch (Exception e) {
					e.printStackTrace();
				}

				synchronized (this) {
					while (pause)

						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					if (stop)

						break;
				}
			}
		}

	}
	/**
	 * inicia el tiempo del cronometro.
	 */
	public void start() {
		thread.start();
	}
	/**
	 * Restablece  el tiempo del cronometro.
	 */
	synchronized void stop() {
		stop = true;
		pause = false;
		getLblTiempo().setText("0"+nuMin+":"+"0"+nuSeg);
		notify();

	}

	/**
	 * continua  el tiempo del cronometro desde donde se detuvo .
	 */
	synchronized void resume() {
		pause = false;
		notify();
	}
	/**
	 * Detiene el tiempo del cronometro.
	 */
	synchronized void suspend() {
		pause = true;

	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 350);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.getContentPane().setLayout(null);

		this.lblTiempo = new JLabel("10:00");
		lblTiempo.setFont(new Font("DIGITAL-7", Font.BOLD, 100));
		lblTiempo.setForeground(Color.white);
		lblTiempo.setBounds(165, 11, 290, 89);
		frame.getContentPane().add(lblTiempo);


		this.lblPuntosT1 = new JLabel(Integer.toString(puntaje1));
		lblPuntosT1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosT1.setFont(new Font("DIGITAL-7", Font.BOLD, 70));
		lblPuntosT1.setForeground(Color.white);
		lblPuntosT1.setBounds(110, 125, 130, 89);
		frame.getContentPane().add(lblPuntosT1);

		this.lblPuntosT2 = new JLabel(Integer.toString(puntaje2));
		lblPuntosT2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntosT2.setFont(new Font("DIGITAL-7", Font.BOLD, 70));
		lblPuntosT2.setForeground(Color.white);
		lblPuntosT2.setBounds(342, 125, 130, 89);
		frame.getContentPane().add(lblPuntosT2);

		this.lblNroCuarto = new JLabel("1");
		lblNroCuarto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNroCuarto.setFont(new Font("DIGITAL-7", Font.BOLD, 60));
		lblNroCuarto.setForeground(Color.white);
		lblNroCuarto.setBounds(266, 125, 50, 74);
		frame.getContentPane().add(lblNroCuarto);

		lblTeam1 = new JLabel(ventanaPrincipal.getLocal());
		lblTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam1.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		lblTeam1.setForeground(Color.white);
		lblTeam1.setBounds(52, 217, 187, 34);
		frame.getContentPane().add(lblTeam1);

		JLabel lblCuarto = new JLabel("TIEMPO");
		lblCuarto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCuarto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuarto.setForeground(Color.white);
		lblCuarto.setBounds(266, 200, 60, 20);
		frame.getContentPane().add(lblCuarto);

		lblTeam2 = new JLabel(ventanaPrincipal.getVisitante());
		lblTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeam2.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		lblTeam2.setForeground(Color.white);
		lblTeam2.setBounds(342, 217, 187, 34);
		frame.getContentPane().add(lblTeam2);

		this.jugadoresTeam1 = new JComboBox();
		jugadoresTeam1.setBounds(40, 266, 70, 26);
		frame.getContentPane().add(jugadoresTeam1);

		this.btnFalta1 = new FormaBoton("FALTA");
		btnFalta1.setFont(new Font("Varsity Playbook", Font.PLAIN, 25));
		btnFalta1.setEnabled(false);
		btnFalta1.setBounds(120, 260, 103, 36);
		frame.getContentPane().add(btnFalta1);
		/**
		 * Funcion del boton para ingresar los puntos realizados por el  equipo 1 .
		 */
		this.btnPuntoTeam1 = new FormaBoton("1 PUNTO");
		btnPuntoTeam1.setFont(new Font("Dafunk2", Font.PLAIN, 15));
		btnPuntoTeam1.setEnabled(false);
		btnPuntoTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux = getPuntaje1()+1;
				setPuntaje1(aux);
				getLblPuntosT1().setText(Integer.toString(aux));

			}
		});
		btnPuntoTeam1.setBounds(50, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam1);
		/**
		 * Funcion del boton para eliminar  los puntos realizados por cada equipo.
		 */
		this.btnPuntoTeam_1 = new FormaBoton("-1 PUNTO");
		btnPuntoTeam_1.setFont(new Font("Dafunk2", Font.PLAIN, 13));
		btnPuntoTeam_1.setEnabled(false);
		btnPuntoTeam_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux = getPuntaje1()-1;
				setPuntaje1(aux);
				getLblPuntosT1().setText(Integer.toString(aux));

			}
		});
		btnPuntoTeam_1.setBounds(166, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam_1);

		this.btnFalta2 = new FormaBoton("FALTA");
		btnFalta2.setFont(new Font("Varsity Playbook", Font.PLAIN, 25));
		btnFalta2.setEnabled(false);
		btnFalta2.setBounds(362, 260, 103, 36);
		frame.getContentPane().add(btnFalta2);

		this.jugadoresTeam2 = new JComboBox();
		jugadoresTeam2.setBounds(475, 266, 70, 26);
		frame.getContentPane().add(jugadoresTeam2);
		/**
		 * Funcion del boton para eliminar  los puntos realizados por cada equipo.
		 */
		this.btnPuntoTeam2 = new FormaBoton("-1 PUNTO");
		btnPuntoTeam2.setFont(new Font("Dafunk2", Font.PLAIN, 13));
		btnPuntoTeam2.setEnabled(false);
		btnPuntoTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux = getPuntaje2()-1;
				setPuntaje2(aux);
				getLblPuntosT2().setText(Integer.toString(aux));

			}
		});
		btnPuntoTeam2.setBounds(434, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam2);
		/**
		 * Funcion del boton para ingresar los puntos realizados por el  equipo 1 .
		 */
		this.btnPuntoTeam_2 = new FormaBoton("1 PUNTO");
		btnPuntoTeam_2.setFont(new Font("Dafunk2", Font.PLAIN, 15));
		btnPuntoTeam_2.setEnabled(false);
		btnPuntoTeam_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux = getPuntaje2()+1;
				setPuntaje2(aux);
				getLblPuntosT2().setText(Integer.toString(aux));

			}
		});
		btnPuntoTeam_2.setBounds(318, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam_2);

		
		JButton btnRegresar = new FormaBotonCircular("");
		ImageIcon icnReg = new ImageIcon("imagenes/backF.png");
		btnRegresar.setIcon(icnReg);
		btnRegresar.setBounds(57, 10, 50, 50);
		btnRegresar.addActionListener(new ActionListener() {

			/**
			 * funcion del boton para retornar a la ventana  Torneo 
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Icon ic1  =  new ImageIcon("imagenes/caution.png");
				int opcion=JOptionPane.showConfirmDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>¿Esta seguro que desea<p>Regresar?.<p>¡El sistema no guardara<p>el resultado!</font></center></html>",
						"Regresar.",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,ic1);
				if(opcion==0){
					frame.setVisible(false);
					ventanaPrincipal.getVentanaTorneo().getFrame().setVisible(true);
				}
			}
		});

		frame.getContentPane().add(btnRegresar);

		JButton btnHome = new FormaBotonCircular("");
		btnHome.addActionListener(new ActionListener() {

			/**
			 * funcion del boton para retornar a la ventana  principal 
			 */
			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Icon ic2 =  new ImageIcon("imagenes/menu.png");
				int salir = JOptionPane.showConfirmDialog(null,"<html><center><font SIZE='5' face='Verdana' color=black>¿Seguro que desea <P>salir?<p>¡El sistema no guardara<p> resultados!</font></center></html>"
						, "Ir al menu principal", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,ic2);
				if (salir == JOptionPane.YES_OPTION)
				{
					getFrame().setVisible(false);
					getVentanaPrincipal().getVentanaPrincipal().setVisible(true);
				}
			}
		});
		ImageIcon icnHome = new ImageIcon("imagenes/homeF.png");
		btnHome.setIcon(icnHome);
		btnHome.setBounds(469, 10, 50, 50);
		frame.getContentPane().add(btnHome);

		JButton btnStart = new FormaBotonCircular("");
		ImageIcon icnStart = new ImageIcon("imagenes/startF.png");
		btnStart.setIcon(icnStart);
		
		/**
		 * funcion del boton para iniciar el tiempo de el cronometro
		 */
		btnStart.addActionListener(new ActionListener() {

		
			@Override
			public void actionPerformed(ActionEvent e) {


				start();
				btnPuntoTeam1.setEnabled(true);
				btnPuntoTeam_2.setEnabled(true); 
				btnPuntoTeam2.setEnabled(true);
				btnPuntoTeam_1.setEnabled(true);
				btnFalta1.setEnabled(true);
				btnFalta2.setEnabled(true);
			}				
		});

		btnStart.setBounds(279, 243, 35, 35);
		frame.getContentPane().add(btnStart);
	
		JButton btnStop = new FormaBotonCircular("");
		ImageIcon icnStop = new ImageIcon("imagenes/pausa.png");
		btnStop.setIcon(icnStop);
		/**
		 * funcion del boton para reiniciar  el tiempo de el cronometro
		 */
		btnStop.addActionListener(new ActionListener() {

		
			public void actionPerformed(ActionEvent e) {
				suspend();
				btnPuntoTeam1.setEnabled(false);
				btnPuntoTeam_2.setEnabled(false); 
				btnPuntoTeam2.setEnabled(false);
				btnPuntoTeam_1.setEnabled(false);
				btnFalta1.setEnabled(false);
				btnFalta2.setEnabled(false);

			}
		});
		btnStop.setBounds(279, 275, 35, 35);
		frame.getContentPane().add(btnStop);

	
		JButton btnReanudar = new FormaBotonCircular("");
		ImageIcon icnResume = new ImageIcon("imagenes/reanudar.png");
		btnReanudar.setIcon(icnResume);
		/**
		 * funcion del boton para reanudar el tiempo de el cronometro
		 */
		btnReanudar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				resume();		
				btnPuntoTeam1.setEnabled(true);
				btnPuntoTeam_2.setEnabled(true); 
				btnPuntoTeam2.setEnabled(true);
				btnPuntoTeam_1.setEnabled(true);
				btnFalta1.setEnabled(true);
				btnFalta2.setEnabled(true);
			}
		});
		btnReanudar.setBounds(279, 307, 35, 35);
		frame.getContentPane().add(btnReanudar);
		
		/**
		 * Establece el fondo de la ventana 
		 */

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondoMarcador.png"));
		lblNewLabel.setBounds(0, 0, 574, 347);
		frame.getContentPane().add(lblNewLabel);



	}
	/**
	 * se cargan los jugadores   exixtentes en un equipo  .
	 * 
	 */
	public void cargarJugadores(){
		Equipo equipo=ventanaPrincipal.getGestion().buscarTorneo(ventanaPrincipal.getTorneo()).buscarEquipo(ventanaPrincipal.getLocal());
		Equipo equipo2=ventanaPrincipal.getGestion().buscarTorneo(ventanaPrincipal.getTorneo()).buscarEquipo(ventanaPrincipal.getVisitante());
		for(int i=0;i<equipo.getJugador().length;i++) {
			if(equipo.getJugador()[i]!=null) {
				jugadoresTeam1.addItem(equipo.getJugador()[i].getNumber());
			}
		}

		for(int i=0;i<equipo2.getJugador().length;i++) {
			if(equipo2.getJugador()[i]!=null) {
				jugadoresTeam2.addItem(equipo2.getJugador()[i].getNumber());
			}
		}

	}


	/**
	 * @return the lblTeam1
	 */
	public JLabel getLblTeam1() {
		return lblTeam1;
	}

	/**
	 * @param lblTeam1 the lblTeam1 to set
	 */
	public void setLblTeam1(JLabel lblTeam1) {
		this.lblTeam1 = lblTeam1;
	}

	/**
	 * @return the lblTeam2
	 */
	public JLabel getLblTeam2() {
		return lblTeam2;
	}

	/**
	 * @param lblTeam2 the lblTeam2 to set
	 */
	public void setLblTeam2(JLabel lblTeam2) {
		this.lblTeam2 = lblTeam2;
	}
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	/**
	 * @return the puntaje1
	 */
	public int getPuntaje1() {
		return puntaje1;
	}
	/**
	 * @param Puntaje1 the setPuntaje1 to set
	 */
	public void setPuntaje1(int puntaje1) {
		this.puntaje1 = puntaje1;
	}
	/**
	 * @return the puntaje2
	 */
	public int getPuntaje2() {
		return puntaje2;
	}
	/**
	 * @param puntaje2 the puntaje2 to set
	 */
	public void setPuntaje2(int puntaje2) {
		this.puntaje2 = puntaje2;
	}
	/**
	 * @return the lblPuntosT1
	 */
	public JLabel getLblPuntosT1() {
		return lblPuntosT1;
	}
	/**
	 * @param lblPuntosT1 the lblPuntosT1 to set
	 */
	public void setLblPuntosT1(JLabel lblPuntosT1) {
		this.lblPuntosT1 = lblPuntosT1;
	}
	/**
	 * @return the lblPuntosT2
	 */
	public JLabel getLblPuntosT2() {
		return lblPuntosT2;
	}
	/**
	 * @param lblPuntosT2 the lblPuntosT2 to set
	 */
	public void setLblPuntosT2(JLabel lblPuntosT2) {
		this.lblPuntosT2 = lblPuntosT2;
	}
	/**
	 * @return the lblTiempo
	 */
	public JLabel getLblTiempo() {
		return lblTiempo;
	}
	/**
	 * @param lblTiempo the lblTiempo to set
	 */
	public void setLblTiempo(JLabel lblTiempo) {
		this.lblTiempo = lblTiempo;
	}
	/**
	 * @return the lblNroCuarto
	 */
	public JLabel getLblNroCuarto() {
		return lblNroCuarto;
	}
	/**
	 * @param lblNroCuarto the lblNroCuarto to set
	 */
	public void setLblNroCuarto(JLabel lblNroCuarto) {
		this.lblNroCuarto = lblNroCuarto;
	}
	/**
	 * @return the ventanaPrincipal
	 */
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	/**
	 * @param ventanaPrincipal ventanaPrincipal to set
	 */
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMarcador window = new VentanaMarcador(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
