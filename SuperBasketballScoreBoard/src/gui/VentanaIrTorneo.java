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

import logica.Partido;
import logica.Torneo;

//import logica.Torneo;

/**

* Esta clase permite visualizar la ventana ir al Torneo  y  conocer la programacion de el torneo seleccionado y exportar en un archivo esta programacion
 *  ademas de comunicar con otras interfaces entre ellas esta el  iniciar  un encuentro   .
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class VentanaIrTorneo {


	private JTable table; //De tipo Jtable, variable para la tabla
	private DefaultTableModel dtm; //De tipo DefaultTableModel, variable con el modelo de la tabla
	private JScrollPane scrollPane; //De tipo JScrollPane, variable para agregarle scrollpane a la tabla
	private VentanaPrincipal ventanaPrincipal;
	private VentanaMarcador vm;
	private JFrame frame;




	/**
	 * Create the application.
	 */
	public VentanaIrTorneo(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal=ventanaPrincipal;
		initialize();
	}

	/**
	 * inicializa el contenido de la ventana de la  progarmacion de un torneo y la la funcion de  sus botones  .
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
		
		/**
		 * funcion del boton para retornar a la ventana  Torneo
		 */

		JButton btnRegresar = new FormaBotonCircular("");
		btnRegresar.setBounds(10, 11, 50, 50);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaPrincipal.getVentanaTorneo().getFrame().setVisible(true);
				
			}
		});

		/**
		 * funcion del boton para retornar a la ventana  principal 
		 */

		JButton btnHome = new FormaBotonCircular("");
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				final Icon ic2 =  new ImageIcon("imagenes/menu.png");
				int salir = JOptionPane.showConfirmDialog(null,"<html><center><font SIZE='5' face='Verdana' color=black>�Seguro que desea <P>ir al menu principal?</font></center></html>"
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

		JLabel lblProgramacion = new JLabel();
		lblProgramacion.setText("Programacion");
		lblProgramacion.setForeground(Color.WHITE);
		lblProgramacion.setFont(new Font("Varsity Playbook", Font.PLAIN, 25));
		lblProgramacion.setBounds(68, 59, 178, 24);
		frame.getContentPane().add(lblProgramacion);
		btnRegresar.setIcon(icnReg);
		frame.getContentPane().add(btnRegresar);

		/**
		 * funcion del boton para ingresar  a la ventana  del marcador e iniciar un  encuentro 
		 */
		JButton btnIrAlPartido = new FormaBoton("Ir al Partido");
		btnIrAlPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(table.getSelectedRow()>=0){
					int fila=table.getSelectedRow();
					String local=(String) table.getValueAt(fila, 0);
					String visitante=(String) table.getValueAt(fila, 1);
					Torneo t=ventanaPrincipal.getGestion().buscarTorneo(ventanaPrincipal.getTorneo());
					Partido p=t.buscarPartido(local, visitante);
					int id=p.getId();
					if(t.buscarResultado(id)==null) {
						frame.setVisible(false);
						ventanaPrincipal.setLocal(local);
						ventanaPrincipal.setVisitante(visitante);
						ventanaPrincipal.setIdPartido(id);
						vm = new VentanaMarcador(ventanaPrincipal);
						 vm.cargarJugadores();
						  frame.setVisible(false);
						 vm.getFrame().setVisible(true);
					}else {
						final Icon ic3  =  new ImageIcon("imagenes/denied.png");
						JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black> El partido <p>ya tiene un resultado!</font></center></html>","Error!",JOptionPane.PLAIN_MESSAGE,ic3);
					}
				}else{
					final Icon ic3  =  new ImageIcon("imagenes/denied.png");
					JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black> Por favor seleccione <p>un Partido!</font></center></html>","Error!",JOptionPane.PLAIN_MESSAGE,ic3);
				}
			}
		});
		btnIrAlPartido.setBounds(20, 281, 248, 58);
		btnIrAlPartido.setFont(new Font("Varsity Playbook", Font.PLAIN, 35));
		frame.getContentPane().add(btnIrAlPartido);


		String[] columnNames = {"Local", "Visitante", "Fecha","Hora"};

		dtm = new DefaultTableModel (null,columnNames){
			public boolean isCellEditable(int row, int column){
				return false;
			}
		}; 
		table = new JTable (dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		table.setFont(new Font("Dafunk2", Font.PLAIN, 20));
		table.getTableHeader().setReorderingAllowed(false);

		table.setRowHeight(30);
		int[] anchos = {100,100, 100, 40};

		for(int i = 0; i < dtm.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);

		}


		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(22, 83, 535, 184);
		frame.getContentPane().add(jScrollPane);

		/**
		 * funcion del boton para exportar como una imagen png la programacion de un torneo especifico 
		 */
		JButton btnExportar = new FormaBoton("Exportar");
		btnExportar.setBounds(310, 281, 248, 58);
		btnExportar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				saveToImage(table, table.getTableHeader()); 
				final Icon ic1 =  new ImageIcon("imagenes/check.png");
				JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Tabla Exportada<p>exitosamente.</font></center></html>","Exportar.",JOptionPane.PLAIN_MESSAGE,ic1);
				
			}
		});
		btnExportar.setFont(new Font("Varsity Playbook", Font.PLAIN, 35));
		frame.getContentPane().add(btnExportar);

		/**
		 * Establece el fondo de la ventana 
		 */
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 574, 347);
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		frame.getContentPane().add(lblNewLabel);

	}

	/**
	 * carga los encuentros de baloncesto que se van a realizar en un torneo especifico 
	 */
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
	 * guarda y espesifica la exportacion de la imagen 
	 */
	private static void saveToImage(JTable table, JTableHeader header)  
	{  
		int w = Math.max(table.getWidth(), header.getWidth());  
		int h = table.getHeight() + header.getHeight();  
		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);  
		Graphics2D g2 = bi.createGraphics();  
		header.paint(g2);  
		g2.translate(0, header.getHeight());  
		table.paint(g2);  
		g2.dispose();  
		try  
		{  
			ImageIO.write(bi, "png", new File("tableImage.png"));  
		}  
		catch(IOException ioe)  
		{  
			System.out.println("write: " + ioe.getMessage());  
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
