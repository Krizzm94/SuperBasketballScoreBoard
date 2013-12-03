package gui;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Estilos.FormaBoton;
import Estilos.FormaBotonCircular;
import java.awt.Color;

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
	private VentanaPrincipal ventanaPrincipal;
	private boolean pause;
	private boolean stop;
	private Thread thread;
	private long speed;


	public long getSpeed() {
		return this.speed;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}



	/**
	 * Create the application.
	 */
	public VentanaMarcador(VentanaPrincipal ventanaPrincipal) {
		pause = false;
		stop = false;
		thread = new Thread(this);
		speed = 998;
		this.ventanaPrincipal=ventanaPrincipal;
		initialize();
	}

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
							getLblNroCuarto().setText("2");
							lblTiempo.setText("10:00");
						
							//----------------------------------------
							break;//seacabo el tiempo fin hilo  

						}

					}
				}   
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

	public void start() {
		thread.start();
	}

	synchronized void stop() {
		stop = true;
		pause = false;
		getLblTiempo().setText("0"+nuMin+":"+"0"+nuSeg);
		notify();

	}


	synchronized void resume() {
		pause = false;
		notify();
	}
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
		lblTiempo.setBounds(150, 11, 290, 89);
		frame.getContentPane().add(lblTiempo);


		this.lblPuntosT1 = new JLabel(Integer.toString(puntaje1));
		lblPuntosT1.setFont(new Font("DIGITAL-7", Font.BOLD, 70));
		lblPuntosT1.setForeground(Color.white);
		lblPuntosT1.setBounds(21, 142, 116, 70);
		frame.getContentPane().add(lblPuntosT1);

		this.lblPuntosT2 = new JLabel(Integer.toString(puntaje2));
		lblPuntosT2.setFont(new Font("DIGITAL-7", Font.BOLD, 70));
		lblPuntosT2.setForeground(Color.white);
		lblPuntosT2.setBounds(448, 142, 116, 89);
		frame.getContentPane().add(lblPuntosT2);

		this.lblNroCuarto = new JLabel("1");
		lblNroCuarto.setFont(new Font("DIGITAL-7", Font.BOLD, 60));
		lblNroCuarto.setForeground(Color.white);
		lblNroCuarto.setBounds(266, 125, 50, 74);
		frame.getContentPane().add(lblNroCuarto);

		JLabel lblTeam = new JLabel(ventanaPrincipal.getLocal());
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTeam.setForeground(Color.white);
		lblTeam.setBounds(50, 217, 58, 14);
		frame.getContentPane().add(lblTeam);

		JLabel lblCuarto = new JLabel("TIEMPO");
		lblCuarto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuarto.setForeground(Color.white);
		lblCuarto.setBounds(266, 200, 60, 20);
		frame.getContentPane().add(lblCuarto);

		JLabel label_5 = new JLabel(ventanaPrincipal.getVisitante());
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setForeground(Color.white);
		label_5.setBounds(489, 217, 52, 14);
		frame.getContentPane().add(label_5);

		this.jugadoresTeam1 = new JComboBox();
		jugadoresTeam1.setBounds(50, 246, 103, 36);
		frame.getContentPane().add(jugadoresTeam1);

		this.btnFalta1 = new FormaBoton("FALTA");
		btnFalta1.setFont(new Font("Dafunk2", Font.PLAIN, 17));
		btnFalta1.setEnabled(false);
		btnFalta1.setBounds(166, 246, 103, 36);
		frame.getContentPane().add(btnFalta1);

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
		btnFalta2.setFont(new Font("Dafunk2",Font.PLAIN, 17));
		btnFalta2.setEnabled(false);
		btnFalta2.setBounds(326, 246, 103, 36);
		frame.getContentPane().add(btnFalta2);

		this.jugadoresTeam2 = new JComboBox();
		jugadoresTeam2.setBounds(442, 246, 103, 36);
		frame.getContentPane().add(jugadoresTeam2);

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
		btnPuntoTeam2.setBounds(442, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam2);

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
		btnPuntoTeam_2.setBounds(326, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam_2);

		JButton btnRegresar = new JButton();
		ImageIcon icnReg = new ImageIcon("imagenes/back1.png");
		btnRegresar.setIcon(icnReg);
		btnRegresar.setBounds(57, 0, 50, 50);
		btnRegresar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventanaPrincipal.getVentanaMarcador().getFrame().setVisible(false);
				ventanaPrincipal.getVentanaTorneo().getFrame().setVisible(true);
				
			}
		});
		
		frame.getContentPane().add(btnRegresar);

		JButton btnHome = new JButton();
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int salir = JOptionPane.showConfirmDialog(null,"¿SEGURO QUE QUIERES SALIR?", "El sistema no guardara informacion", JOptionPane.YES_NO_OPTION);
				if (salir == JOptionPane.YES_OPTION)
				{
					getFrame().setVisible(false);
					getVentanaPrincipal().getVentanaPrincipal().setVisible(true);
				}
			}
		});
		ImageIcon icnHome = new ImageIcon("imagenes/home.png");
		btnHome.setIcon(icnHome);
		btnHome.setBounds(469, 0, 50, 50);
		frame.getContentPane().add(btnHome);

		JButton btnStart = new JButton();
		ImageIcon icnStart = new ImageIcon("imagenes/inicio.png");
		btnStart.setIcon(icnStart);
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

		btnStart.setBounds(279, 243, 30, 30);
		frame.getContentPane().add(btnStart);

		JButton btnStop = new JButton();
		ImageIcon icnStop = new ImageIcon("imagenes/pausa.png");
		btnStop.setIcon(icnStop);
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
		btnStop.setBounds(279, 275, 30, 30);
		frame.getContentPane().add(btnStop);


		JButton btnReanudar = new JButton();
		ImageIcon icnResume = new ImageIcon("imagenes/reanudar.png");
		btnReanudar.setIcon(icnResume);
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
		btnReanudar.setBounds(279, 307, 30, 30);
		frame.getContentPane().add(btnReanudar);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondoMarcador.png"));
		lblNewLabel.setBounds(0, 0, 574, 347);
		frame.getContentPane().add(lblNewLabel);



	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public int getPuntaje1() {
		return puntaje1;
	}

	public void setPuntaje1(int puntaje1) {
		this.puntaje1 = puntaje1;
	}

	public int getPuntaje2() {
		return puntaje2;
	}

	public void setPuntaje2(int puntaje2) {
		this.puntaje2 = puntaje2;
	}

	public JLabel getLblPuntosT1() {
		return lblPuntosT1;
	}

	public void setLblPuntosT1(JLabel lblPuntosT1) {
		this.lblPuntosT1 = lblPuntosT1;
	}

	public JLabel getLblPuntosT2() {
		return lblPuntosT2;
	}

	public void setLblPuntosT2(JLabel lblPuntosT2) {
		this.lblPuntosT2 = lblPuntosT2;
	}

	public JLabel getLblTiempo() {
		return lblTiempo;
	}

	public void setLblTiempo(JLabel lblTiempo) {
		this.lblTiempo = lblTiempo;
	}

	public JLabel getLblNroCuarto() {
		return lblNroCuarto;
	}

	public void setLblNroCuarto(JLabel lblNroCuarto) {
		this.lblNroCuarto = lblNroCuarto;
	}

	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}

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
