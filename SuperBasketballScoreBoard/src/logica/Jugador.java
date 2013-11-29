/**
 * 
 */
package logica;

import java.util.Arrays;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Jugador {
	
	private int id;
	private int number;
	
	
	/**
	 * Constructor de la clase
	 */
	public Jugador( int number) {
		super();
		this.number = number;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	@Override
	public String toString() {
		return "Jugador [id=" + id + ", number=" + number + "]";
	}

	


	
	
	
	
}
