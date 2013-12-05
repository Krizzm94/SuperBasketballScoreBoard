/**
 * 
 */
package logica;

import java.util.Arrays;

/**

 * En esta clase se crea los atributos de los jugadores 
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
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


	@Override
	public String toString() {
		return "Jugador [id=" + id + ", number=" + number + "]";
	}

	


	
	
	
	
}
