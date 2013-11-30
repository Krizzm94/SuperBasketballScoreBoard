package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import javax.swing.JComboBox;

import Estilos.FormaBoton;
import Estilos.FormaBotonCircular;




public class VentanaEquipo {

	private JFrame VentanaEquipo;
	private VentanaPrincipal ventanaPrincipal;
	private JTable table;
	private DefaultTableModel dtm;
	private JComboBox torneo;



	/**
	 * constructor
	 */
	public VentanaEquipo(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal=ventanaPrincipal;
		inicializar();
	}

	/**
	 * Iicializamos los componentes
	 */
	private void inicializar() {
		VentanaEquipo = new JFrame();
		VentanaEquipo.getContentPane().setBackground(new Color(0, 0, 0));
		VentanaEquipo.setBounds(100, 100, 580, 350);
		VentanaEquipo.setResizable(false);
		VentanaEquipo.setLocationRelativeTo(null);
		VentanaEquipo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VentanaEquipo.setUndecorated(true);
		VentanaEquipo.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		VentanaEquipo.getContentPane().setLayout(null);



		JButton btnNuevo = new FormaBoton( "Boton" );
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnNuevo.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		btnNuevo.setText("NUEVO");
		btnNuevo.setBackground(new Color(255, 250, 250));
		btnNuevo.setForeground(Color.DARK_GRAY);
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo.setVisible(false);
				ventanaPrincipal.getVentanaIngresarEquipo().getFrame().setVisible(true);
				ventanaPrincipal.getVentanaIngresarEquipo().getFrame().setLocationRelativeTo(null);


			}
		});
		
		btnNuevo.setBounds(22, 291, 160, 45);
		VentanaEquipo.getContentPane().add(btnNuevo);



		JButton btnBorrar = new FormaBoton( "Boton" );
		btnBorrar.setBackground(Color.WHITE);
		btnBorrar.setText("BORRAR");
		btnBorrar.setForeground(Color.DARK_GRAY);
		btnBorrar.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Boton Equipo");
			}
		});
		
		btnBorrar.setBounds(384, 291, 160, 45);
		VentanaEquipo.getContentPane().add(btnBorrar);

		JButton btnAtras = new FormaBotonCircular( "Boton" );
		btnAtras.setBackground(Color.WHITE);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaEquipo.setVisible(false);
				ventanaPrincipal.getVentanaPrincipal().setVisible(true);
			}
		});
		btnAtras.setHorizontalAlignment(SwingConstants.LEADING);
		btnAtras.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		btnAtras.setText("ATRAS");
		btnAtras.setForeground(Color.DARK_GRAY);
		btnAtras.setBounds(10, 3, 72, 73);
		VentanaEquipo.getContentPane().add(btnAtras);
		

		JButton btnListar = new FormaBoton( "Boton" );
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnListar.setBackground(Color.WHITE);
		btnListar.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		btnListar.setText("VER");
		btnListar.setForeground(Color.DARK_GRAY);;
		btnListar.setBounds(200, 291, 160, 45);
		VentanaEquipo.getContentPane().add(btnListar);

		JLabel lblEquipo = new JLabel("EQUIPOS");
		lblEquipo.setFont(new Font("Varsity Playbook", Font.PLAIN, 60));
		lblEquipo.setBackground(new Color(255, 245, 238));
		lblEquipo.setForeground(Color.WHITE);
		lblEquipo.setBounds(200, 10, 190, 66);
		VentanaEquipo.getContentPane().add(lblEquipo);


		String[] columnNames = {"Nombre", "#Jugadores","Lugar"};

		dtm = new DefaultTableModel (null,columnNames);
		table = new JTable(dtm);


		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(Color.white);
		table.setFont(new Font("Varsity Playbook", Font.PLAIN, 28));
		table.setRowHeight(30);

		int[] anchos = {150, 30, 150};

		for(int i = 0; i < dtm.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);

		}


		JScrollPane tablaEquipo = new JScrollPane(table);
		tablaEquipo.setBounds(70, 126, 452, 146);
		tablaEquipo.setFont(new  Font("Varsity Playbook", Font.PLAIN, 28) );
		VentanaEquipo.getContentPane().add(tablaEquipo);

		JLabel lblTorneo = new JLabel("TORNEO:");
		lblTorneo.setFont(new Font("Varsity Playbook", Font.PLAIN, 40));
		lblTorneo.setForeground(Color.WHITE);
		lblTorneo.setBounds(81, 71, 128, 44);
		VentanaEquipo.getContentPane().add(lblTorneo);

		torneo = new JComboBox();
		torneo.setBounds(221, 71, 285, 33);
		VentanaEquipo.getContentPane().add(torneo);
		

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 574, 347);
		VentanaEquipo.getContentPane().add(lblNewLabel);
		cargarTorneos();

	}
	public void cargarTorneos(){
		torneo.removeAllItems();
		for(int i=0;i<ventanaPrincipal.getGestion().getTorneos().size();i++){
			torneo.addItem(ventanaPrincipal.getGestion().getTorneos().get(i).getNombre());				
		}
	}
	public JFrame getVentanaPrincipal() {
		return VentanaEquipo;
	}

	public void setVentanaPrincipal(JFrame ventanaPrincipal) {
		VentanaEquipo = ventanaPrincipal;
	}

	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}

	public JFrame getVentanaEquipo() {
		return VentanaEquipo;
	}

	public void setVentanaEquipo(JFrame ventanaEquipo) {
		VentanaEquipo = ventanaEquipo;
	}
}
