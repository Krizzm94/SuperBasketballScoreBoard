/**
 * 
 */
package logica;

import java.util.Arrays;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Equipo {

	private String nombre;
	private int numJugadores;
	private String color;
	private String lugar;
	private Jugador[] jugador;

	/**
	 * Constructor de la clase
	 */
	public Equipo(String nombre, int numJugadores, String color, String lugar) {
		super();
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.color = color;
		this.lugar = lugar;
		this.jugador=new Jugador[8];
	}


	/**
	 * metodo agrega jugadores a los equipos
	 */
	public int agregarJugador(Jugador j){
		int secuencia=0;
		for(int i=0;i<jugador.length;i++){
			if(jugador[i]==null){
				jugador[i]=j;
				secuencia=i;
				i=8;	
			}
		}
		return secuencia;
	}


	/**
	 * metodo busca jugadores
	 */
	public Jugador buscarJugador(int num){
		for (int i=0;i<jugador.length;i++) {
			if(jugador[i]!= null){
				if (jugador[i].getNumber()==num) {
					return jugador[i];
				}
			}
			else{
				return null;
			}
		}
		return null;

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

	/**
	 * @return the jugador
	 */
	public Jugador[] getJugador() {
		return jugador;
	}

	/**
	 * @param jugador the jugador to set
	 */
	public void setJugador(Jugador[] jugador) {
		this.jugador = jugador;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", numJugadores=" + numJugadores
				+ ", color=" + color + ", lugar=" + lugar + ", jugador="
				+ Arrays.toString(jugador) + "]";
	}





}
