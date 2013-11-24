/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * @author Wolfran Pinzon
 * 
 */
public class VentanaIrTorneo {


	private JTable table; //De tipo Jtable, variable para la tabla
	private DefaultTableModel dtm; //De tipo DefaultTableModel, variable con el modelo de la tabla
	private JScrollPane scrollPane; //De tipo JScrollPane, variable para agregarle scrollpane a la tabla
	private VentanaPrincipal ventanaPrincipal;
	private VentanaNuevoTorneo ventanaNuevoTorneo;
	private JFrame frame;




	/**
	 * Create the application.
	 */
	public VentanaIrTorneo(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal=ventanaPrincipal;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 350);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.getContentPane().setLayout(null);



		JLabel lblTitulo = new JLabel(ventanaPrincipal.getTorneo());
		lblTitulo.setBounds(100, 13, 388, 43);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("LMS I Love This Game", Font.BOLD, 30));
		frame.getContentPane().add(lblTitulo);

		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 45, 45);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaTorneo().getFrame().setVisible(true);

			}
		});

		ImageIcon icnReg = new ImageIcon("imagenes/back1.png");
		
		JLabel lblProgramacion = new JLabel();
		lblProgramacion.setText("Programacion");
		lblProgramacion.setForeground(Color.WHITE);
		lblProgramacion.setFont(new Font("LMS I Love This Game", Font.BOLD, 14));
		lblProgramacion.setBounds(68, 59, 178, 24);
		frame.getContentPane().add(lblProgramacion);
		btnRegresar.setIcon(icnReg);
		frame.getContentPane().add(btnRegresar);


		JButton btnIrAlPartido = new JButton("Ir al Partido");
		btnIrAlPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaMarcador().getFrame().setVisible(true);
			}
		});
		btnIrAlPartido.setBounds(100, 278, 388, 58);
		btnIrAlPartido.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		frame.getContentPane().add(btnIrAlPartido);



		

		
		
		String[] columnNames = {"Local", "Visitante", "Fecha","Hora"};

		dtm = new DefaultTableModel (columnNames,4); 
		table = new JTable (dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		table.setFont(new Font("LMS I Love This Game", Font.PLAIN, 13));
	
		table.setRowHeight(30);

		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(68, 83, 452, 184);
		frame.getContentPane().add(jScrollPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 574, 347);
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		frame.getContentPane().add(lblNewLabel);

	}

	
	
	
	/**
	 * @return the dtm
	 */
	public DefaultTableModel getDtm() {
		return dtm;
	}

	/**
	 * @param dtm the dtm to set
	 */
	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIrTorneo window = new VentanaIrTorneo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
