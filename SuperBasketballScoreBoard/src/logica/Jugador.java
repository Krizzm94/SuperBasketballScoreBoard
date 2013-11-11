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
	private Falta[] falta;
	
	
	/**
	 * Constructor de la clase
	 */
	public Jugador(int id, int number, Falta[] falta) {
		super();
		this.id = id;
		this.number = number;
		this.falta=new Falta[5];
	}

	/**
	 * metodo agrega faltas a los jugadores
	 */
	public int agregarFalta(Falta f){
		int secuencia=0;
		for(int i=0;i<falta.length;i++){
			if(falta[i]==null){
				falta[i]=f;
				secuencia=i;
				i=5;	
			}
		}
		return secuencia;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", number=" + number + ", falta="
				+ Arrays.toString(falta) + "]";
	}


	
	
	
	
}
