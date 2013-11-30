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
import javax.swing.ImageIcon;
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
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class VentanaIngresarEquipo  {

	private static JFrame frame;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtLugar;
	private VentanaEquipo ventanaEquipo;
	private VentanaPrincipal ventanaPrincipal;



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

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(28, 102, 142, 24);
		lblNombre.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lblNombre.setForeground(Color.WHITE);

		JLabel lbljugadores = new JLabel("N Jugadores");
		lbljugadores.setBounds(28, 158, 219, 29);
		lbljugadores.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lbljugadores.setForeground(Color.WHITE);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(28, 212, 142, 37);
		lblColor.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lblColor.setForeground(Color.WHITE);

		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(28, 279, 191, 30);
		lblLugar.setFont(new Font("LMS I Love This Game", Font.PLAIN, 20));
		lblLugar.setForeground(Color.WHITE);

		txtNombre = new JTextField();
		txtNombre.setBounds(205, 100, 185, 34);
		txtNombre.setColumns(10);

		JComboBox numJugadores = new JComboBox();
		numJugadores.setBounds(280, 158, 49, 34);
		numJugadores.setModel(new DefaultComboBoxModel(new String[] {"6", "7", "8"}));
		Color colors[] = { Color.black, Color.blue, Color.cyan, Color.darkGray,
				Color.gray, Color.green, Color.lightGray, Color.magenta,
				Color.orange, Color.pink, Color.red, Color.white, Color.yellow };

		JComboBox colores = new JComboBox(colors);
		colores.setBounds(238, 212, 71, 37);
		colores.setMaximumRowCount(5);
		colores.setEditable(true);
		colores.setRenderer(new ColorCellRenderer());
		Color color = (Color) colores.getSelectedItem();
		ComboBoxEditor editor = new ColorComboBoxEditor(color);
		colores.setEditor(editor);
		txtLugar = new JTextField();
		txtLugar.setBounds(201, 280, 185, 34);
		txtLugar.setColumns(10);


		JButton btnGuardar = new FormaBotonCircular("GUARDAR");
		btnGuardar.setToolTipText("Crea un nuevo equipo");
		btnGuardar.setText("");
		btnGuardar.setBounds(429, 65, 119, 119);
		btnGuardar.setIcon(new ImageIcon("imagenes/botonGuardar.png"));
		btnGuardar.setPreferredSize(new Dimension(65, 65));
		btnGuardar.setMinimumSize(new Dimension(65, 23));
		btnGuardar.setMaximumSize(new Dimension(65, 30));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JButton btnAtras = new FormaBotonCircular("");
		btnAtras.setToolTipText("Devuelve al menu anterior");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				ventanaEquipo = new VentanaEquipo(ventanaPrincipal);
				ventanaEquipo.getVentanaEquipo().setVisible(true);
			}
		});
		btnAtras.setBounds(429, 195, 119, 119);
		btnAtras.setIcon(new ImageIcon("imagenes/botonAtras.png"));
		btnAtras.setPreferredSize(new Dimension(65, 65));
		btnAtras.setMinimumSize(new Dimension(65, 23));
		btnAtras.setMaximumSize(new Dimension(65, 30));

		contentPane.setLayout(null);
		contentPane.add(lblNombre);
		contentPane.add(lblColor);
		contentPane.add(numJugadores);
		contentPane.add(colores);
		contentPane.add(txtLugar);
		contentPane.add(txtNombre);
		contentPane.add(lbljugadores);
		contentPane.add(lblLugar);
		contentPane.add(btnGuardar);
		contentPane.add(btnAtras);

		JLabel lblNuevoEquipo = new JLabel("NUEVO EQUIPO");
		lblNuevoEquipo.setForeground(Color.WHITE);
		lblNuevoEquipo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 30));
		lblNuevoEquipo.setBounds(115, 11, 331, 37);
		contentPane.add(lblNuevoEquipo);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("imagenes/fondo.png"));
		lblNewLabel.setBounds(0, 0, 580, 350);
		contentPane.add(lblNewLabel);





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





	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		VentanaIngresarEquipo.frame = frame;
	}


}