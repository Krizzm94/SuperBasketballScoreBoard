/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.Arrays;

/**

 * En esta clase se crea los atributos de los torneos y la administracion de algunos arreglos 
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class Torneo {

	private String nombre;
	private int numEquipos;
	private ArrayList<Equipo> equipos;
	private ArrayList<Partido> partidos;
	private ArrayList<Resultado> resultados;
	

	/**
	 * Constructor de la clase
	 */
	public Torneo(String nombre, int numEquipos, ArrayList<Equipo> equipos,
			ArrayList<Partido> partidos) {
		super();
		this.nombre = nombre;
		this.numEquipos = numEquipos;
		this.partidos = new ArrayList();
		this.equipos=new ArrayList<>();
		this.resultados=new ArrayList<>();
	}

	
	/**
	 * metodo agrega equipos al torneo
	 */
	public void agregarEquipo(Equipo equi){
		this.equipos.add(equi);
	}
	
	
	/**
	 * metodo busca equipos
	 */
	public Equipo buscarEquipo(String nombre) {
		for (Equipo equi : this.equipos) {
			if (equi.getNombre().equals(nombre)) {
				return equi;
			}
		}
		return null;
	}
	
	
	public void eliminarEquipo(String equipo){
			this.equipos.remove(buscarEquipo(equipo));
	}
	
	public int contarEquipos(){
		int contador=0;
		for(int i=0;i<equipos.size();i++){
			if(equipos.get(i)!=null){
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
	 * metodo para agregar resultados a torneos
	 */
	public void agregarResultado(Resultado resultado) {
		this.resultados.add(resultado);
	}
	
	
	
	/**
	 * metodo para buscar un resultado determinado
	 */
	public Resultado buscarResultado(int id) {
		for (Resultado res : this.resultados) {
			if (res.getIdPartido()==id) {
				return res;
			}
		}
		return null;
	}

	
	
	/**
	 * metodo para buscar un partido determinado
	 */
	public Partido buscarPartido(String local, String vist) {
		for (Partido par : this.partidos) {
			if (par.getEquipoLocal().getNombre().equals(local) && par.getEquipoVisitante().getNombre().equals(vist)) {
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
	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}


	/**
	 * @param equipos the equipos to set
	 */
	public void setEquipos(ArrayList<Equipo> equipos) {
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


	/**
	 * @return the resultados
	 */
	public ArrayList<Resultado> getResultados() {
		return resultados;
	}


	/**
	 * @param resultados the resultados to set
	 */
	public void setResultados(ArrayList<Resultado> resultados) {
		this.resultados = resultados;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Torneo [nombre=" + nombre + ", numEquipos=" + numEquipos
				+ ", equipos=" + equipos + ", partidos=" + partidos
				+ ", resultados=" + resultados + "]";
	}


	


	
	
	
	
	
	
}
