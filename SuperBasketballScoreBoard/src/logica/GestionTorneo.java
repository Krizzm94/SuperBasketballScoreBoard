/**
 * 
 */
package logica;

import java.util.ArrayList;

/**
 * @author Wolfran Pinzon
 * 
 */
public class GestionTorneo {
	
	private ArrayList<Torneo> torneos;

	
	
	/**
	 * Constructor de la clase
	 */
	public GestionTorneo() {
		this.torneos = new ArrayList<Torneo>();
	}

	
	/**
	 * metodo para agregar torneos
	 */
	public void agregarTorneo(Torneo torneo) {
		this.torneos.add(torneo);
	}


	
	/**
	 * metodo para buscar torneos
	 */
	public Torneo buscarTorneo(String nombre) {
		for (Torneo tor : this.torneos) {
			if (tor.getNombre().equals(nombre)) {
				return tor;
			}
		}
		return null;
	}


	/**
	 * @return the torneos
	 */
	public ArrayList<Torneo> getTorneos() {
		return torneos;
	}


	/**
	 * @param torneos the torneos to set
	 */
	public void setTorneos(ArrayList<Torneo> torneos) {
		this.torneos = torneos;
	}
	
	
	public String listarTorneos(){
		StringBuffer salida = new StringBuffer();
		for(Torneo torneo : torneos){
			salida.append(torneo+ "\n");
		}
		return salida.toString();
	}
	
	
	

}
