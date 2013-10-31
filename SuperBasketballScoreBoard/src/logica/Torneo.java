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
	private Equipo[] equipos;
	private Partido partido;
	

	/**
	 * Constructor de la clase
	 */
	public Torneo(String nombre, int numEquipos, Equipo[] equipos, Partido partido) {
		super();
		this.nombre = nombre;
		this.numEquipos = numEquipos;
		this.equipos = equipos;
		this.equipos= new Equipo[12];
		this.partido=partido;
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


	/**
	 * @return the equipos
	 */
	public Equipo[] getEquipos() {
		return equipos;
	}


	/**
	 * @param equipos the equipos to set
	 */
	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}


	/**
	 * @return the partido
	 */
	public Partido getPartido() {
		return partido;
	}


	/**
	 * @param partido the partido to set
	 */
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	
	
	
	
}
