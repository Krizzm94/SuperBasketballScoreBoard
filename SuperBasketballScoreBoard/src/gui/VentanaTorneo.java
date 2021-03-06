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

import javax.swing.Icon;
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
import javax.swing.table.JTableHeader;
import javax.swing.JScrollBar;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;

import Estilos.FormaBoton;
import Estilos.FormaBotonCircular;

/**

 * Esta clase permite visualizar la ventana Torneo  con todos sus componentes,
 * permitiendo asi el acceso a otras funciones delimitadas en esta 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class VentanaTorneo {



	private JTable table; //De tipo Jtable, variable para la tabla
	private DefaultTableModel dtm; //De tipo DefaultTableModel, variable con el modelo de la tabla
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
		lblJugador.setBounds(165, 13, 219, 70);
		lblJugador.setForeground(Color.WHITE);
		lblJugador.setFont(new Font("Varsity Playbook", Font.PLAIN, 60));
		frame.getContentPane().add(lblJugador);

		JButton btnNewButton = new FormaBoton("NUEVO");
		btnNewButton.setBounds(10, 278, 150, 58);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaNuevoTorneo = new VentanaNuevoTorneo(ventanaPrincipal);
				ventanaNuevoTorneo.getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Varsity Playbook", Font.PLAIN, 35));
		frame.getContentPane().add(btnNewButton);

		JButton btnEliminar = new FormaBoton("ELIMINAR");
		btnEliminar.setBounds(398, 278, 168, 58);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>=0){
					int fila=table.getSelectedRow();
					String nombre=(String) table.getValueAt(fila, 0);
					final Icon ic1  =  new ImageIcon("imagenes/caution.png");
					int opcion=JOptionPane.showConfirmDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>�Esta seguro que desea<p>eliminar el torneo?.<p>'"+nombre+"'</font></center></html>",
							"Eliminar.",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,ic1);
					if(opcion==0){
						ventanaPrincipal.getGestion().eliminarTorneo(nombre);
						cargarTorneos();
						ventanaPrincipal.getVentanaJugador().cargarTorneos();
						ventanaPrincipal.getVentanaEquipo().cargarTorneos();
					}
				}else{
					final Icon ic3  =  new ImageIcon("imagenes/denied.png");
					JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Por favor seleccione <p>un torneo.</font></center></html>","Ojo.",JOptionPane.PLAIN_MESSAGE,ic3);
				}
			}
		});

		btnEliminar.setFont(new Font("Varsity Playbook", Font.PLAIN, 35));
		frame.getContentPane().add(btnEliminar);

		JButton btnRegresar = new FormaBotonCircular("");
		btnRegresar.setBounds(10, 11, 50, 50);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);

			}
		});

		ImageIcon icnReg = new ImageIcon("imagenes/backF.png");
		btnRegresar.setIcon(icnReg);
		frame.getContentPane().add(btnRegresar);



		JButton btnIrAlTorneo = new FormaBoton("IR AL TORNEO");
		btnIrAlTorneo.setBounds(170, 278, 220, 58);
		btnIrAlTorneo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>=0){
					frame.setVisible(false);
					int fila=table.getSelectedRow();
					String nombre=(String) table.getValueAt(fila, 0);
					ventanaPrincipal.setTorneo(nombre);
					ventanaIrTorneo = new VentanaIrTorneo(ventanaPrincipal);
					ventanaIrTorneo.cargarPartidos();
					ventanaIrTorneo.getFrame().setVisible(true);
				}else{
					final Icon ic3  =  new ImageIcon("imagenes/denied.png");
					JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Por favor seleccione <p>un torneo.</font></center></html>","Ojo.",JOptionPane.PLAIN_MESSAGE,ic3);
				}
			}
		});
		btnIrAlTorneo.setFont(new Font("Varsity Playbook", Font.PLAIN, 35));
		frame.getContentPane().add(btnIrAlTorneo);







		String[] columnNames = {"Nombre", "Equipos", "Cupos"};

		dtm = new DefaultTableModel (columnNames,3){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		table = new JTable (dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		table.setFont(new Font("Varsity Playbook", Font.PLAIN, 28));
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);

		int[] anchos = {200, 30, 30};

		for(int i = 0; i < dtm.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);

		}


		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(68, 68, 452, 182);
		frame.getContentPane().add(jScrollPane);

		/**
		 * Establece el fondo de la ventana 
		 */
		
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
			int cup=(ventanaPrincipal.getGestion().getTorneos().get(c).getNumEquipos())-(ventanaPrincipal.getGestion().getTorneos().get(c).contarEquipos());
			String cupos=String.valueOf(cup);
			String [] filas={ventanaPrincipal.getGestion().getTorneos().get(c).getNombre(),equipos,cupos};
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

}
