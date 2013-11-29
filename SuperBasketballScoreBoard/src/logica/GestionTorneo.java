/**
 * 
 */
package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.EquipoDao;
import persistencia.JugadorDao;
import persistencia.PartidoDao;
import persistencia.TorneoDao;

/**
 * @author Wolfran Pinzon
 * 
 */
public class GestionTorneo {
	
	private ArrayList<Torneo> torneos;
	private TorneoDao torneoDao;
	private EquipoDao equipoDao;
	private PartidoDao partidoDao;
	private JugadorDao jugadorDao;
	
	
	/**
	 * Constructor de la clase
	 */
	public GestionTorneo() {
		torneoDao=new TorneoDao();
		equipoDao=new EquipoDao();
		partidoDao=new PartidoDao();
		jugadorDao=new JugadorDao();
		this.torneos = new ArrayList<Torneo>();
		cargarTorneos();
		cargarEquipos();
		cargarJugadores();
		cargarPartidos();
	}

	
	/**
	 * metodo para agregar torneos
	 */
	public void agregarTorneo(Torneo torneo) {
		this.torneos.add(torneo);
	}

	public void eliminarTorneo(String nombre){
		this.torneos.remove(buscarTorneo(nombre));
		torneoDao.eliminarTorneo(nombre);
	}
	

	public void agregarTorneoSql(Torneo torneo){
		torneoDao.insertarTorneo(torneo);
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
	
	
	public void cargarTorneos(){
		ResultSet consulta=torneoDao.ConsultarTorneos();
		try {
			while(consulta.next()){
				String nombre=consulta.getString("nombre");
				int numEquipos=Integer.parseInt(consulta.getString("num_equipos"));
				Torneo torneo=new Torneo(nombre,numEquipos,null,null);
				agregarTorneo(torneo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarEquipos(){
		ResultSet consulta=equipoDao.ConsultarEquipos();
		try {
			while(consulta.next()){
				String nombre=consulta.getString("nombre");
				int numJugadores=Integer.parseInt(consulta.getString("num_jugadores"));
				String color=consulta.getString("color");
				String lugar=consulta.getString("lugar");
				String torneo=consulta.getString("nombre_torneo");
				Torneo tor=buscarTorneo(torneo);
				Equipo equipo=new Equipo(nombre, numJugadores, color, lugar, null);
				tor.agregarEquipo(equipo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cargarJugadores(){
		ResultSet consulta=jugadorDao.ConsultarJugador();
		try {
			while(consulta.next()){
				int id=Integer.parseInt(consulta.getString("id"));
				int numero=Integer.parseInt(consulta.getString("numero"));
				String nomEquipo=consulta.getString("nombre_equipo");
				String nomTorneo=consulta.getString("nombre_torneo");
				Jugador jugador=new Jugador( numero);
				Equipo equi=buscarTorneo(nomTorneo).buscarEquipos(nomEquipo);
				equi.agregarJugador(jugador);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cargarPartidos(){
		ResultSet consulta=partidoDao.ConsultarPartidos();
		try {
			while(consulta.next()){
				String local=consulta.getString("local");
				String visitante=consulta.getString("visitante");
				String fecha=consulta.getString("fecha");
				String hora=consulta.getString("hora");
				String torneo=consulta.getString("nombre_torneo");
				Torneo tor=buscarTorneo(torneo);
				Equipo l=tor.buscarEquipos(local);
				Equipo v=tor.buscarEquipos(visitante);
				Partido partido=new Partido(l, v, fecha, hora); 
				tor.agregarPartido(partido);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public boolean validarNombreTorneo(String nombre){
		if(buscarTorneo(nombre)!=null){
			return true;
		}
		return false;
	}


	public TorneoDao getTorneoDao() {
		return torneoDao;
	}


	public void setTorneoDao(TorneoDao torneoDao) {
		this.torneoDao = torneoDao;
	}


	public EquipoDao getEquipoDao() {
		return equipoDao;
	}


	public void setEquipoDao(EquipoDao equipoDao) {
		this.equipoDao = equipoDao;
	}


	public PartidoDao getPartidoDao() {
		return partidoDao;
	}


	public void setPartidoDao(PartidoDao partidoDao) {
		this.partidoDao = partidoDao;
	}


	public JugadorDao getJugadorDao() {
		return jugadorDao;
	}


	public void setJugadorDao(JugadorDao jugadorDao) {
		this.jugadorDao = jugadorDao;
	}
	
	
	

}
