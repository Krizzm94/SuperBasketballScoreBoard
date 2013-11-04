/**
 * 
 */
package logica;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Jugador {
	
	private int id;
	private int number;
	private Falta[] falta;
	
	
	/**
	 * Constructor de la clase
	 */
	public Jugador(int id, int number, Falta[] falta) {
		super();
		this.id = id;
		this.number = number;
		this.falta = falta;
		falta=new Falta[5];
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}


	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}


	/**
	 * @return the falta
	 */
	public Falta[] getFalta() {
		return falta;
	}


	/**
	 * @param falta the falta to set
	 */
	public void setFalta(Falta[] falta) {
		this.falta = falta;
	}


	
	
	
	
}
