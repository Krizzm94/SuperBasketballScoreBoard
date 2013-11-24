/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Torneo {

	private String nombre;
	private int numEquipos;
	private Equipo[] equipos;
	private ArrayList<Partido> partidos;
	

	/**
	 * Constructor de la clase
	 */
	public Torneo(String nombre, int numEquipos, Equipo[] equipos,
			ArrayList<Partido> partidos) {
		super();
		this.nombre = nombre;
		this.numEquipos = numEquipos;
		this.partidos = new ArrayList();
		this.equipos=new Equipo[12];
	}

	
	/**
	 * metodo agrega equipos al torneo
	 */
	public int agregarEquipo(Equipo equi){
		int secuencia=0;
		for(int i=0;i<equipos.length;i++){
			if(equipos[i]==null){
				equipos[i]=equi;
				secuencia=i;
				i=12;	
			}
		}
		return secuencia;
	}
	
	
	/**
	 * metodo busca equipos
	 */
	public Equipo buscarEquipos(String nombre){
		for (int i=0;i<equipos.length;i++) {
			if (equipos[i].getNombre().equals(nombre)) {
				return equipos[i];
			}
		}
		return null;
		
	}
	
	
	public int contarEquipos(){
		int contador=0;
		for(int i=0;i<equipos.length;i++){
			if(equipos[i]!=null){
				contador++;
			}
		}
		return contador;
	}
	
	/**
	 * metodo para agregar partidos a torneos
	 */
	public void agregarPartido(Partido partido) {
		this.partidos.add(partido);
	}

	
	
	/**
	 * metodo para buscar un partido determinado
	 */
	public Partido buscarNumero(String local, String vist) {
		for (Partido par : this.partidos) {
			if (par.getEquipoLocal().equals(local) && par.getEquipoVisitante().equals(vist)) {
				return par;
			}
		}
		return null;
	}

	
	/**
	 * metodo para eliminar partido
	 */
	public boolean eliminarPartido(Partido par) {
		return this.partidos.remove(par);
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
	 * @return the partidos
	 */
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}


	/**
	 * @param partidos the partidos to set
	 */
	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}


	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Torneo [nombre=" + nombre + ", numEquipos=" + numEquipos
				+ ", equipos=" + Arrays.toString(equipos) + ", partidos="
				+ partidos + "]";
	}


	
	
	
	
	
	
}
