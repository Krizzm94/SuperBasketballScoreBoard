package gui;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;


public class VentanaMarcador {

	private JFrame frame;
	private int puntaje1 = 0;
	private int puntaje2 = 0;
	private JLabel lblPuntosT1;
	private JLabel lblPuntosT2;

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 376);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblTiempo = new JLabel("00:00");
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

		JLabel label_3 = new JLabel("1");
		label_3.setFont(new Font("LED BOARD", Font.BOLD, 60));
		label_3.setBounds(272, 117, 50, 74);
		frame.getContentPane().add(label_3);

		JLabel lblTeam = new JLabel("TEAM:");
		lblTeam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTeam.setBounds(50, 205, 46, 14);
		frame.getContentPane().add(lblTeam);

		JLabel lblCuarto = new JLabel("TIEMPO");
		lblCuarto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuarto.setBounds(270, 186, 60, 20);
		frame.getContentPane().add(lblCuarto);

		JLabel label_5 = new JLabel("TEAM:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(429, 205, 46, 14);
		frame.getContentPane().add(label_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(50, 246, 103, 36);
		frame.getContentPane().add(comboBox);

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

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(442, 246, 103, 36);
		frame.getContentPane().add(comboBox_1);

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
		ImageIcon icnHome = new ImageIcon("imagenes/home.png");
		btnHome.setIcon(icnHome);
		btnHome.setBounds(514, 17, 50, 50);
		frame.getContentPane().add(btnHome);
		
		JButton btnStart = new JButton();
		ImageIcon icnStart = new ImageIcon("imagenes/start.png");
		btnStart.setIcon(icnStart);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStart.setBounds(272, 246, 50, 36);
		frame.getContentPane().add(btnStart);
		
		JButton btnStop = new JButton();
		ImageIcon icnStop = new ImageIcon("imagenes/stop.png");
		btnStop.setIcon(icnStop);
		btnStop.setBounds(272, 300, 50, 36);
		frame.getContentPane().add(btnStop);

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
	
}
