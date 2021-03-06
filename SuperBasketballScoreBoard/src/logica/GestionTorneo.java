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
import persistencia.ResultadoDao;
import persistencia.ResultadoSql;
import persistencia.TorneoDao;

/**

 * Esta clase administra los metodos para el ingreso y modificacion de los datos de las clase de la logica 
 * y comunica las intancial de esta a la interfaz
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class GestionTorneo {
	
	private ArrayList<Torneo> torneos;
	private TorneoDao torneoDao;
	private EquipoDao equipoDao;
	private PartidoDao partidoDao;
	private JugadorDao jugadorDao;
	private ResultadoDao resultadoDao;
	
	/**
	 * Constructor de la clase
	 */
	public GestionTorneo() {
		torneoDao=new TorneoDao();
		equipoDao=new EquipoDao();
		partidoDao=new PartidoDao();
		jugadorDao=new JugadorDao();
		resultadoDao=new ResultadoDao();
		this.torneos = new ArrayList<Torneo>();
		cargarTorneos();
		cargarEquipos();
		cargarJugadores();
//		cargarPartidosSql();
		cargarPartidos();
		cargarResultados();
	}

	
	/**
	 * metodo para agregar torneos
	 */
	public void agregarTorneo(Torneo torneo) {
		this.torneos.add(torneo);
	}
	/**
	 * metodo para eliminar torneos
	 */
	public void eliminarTorneo(String nombre){
		this.torneos.remove(buscarTorneo(nombre));
		torneoDao.eliminarTorneo(nombre);
	}
	/**
	 * metodo para agregar torneos a la tabla Torneo de la  base de datos
	 */

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
				Torneo torneo=new Torneo(nombre,numEquipos, null, null);
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
				Equipo equipo=new Equipo(nombre, numJugadores, color, lugar);
				tor.agregarEquipo(equipo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void cargarResultados(){
		ResultSet consulta=resultadoDao.Consultar();
		try {
			while(consulta.next()){
				String ganador=consulta.getString("ganador");
				int pLocal=Integer.parseInt(consulta.getString("pun_local"));
				int pVist=Integer.parseInt(consulta.getString("pun_vist"));
				int idPartido=Integer.parseInt(consulta.getString("id_partido"));
				String torneo=consulta.getString("nombre_torneo");
				Torneo tor=buscarTorneo(torneo);
				Resultado resultado=new Resultado(ganador, pLocal, pVist, idPartido);
				tor.agregarResultado(resultado);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * metodo para agregar equipos a la tabla Equipo de la  base de datos
	 */
	
	public void agregarEquipoSql(Equipo equipo,String torneo){
		equipoDao.insertarEquipo(equipo, torneo);
	}
	
	/**
	 * metodo para eliminar equipos a la tabla Equipo de la  base de datos
	 */
	public void eliminarEquipoSql(String nombre,String torneo){
		
		equipoDao.eliminarEquipo(nombre,torneo);
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
				Equipo equi=buscarTorneo(nomTorneo).buscarEquipo(nomEquipo);
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
				int id=Integer.parseInt(consulta.getString("id"));
				String local=consulta.getString("local");
				String visitante=consulta.getString("visitante");
				String fecha=consulta.getString("fecha");
				String hora=consulta.getString("hora");
				String torneo=consulta.getString("nombre_torneo");
				Torneo tor=buscarTorneo(torneo);
				Equipo l=tor.buscarEquipo(local);
				Equipo v=tor.buscarEquipo(visitante);
				Partido partido=new Partido(id,l, v, fecha, hora); 
				tor.agregarPartido(partido);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void cargarPartidosSql() {
		String local="";
		String vis="";
		for(int i=0;i<torneos.size();i++) {
			if(torneos.get(i).contarEquipos()==torneos.get(i).getNumEquipos()){
				for(int c=0;c<torneos.get(i).getEquipos().size();c++) {
					if(local.equals("") && vis.equals("")) {
					local=torneos.get(i).getEquipos().get(c).getNombre();
					vis=torneos.get(i).getEquipos().get(c+1).getNombre();
					partidoDao.insertarPartido(local, vis, (c+1)+"/dic/2013", (c+14)+":00", torneos.get(i).getNombre());
					c=c+2;
					local="";
					vis="";
					}
					
				}
			}
		}
	}
	
	
	/**
	 * metodo para validar el nombre de un torneo
	 */
	public boolean validarNombreTorneo(String nombre){
		if(buscarTorneo(nombre)!=null){
			return true;
		}
		return false;
	}

	/**
	 * metodo para validar el nombre de un Equipo
	 */
	public boolean validarEquipo(String torneo,String equipo){
		if(buscarTorneo(torneo).buscarEquipo(equipo)!=null){
			return true;
		}
		return false;
	}
	
	
	

	/**
	 * @return the resultadoDao
	 */
	public ResultadoDao getResultadoDao() {
		return resultadoDao;
	}


	/**
	 * @param resultadoDao the resultadoDao to set
	 */
	public void setResultadoDao(ResultadoDao resultadoDao) {
		this.resultadoDao = resultadoDao;
	}

	/**
	 * @return the torneoDao
	 */
	public TorneoDao getTorneoDao() {
		return torneoDao;
	}

	/**
	 * @param torneoDao the torneoDao to set
	 */
	public void setTorneoDao(TorneoDao torneoDao) {
		this.torneoDao = torneoDao;
	}

	/**
	 * @return the equipoDao
	 */
	public EquipoDao getEquipoDao() {
		return equipoDao;
	}

	/**
	 * @param equipoDao the equipoDao to set
	 */
	public void setEquipoDao(EquipoDao equipoDao) {
		this.equipoDao = equipoDao;
	}

	/**
	 * @return the partidoDao
	 */
	public PartidoDao getPartidoDao() {
		return partidoDao;
	}

	/**
	 * @param partidoDao the partidoDao to set
	 */
	public void setPartidoDao(PartidoDao partidoDao) {
		this.partidoDao = partidoDao;
	}

	/**
	 * @return the jugadorDao
	 */
	public JugadorDao getJugadorDao() {
		return jugadorDao;
	}

	/**
	 * @param jugadorDao the jugadorDao to set
	 */
	public void setJugadorDao(JugadorDao jugadorDao) {
		this.jugadorDao = jugadorDao;
	}
	
	
	

}
