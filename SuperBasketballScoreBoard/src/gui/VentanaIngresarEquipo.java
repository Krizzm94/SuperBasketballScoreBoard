package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRootPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import java.awt.Color;
import javax.swing.JButton;

import Estilos.ColorComboBoxEditor;
import Estilos.FormaBotonCircular;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import logica.Equipo;
import logica.Torneo;

public class VentanaIngresarEquipo  {

	private static JFrame frame;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtLugar;
	private VentanaEquipo ventanaEquipo;
	private VentanaPrincipal ventanaPrincipal;
	private 	final JComboBox cmbtorneo ;


	/**
	 * Create the frame.
	 */
	public VentanaIngresarEquipo(final VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal=ventanaPrincipal;
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		frame.setBounds(100, 100, 580, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);

		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(28, 145, 142, 24);
		lblNombre.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		lblNombre.setForeground(Color.WHITE);

		JLabel lbljugadores = new JLabel("N JUGADORES");
		lbljugadores.setBounds(28, 191, 219, 29);
		lbljugadores.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		lbljugadores.setForeground(Color.WHITE);

		JLabel lblColor = new JLabel("COLOR");
		lblColor.setBounds(20, 236, 142, 37);
		lblColor.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		lblColor.setForeground(Color.WHITE);

		JLabel lblLugar = new JLabel("LUGAR");
		lblLugar.setBounds(20, 284, 191, 30);
		lblLugar.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		lblLugar.setForeground(Color.WHITE);

		txtNombre = new JTextField();
		txtNombre.setBounds(181, 135, 185, 34);
		txtNombre.setColumns(10);
		txtNombre.setFont(new Font("Varsity Playbook", Font.PLAIN, 20));

		final JComboBox numJugadores = new JComboBox();
		numJugadores.setBounds(281, 186, 49, 34);
		numJugadores.setModel(new DefaultComboBoxModel(new String[] {"6", "7", "8"}));
		Color colors[] = { Color.black, Color.blue, Color.cyan, Color.darkGray,
				Color.gray, Color.green, Color.lightGray, Color.magenta,
				Color.orange, Color.pink, Color.red, Color.white, Color.yellow };

		final JComboBox colores = new JComboBox(colors);
		colores.setBounds(238, 231, 71, 37);
		colores.setMaximumRowCount(5);
		colores.setEditable(true);
		colores.setRenderer(new ColorCellRenderer());
		Color color = (Color) colores.getSelectedItem();
		ComboBoxEditor editor = new ColorComboBoxEditor(color);
		colores.setEditor(editor);
		
		
		txtLugar = new JTextField();
		txtLugar.setBounds(201, 280, 185, 34);
		txtLugar.setColumns(10);
		txtLugar.setFont(new Font("Varsity Playbook", Font.PLAIN, 20));
		
		JLabel lblTorneo = new JLabel("TORNEO");
		lblTorneo.setForeground(Color.WHITE);
		lblTorneo.setFont(new Font("Varsity Playbook", Font.PLAIN, 30));
		lblTorneo.setBounds(20, 97, 102, 37);
		contentPane.add(lblTorneo);

		cmbtorneo = new JComboBox();
		cmbtorneo.setBounds(147, 100, 219, 29);
		cmbtorneo.setFont(new Font("Varsity Playbook", Font.PLAIN, 20));
		contentPane.add(cmbtorneo);



		JButton btnGuardar = new FormaBotonCircular("GUARDAR");
		btnGuardar.setToolTipText("Crea un nuevo equipo");
		btnGuardar.setText("");
		btnGuardar.setBounds(424, 135, 119, 119);
		btnGuardar.setIcon(new ImageIcon("imagenes/botonGuardar.png"));
		btnGuardar.setPreferredSize(new Dimension(65, 65));
		btnGuardar.setMinimumSize(new Dimension(65, 23));
		btnGuardar.setMaximumSize(new Dimension(65, 30));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreTorneo = cmbtorneo.getSelectedItem().toString();
				String nombre=txtNombre.getText();
				int numJugador=Integer.parseInt(numJugadores.getSelectedItem().toString());
				String color=colores.getSelectedItem().toString();
				String lugar=txtLugar.getText();
				if(nombre.length()!=0 && lugar.length()!=0){
					if(ventanaPrincipal.getGestion().validarEquipo(nombreTorneo,nombre)==false){
						Equipo equipo=new Equipo(nombre, numJugador, color, lugar);
						ventanaPrincipal.getGestion().buscarTorneo(nombreTorneo).agregarEquipo(equipo);
						ventanaPrincipal.getGestion().agregarEquipoSql(equipo, nombreTorneo);
						final Icon ic  =  new ImageIcon("imagenes/check.png");
						JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black> Equipo creado <p>correctamente.</p></font></center></html>","Exito.",JOptionPane.PLAIN_MESSAGE,ic);
						txtNombre.setText("");
						txtLugar.setText("");
					}
					else{
						final Icon ic2  =  new ImageIcon("imagenes/denied.png");
						JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black> El equipo ya existe.</font></center></html>","Error!",JOptionPane.PLAIN_MESSAGE,ic2);
					}
				}else{
					final Icon ic3  =  new ImageIcon("imagenes/denied.png");
					JOptionPane.showMessageDialog(null, "<html><center><font SIZE='5' face='Verdana' color=black>Campos vacios</font></center></html>","Error",JOptionPane.PLAIN_MESSAGE,ic3);
				}

			}
		});
		contentPane.add(btnGuardar);

		JButton btnAtras = new FormaBotonCircular("");
		btnAtras.setToolTipText("Devuelve al menu anterior");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaPrincipal.getVentanaIngresarEquipo().getFrame().setVisible(false);
				ventanaPrincipal.getVentanaEquipo().getVentanaEquipo().setVisible(true);
			}
		});
		ImageIcon icnReg = new ImageIcon("imagenes/backF.png");
		btnAtras.setIcon(icnReg);
		btnAtras.setBounds(10, 11, 50, 50);
		btnAtras.setPreferredSize(new Dimension(65, 65));
		btnAtras.setMinimumSize(new Dimension(65, 23));
		btnAtras.setMaximumSize(new Dimension(65, 30));
		contentPane.add(btnAtras);
		contentPane.setLayout(null);
		contentPane.add(lblNombre);
		contentPane.add(lblColor);
		contentPane.add(numJugadores);
		contentPane.add(colores);
		contentPane.add(txtLugar);
		contentPane.add(txtNombre);
		contentPane.add(lbljugadores);
		contentPane.add(lblLugar);



		JLabel lblNuevoEquipo = new JLabel("NUEVO  EQUIPO");
		lblNuevoEquipo.setForeground(Color.WHITE);
		lblNuevoEquipo.setFont(new Font("Varsity Playbook", Font.PLAIN, 60));
		lblNuevoEquipo.setBounds(115, 10, 340, 66);
		contentPane.add(lblNuevoEquipo);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 580, 350);
		contentPane.add(lblNewLabel);


		cargarTorneos();


	}
	static class ColorCellRenderer implements ListCellRenderer {
		protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

		private final static Dimension preferredSize = new Dimension(0, 20);

		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean cellHasFocus) {
			JLabel renderer = (JLabel) defaultRenderer
					.getListCellRendererComponent(list, value, index,
							isSelected, cellHasFocus);
			if (value instanceof Color) {
				renderer.setBackground((Color) value);
				renderer.setText("");
			}
			renderer.setPreferredSize(preferredSize);
			return renderer;
		}
	}

	public void cargarTorneos(){
		cmbtorneo.removeAllItems();
		for(int i=0;i<ventanaPrincipal.getGestion().getTorneos().size();i++){
			cmbtorneo.addItem(ventanaPrincipal.getGestion().getTorneos().get(i).getNombre());				
		}
	}



	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		VentanaIngresarEquipo.frame = frame;
	}
}