/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;

import Estilos.FormaBoton;
import Estilos.FormaBotonCircular;

import logica.Equipo;
import logica.Partido;
import logica.Torneo;

//import logica.Torneo;

/**
 * @author Wolfran Pinzon
 * 
 */
public class VentanaVerEquipo {


	private JTable table; //De tipo Jtable, variable para la tabla
	private DefaultTableModel dtm; //De tipo DefaultTableModel, variable con el modelo de la tabla
	private JScrollPane scrollPane; //De tipo JScrollPane, variable para agregarle scrollpane a la tabla
	private VentanaPrincipal ventanaPrincipal;
	private JFrame frame;




	/**
	 * Create the application.
	 */
	public VentanaVerEquipo(VentanaPrincipal ventanaPrincipal) {
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



		JLabel lblTitulo = new JLabel(ventanaPrincipal.getEquipo());
		lblTitulo.setBounds(100, 13, 388, 43);
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Varsity Playbook", Font.PLAIN, 60));
		frame.getContentPane().add(lblTitulo);

		JButton btnRegresar = new FormaBotonCircular("");
		btnRegresar.setBounds(10, 11, 50, 50);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaEquipo().getVentanaEquipo().setVisible(true);
				
			}
		});


		JButton btnHome = new FormaBotonCircular("");
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Icon ic2 =  new ImageIcon("imagenes/menu.png");
				int salir = JOptionPane.showConfirmDialog(null,"<html><center><font SIZE='5' face='Verdana' color=black>¿Seguro que desea <P>ir al menu principal?</font></center></html>"
						, "Ir al menu principal", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,ic2);
				if (salir == JOptionPane.YES_OPTION)
				{
					getFrame().setVisible(false);
					ventanaPrincipal.getVentanaPrincipal().setVisible(true);
				}



			}
		});
		ImageIcon icnHome = new ImageIcon("imagenes/homeF.png");
		btnHome.setIcon(icnHome);
		btnHome.setBounds(514, 11, 50, 50);
		frame.getContentPane().add(btnHome);



		ImageIcon icnReg = new ImageIcon("imagenes/backF.png");

		btnRegresar.setIcon(icnReg);
		frame.getContentPane().add(btnRegresar);


		


		String[] columnNames = {"Jugadores", "Numero"};

		dtm = new DefaultTableModel (null,columnNames){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		}; 
		table = new JTable (dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		table.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		table.getTableHeader().setReorderingAllowed(false);

		table.setRowHeight(30);
		int[] anchos = {100,100};

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


	public void cargarJugadores(String equipo){
		while(dtm.getRowCount()>0)dtm.removeRow(0);
		Torneo tor=ventanaPrincipal.getGestion().buscarTorneo(ventanaPrincipal.getTorneo());
		Equipo e=tor.buscarEquipo(equipo);
		for(int c=0;c<e.getJugador().length;c++){
			if(e.getJugador()[c]!=null) {
			String J=String.valueOf("Jugador "+(c+1));
			String numero=String.valueOf(e.getJugador()[c].getNumber());
			String [] filas={J,numero};
			dtm.addRow(filas);
			}
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
					VentanaVerEquipo window = new VentanaVerEquipo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
