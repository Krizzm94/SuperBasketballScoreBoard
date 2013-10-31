/**
 * 
 */
package logica;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Equipo {

	private String nombre;
	private int numJugadores;
	private String color;
	private String lugar;
	
	/**
	 * Constructor de la clase
	 */
	public Equipo(String nombre, int numJugadores, String color, String lugar) {
		super();
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.color = color;
		this.lugar = lugar;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the numJugadores
	 */
	public int getNumJugadores() {
		return numJugadores;
	}

	/**
	 * @param numJugadores the numJugadores to set
	 */
	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	
	
	
	
}
