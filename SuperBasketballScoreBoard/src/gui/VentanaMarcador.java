package gui;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaMarcador extends Thread implements Runnable {

	private JFrame frame;
	private JLabel lblPuntosT1;
	private JLabel lblPuntosT2;
	private JLabel lblTiempo;
	private JLabel lblNroCuarto;
	private JComboBox jugadoresTeam1;
	private JComboBox jugadoresTeam2;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMarcador window = new VentanaMarcador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaMarcador() {
		pause = false;
		stop = false;
		thread = new Thread(this);
		speed = 0;
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
							JOptionPane.showMessageDialog(null,"FINALIZO ESTE CUARTO", "Fin del conteo", JOptionPane.INFORMATION_MESSAGE);
							getLblNroCuarto().setText("2");
							break;//seacabo el tiempo fin hilo  

						}
					}
				}   
				getLblTiempo().setText("0"+nuMin+":"+nuSeg);
				try {
					sleep(998);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)


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

	//	synchronized void stop() {
	//		stop = true;
	//		pause = false;
	//		notify();
	//	}
	//	
	//
	//	synchronized void resume() {
	//		pause = false;
	//		notify();
	//	}
	//	synchronized void suspend() {
	//		pause = true;
	//
	//	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 376);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		this.ventanaPrincipal = new VentanaPrincipal();

		this.lblTiempo = new JLabel("10:00");
		lblTiempo.setFont(new Font("LED BOARD", Font.BOLD, 70));
		lblTiempo.setBounds(151, 17, 290, 89);
		frame.getContentPane().add(lblTiempo);


		this.lblPuntosT1 = new JLabel(Integer.toString(puntaje1));
		lblPuntosT1.setFont(new Font("LED BOARD", Font.BOLD, 70));
		lblPuntosT1.setBounds(50, 117, 116, 89);
		frame.getContentPane().add(lblPuntosT1);

		this.lblPuntosT2 = new JLabel(Integer.toString(puntaje2));
		lblPuntosT2.setFont(new Font("LED BOARD", Font.BOLD, 70));
		lblPuntosT2.setBounds(429, 117, 116, 89);
		frame.getContentPane().add(lblPuntosT2);

		this.lblNroCuarto = new JLabel("1");
		lblNroCuarto.setFont(new Font("LED BOARD", Font.BOLD, 60));
		lblNroCuarto.setBounds(266, 125, 50, 74);
		frame.getContentPane().add(lblNroCuarto);

		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTeam.setBounds(50, 205, 46, 14);
		frame.getContentPane().add(lblTeam);

		JLabel lblCuarto = new JLabel("TIEMPO");
		lblCuarto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuarto.setBounds(266, 200, 60, 20);
		frame.getContentPane().add(lblCuarto);

		JLabel label_5 = new JLabel("TEAM:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(429, 205, 46, 14);
		frame.getContentPane().add(label_5);

		this.jugadoresTeam1 = new JComboBox();
		jugadoresTeam1.setBounds(50, 246, 103, 36);
		frame.getContentPane().add(jugadoresTeam1);

		JButton btnNewButton = new JButton("FALTA");
		btnNewButton.setBounds(166, 246, 103, 36);
		frame.getContentPane().add(btnNewButton);

		JButton btnPuntoTeam1 = new JButton("1 PUNTO");
		btnPuntoTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux = getPuntaje1()+1;
				setPuntaje1(aux);
				getLblPuntosT1().setText(Integer.toString(aux));

			}
		});
		btnPuntoTeam1.setBounds(50, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam1);

		JButton btnPuntoTeam_1 = new JButton("-1 PUNTO");
		btnPuntoTeam_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux = getPuntaje1()-1;
				setPuntaje1(aux);
				getLblPuntosT1().setText(Integer.toString(aux));

			}
		});
		btnPuntoTeam_1.setBounds(166, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam_1);

		JButton btnFalta = new JButton("FALTA");
		btnFalta.setBounds(326, 246, 103, 36);
		frame.getContentPane().add(btnFalta);

		this.jugadoresTeam2 = new JComboBox();
		jugadoresTeam2.setBounds(442, 246, 103, 36);
		frame.getContentPane().add(jugadoresTeam2);

		JButton btnPuntoTeam2 = new JButton("-1 PUNTO");
		btnPuntoTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int aux = getPuntaje2()-1;
				setPuntaje2(aux);
				getLblPuntosT2().setText(Integer.toString(aux));

			}
		});
		btnPuntoTeam2.setBounds(442, 300, 103, 36);
		frame.getContentPane().add(btnPuntoTeam2);

		JButton btnPuntoTeam_2 = new JButton("1 PUNTO");
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
		btnRegresar.setBounds(10, 11, 50, 50);
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
		btnHome.setBounds(514, 17, 50, 50);
		frame.getContentPane().add(btnHome);

		JButton btnStart = new JButton();
		ImageIcon icnStart = new ImageIcon("imagenes/start.png");
		btnStart.setIcon(icnStart);
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				start();

			}
		});

		btnStart.setBounds(272, 246, 50, 36);
		frame.getContentPane().add(btnStart);

		JButton btnStop = new JButton();
		ImageIcon icnStop = new ImageIcon("imagenes/stop.png");
		btnStop.setIcon(icnStop);
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		btnStop.setBounds(272, 300, 50, 36);
		frame.getContentPane().add(btnStop);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondoCron.png"));
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


}
