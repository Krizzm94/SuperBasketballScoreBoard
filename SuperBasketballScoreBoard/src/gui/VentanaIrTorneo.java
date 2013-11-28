/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
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

import logica.Torneo;

/**
 * @author Wolfran Pinzon
 * 
 */
public class VentanaIrTorneo {


	private JTable table; //De tipo Jtable, variable para la tabla
	private DefaultTableModel dtm; //De tipo DefaultTableModel, variable con el modelo de la tabla
	private JScrollPane scrollPane; //De tipo JScrollPane, variable para agregarle scrollpane a la tabla
	private VentanaPrincipal ventanaPrincipal;
	private VentanaMarcador ventanaMarcador;
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
		lblTitulo.setFont(new Font("Varsity Playbook", Font.PLAIN, 60));
		frame.getContentPane().add(lblTitulo);

		JButton btnRegresar = new JButton();
		btnRegresar.setBounds(10, 11, 45, 45);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaTorneo().getFrame().setVisible(true);

			}
		});


		JButton btnHome = new JButton();
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Icon ic2 =  new ImageIcon("imagenes/menu.png");
				int salir = JOptionPane.showConfirmDialog(null,"<html><center><font SIZE='5' face='Verdana' color=black>¿SEGURO QUE DESEA <P>IR AL MENU PRINCIPAL?</font></center></html>"
														, "Ir al menu principal", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,ic2);
				if (salir == JOptionPane.YES_OPTION)
				{
					getFrame().setVisible(false);
					ventanaPrincipal.getVentanaPrincipal().setVisible(true);
				}



			}
		});
		ImageIcon icnHome = new ImageIcon("imagenes/home.png");
		btnHome.setIcon(icnHome);
		btnHome.setBounds(514, 17, 50, 50);
		frame.getContentPane().add(btnHome);
		
		
		
		ImageIcon icnReg = new ImageIcon("imagenes/back1.png");
		
		JLabel lblProgramacion = new JLabel();
		lblProgramacion.setText("Programacion");
		lblProgramacion.setForeground(Color.WHITE);
		lblProgramacion.setFont(new Font("Varsity Playbook", Font.PLAIN, 25));
		lblProgramacion.setBounds(68, 59, 178, 24);
		frame.getContentPane().add(lblProgramacion);
		btnRegresar.setIcon(icnReg);
		frame.getContentPane().add(btnRegresar);


		JButton btnIrAlPartido = new JButton("Ir al Partido");
		btnIrAlPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>=0){
					frame.setVisible(false);
					int fila=table.getSelectedRow();
					String local=(String) table.getValueAt(fila, 0);
					String visitante=(String) table.getValueAt(fila, 1);
					ventanaPrincipal.setLocal(local);
					ventanaPrincipal.setVisitante(visitante);
					 ventanaMarcador = new VentanaMarcador(ventanaPrincipal);
					 frame.setVisible(false);
					 ventanaMarcador.getFrame().setVisible(true);
					}else{
						final Icon ic3  =  new ImageIcon("imagenes/denied.png");
						JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black> Por favor seleccione <p>un Partido!</font></center></html>","Error!",JOptionPane.PLAIN_MESSAGE,ic3);
					}
			}
		});
		btnIrAlPartido.setBounds(100, 278, 388, 58);
		btnIrAlPartido.setFont(new Font("Varsity Playbook", Font.PLAIN, 35));
		frame.getContentPane().add(btnIrAlPartido);



		

		
		
		String[] columnNames = {"Local", "Visitante", "Fecha","Hora"};

		dtm = new DefaultTableModel (null,columnNames); 
		table = new JTable (dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		table.setFont(new Font("Varsity Playbook", Font.PLAIN, 28));
	
		table.setRowHeight(30);
		int[] anchos = {100,100, 100, 40};

		for(int i = 0; i < dtm.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
			
		}


		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(22, 83, 535, 184);
		frame.getContentPane().add(jScrollPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 574, 347);
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		frame.getContentPane().add(lblNewLabel);
	}

	
	public void cargarPartidos(){
		while(dtm.getRowCount()>0)dtm.removeRow(0);
		Torneo tor=ventanaPrincipal.getGestion().buscarTorneo(ventanaPrincipal.getTorneo());
		for(int c=0;c<tor.getPartidos().size();c++){
			String local=String.valueOf(tor.getPartidos().get(c).getEquipoLocal().getNombre());
			String vis=String.valueOf(tor.getPartidos().get(c).getEquipoVisitante().getNombre());
			String hora=String.valueOf(tor.getPartidos().get(c).getHora());
			String fecha=String.valueOf(tor.getPartidos().get(c).getFecha());
			String [] filas={local,vis,fecha,hora};
			dtm.addRow(filas);
		}
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
