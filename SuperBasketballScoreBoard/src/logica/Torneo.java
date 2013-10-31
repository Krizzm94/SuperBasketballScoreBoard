/**
 * 
 */
package logica;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Torneo {

	private String nombre;
	private int numEquipos;
	
	
	/**
	 * Constructor de la clase
	 */
	public Torneo(String nombre, int numEquipos) {
		super();
		this.nombre = nombre;
		this.numEquipos = numEquipos;
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
	 * @return the numEquipos
	 */
	public int getNumEquipos() {
		return numEquipos;
	}


	/**
	 * @param numEquipos the numEquipos to set
	 */
	public void setNumEquipos(int numEquipos) {
		this.numEquipos = numEquipos;
	}
	
	
	
	
	
}
