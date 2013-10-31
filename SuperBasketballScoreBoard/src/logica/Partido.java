/**
 * 
 */
package logica;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Partido {

	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private String fecha;
	private String hora;
	
	
	/**
	 * Constructor de la clase
	 */
	public Partido(Equipo equipoLocal, Equipo equipoVisitante, String fecha,
			String hora) {
		super();
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
		this.hora = hora;
	}


	/**
	 * @return the equipoLocal
	 */
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}


	/**
	 * @param equipoLocal the equipoLocal to set
	 */
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}


	/**
	 * @return the equipoVisitante
	 */
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}


	/**
	 * @param equipoVisitante the equipoVisitante to set
	 */
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}


	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}


	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}


	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
}
