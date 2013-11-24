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
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
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



	private JTable table; //De tipo Jtable, variable para la tabla
	private DefaultTableModel dtm; //De tipo DefaultTableModel, variable con el modelo de la tabla
	private JScrollPane scrollPane; //De tipo JScrollPane, variable para agregarle scrollpane a la tabla
	private VentanaPrincipal ventanaPrincipal;
	private VentanaNuevoTorneo ventanaNuevoTorneo;
	private VentanaIrTorneo ventanaIrTorneo;
	private JFrame frame;

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
		frame.setBounds(100, 100, 580, 350);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
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
				frame.setVisible(false);
				 ventanaNuevoTorneo = new VentanaNuevoTorneo(ventanaPrincipal);
				 ventanaNuevoTorneo.getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		frame.getContentPane().add(btnNewButton);

		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(414, 278, 150, 58);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0){
					int fila=table.getSelectedRow();
					String nombre=(String) table.getValueAt(fila, 0);
					int opcion=JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el torneo '"+nombre+"'","Advertencia",JOptionPane.YES_NO_OPTION);
					if(opcion==0){
						ventanaPrincipal.getGestion().eliminarTorneo(nombre);
						cargarTorneos();
					}
				}else{
					JOptionPane.showMessageDialog(null, "Por favor seleccione un torneo","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btnEliminar.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		frame.getContentPane().add(btnEliminar);

		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 45, 45);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);

			}
		});

		ImageIcon icnReg = new ImageIcon("imagenes/back1.png");
		btnRegresar.setIcon(icnReg);
		frame.getContentPane().add(btnRegresar);


		JButton btnIrAlTorneo = new JButton("Ir al Torneo");
		btnIrAlTorneo.setBounds(170, 278, 234, 58);
		btnIrAlTorneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>=0){
				frame.setVisible(false);
				int fila=table.getSelectedRow();
				String nombre=(String) table.getValueAt(fila, 0);
				ventanaPrincipal.setTorneo(nombre);
				 ventanaIrTorneo = new VentanaIrTorneo(ventanaPrincipal);
				 ventanaIrTorneo.getFrame().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Por favor seleccione un torneo","Advertencia",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnIrAlTorneo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		frame.getContentPane().add(btnIrAlTorneo);



		

		
		
		String[] columnNames = {"Nombre", "Numero Equipos", "Cupos"};

		dtm = new DefaultTableModel (columnNames,3); 
		table = new JTable (dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		table.setFont(new Font("LMS I Love This Game", Font.PLAIN, 13));
	
		table.setRowHeight(30);

		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(68, 68, 452, 182);
		frame.getContentPane().add(jScrollPane);

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

	/**
	 * Launch the application.
	 */
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


}
