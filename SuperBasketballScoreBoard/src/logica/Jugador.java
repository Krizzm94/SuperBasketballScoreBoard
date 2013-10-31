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
	private Falta[] foul;
	
	
	/**
	 * Constructor de la clase
	 */
	public Jugador(int id, int number, Falta[] foul) {
		super();
		this.id = id;
		this.number = number;
		this.foul = foul;
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
	 * @return the foul
	 */
	public Falta[] getFoul() {
		return foul;
	}


	/**
	 * @param foul the foul to set
	 */
	public void setFoul(Falta[] foul) {
		this.foul = foul;
	}
	
	
	
	
	
}
