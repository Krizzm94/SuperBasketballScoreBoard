package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
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

public class VentanaIngresarEquipo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtJugadores;
	private JTextField txtLugar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresarEquipo frame = new VentanaIngresarEquipo();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaIngresarEquipo() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton btnAtras = new FormaBotonCircular("ATRAS");
		
		JButton btnGuardar = new FormaBotonCircular("GUARDAR");
		btnGuardar.setPreferredSize(new Dimension(65, 65));
		btnGuardar.setMinimumSize(new Dimension(65, 23));
		btnGuardar.setMaximumSize(new Dimension(65, 23));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnGuardar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
						.addComponent(btnAtras, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		txtJugadores = new JTextField();
		txtJugadores.setColumns(10);
		
		txtLugar = new JTextField();
		txtLugar.setColumns(10);
		 Color colors[] = { Color.black, Color.blue, Color.cyan, Color.darkGray,
			        Color.gray, Color.green, Color.lightGray, Color.magenta,
			        Color.orange, Color.pink, Color.red, Color.white, Color.yellow };
		JComboBox colores = new JComboBox(colors);
		 colores.setMaximumRowCount(5);
		    colores.setEditable(true);
		    colores.setRenderer(new ColorCellRenderer());
		    Color color = (Color) colores.getSelectedItem();
		    ComboBoxEditor editor = new ColorComboBoxEditor(color);
		    colores.setEditor(editor);
		
		JComboBox comboBox = new JComboBox();
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtLugar, 170, 170, 170)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
							.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtJugadores, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(colores, Alignment.LEADING, 0, 48, Short.MAX_VALUE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(txtJugadores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(colores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(txtLugar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		lblNombre.setForeground(Color.DARK_GRAY);
		
		JLabel lbljugadores = new JLabel("N Jugadores");
		lbljugadores.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		lbljugadores.setForeground(Color.DARK_GRAY);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		lblColor.setForeground(Color.DARK_GRAY);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		lblLugar.setForeground(Color.DARK_GRAY);
		
		JLabel lblTorneo = new JLabel("Torneo");
		lblTorneo.setForeground(Color.DARK_GRAY);
		lblTorneo.setFont(new Font("LMS I Love This Game", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLugar)
						.addComponent(lblColor)
						.addComponent(lblTorneo)
						.addComponent(lblNombre)
						.addComponent(lbljugadores, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(lblTorneo)
					.addGap(42)
					.addComponent(lblNombre)
					.addGap(33)
					.addComponent(lbljugadores, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addComponent(lblColor)
					.addGap(49)
					.addComponent(lblLugar)
					.addGap(29))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		

		 
		
	
	
		
		//Color c = JColorChooser.showDialog(this,"colores", Color.BLUE);
	}
	 static class ColorCellRenderer implements ListCellRenderer {
		    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

		    // width doesn't matter as combobox will size
		    private final static Dimension preferredSize = new Dimension(0, 20);

		    public Component getListCellRendererComponent(JList list, Object value,
		        int index, boolean isSelected, boolean cellHasFocus) {
		      JLabel renderer = (JLabel) defaultRenderer
		          .getListCellRendererComponent(list, value, index,
		              isSelected, cellHasFocus);
		      if (value instanceof Color) {
		        renderer.setBackground((Color) value);
		      }
		      renderer.setPreferredSize(preferredSize);
		      return renderer;
		    }
		  }
}
