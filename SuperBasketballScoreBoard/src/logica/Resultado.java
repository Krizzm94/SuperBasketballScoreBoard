/**
 * 
 */
package logica;

/**

 * En esta clase se crea los atributos de los resultados para cada encuentro 
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class Resultado {
	private String ganador;
	private int punLocal;
	private int punVist;
	private int idPartido;
	/**
	 * Constructor de la clase
	 */
	public Resultado(String ganador, int punLocal, int punVist, int idPartido) {
		super();
		this.ganador = ganador;
		this.punLocal = punLocal;
		this.punVist = punVist;
		this.idPartido = idPartido;
	}
	/**
	 * @return the ganador
	 */
	public String getGanador() {
		return ganador;
	}
	/**
	 * @param ganador the ganador to set
	 */
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	/**
	 * @return the punLocal
	 */
	public int getPunLocal() {
		return punLocal;
	}
	/**
	 * @param punLocal the punLocal to set
	 */
	public void setPunLocal(int punLocal) {
		this.punLocal = punLocal;
	}
	/**
	 * @return the punVist
	 */
	public int getPunVist() {
		return punVist;
	}
	/**
	 * @param punVist the punVist to set
	 */
	public void setPunVist(int punVist) {
		this.punVist = punVist;
	}
	/**
	 * @return the idPartido
	 */
	public int getIdPartido() {
		return idPartido;
	}
	/**
	 * @param idPartido the idPartido to set
	 */
	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resultado [ganador=" + ganador + ", punLocal=" + punLocal
				+ ", punVist=" + punVist + ", idPartido=" + idPartido + "]";
	}

	
	
	

	

}
