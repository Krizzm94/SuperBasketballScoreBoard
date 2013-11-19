/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;

/**
 * @author Wolfran Pinzon
 * 
 */
public class VentanaTorneo {

	private JFrame frame;
	private VentanaPrincipal ventanaPrincipal;
	private JTable table;
	private DefaultTableModel dtm;

	

	/**
	 * Create the application.
	 */
	public VentanaTorneo(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal=ventanaPrincipal;
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



		JLabel lblJugador = new JLabel("TORNEOS");
		lblJugador.setBounds(165, 13, 219, 43);
		lblJugador.setForeground(new Color(255, 255, 255));
		lblJugador.setFont(new Font("LMS I Love This Game", Font.BOLD, 30));
		frame.getContentPane().add(lblJugador);

		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(10, 278, 150, 58);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		frame.getContentPane().add(btnNewButton);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(414, 278, 150, 58);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnEliminar.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		frame.getContentPane().add(btnEliminar);

		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 45, 45);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);

			}
		});
		
		ImageIcon icnReg = new ImageIcon("imagenes/back1.png");
		btnRegresar.setIcon(icnReg);
		frame.getContentPane().add(btnRegresar);
		
		
		JButton btnIrAlTorneo = new JButton("Ir al Torneo");
		btnIrAlTorneo.setBounds(170, 278, 234, 58);
		btnIrAlTorneo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		frame.getContentPane().add(btnIrAlTorneo);
		
		
		
		String[] columnNames = {"Nombre", "Numero Equipos", "Cupos"};

		dtm = new DefaultTableModel (null, columnNames); 
		table = new JTable(dtm);
		new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		table.setFont(new Font("LMS I Love This Game", Font.PLAIN, 13));
		table.setBounds(68, 68, 452, 182);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setRowHeight(30);
		
		
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 574, 347);
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		frame.getContentPane().add(lblNewLabel);
		cargarTorneos();

	}
	
	
	public void cargarTorneos(){
	     while(dtm.getRowCount()>0)dtm.removeRow(0);
	   for(int c=0;c<ventanaPrincipal.getGestion().getTorneos().size();c++){
		   String equipos=String.valueOf(ventanaPrincipal.getGestion().getTorneos().get(c).getNumEquipos());
		   String [] filas={ventanaPrincipal.getGestion().getTorneos().get(c).getNombre(),equipos,""};
			dtm.addRow(filas);
	     }
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaTorneo window = new VentanaTorneo(null);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//	
	
}
