package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Jugador;
import logica.Torneo;

/**

 * En esta clase gestiona  los datos de los jugadores  en la base de datos
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class JugadorDao {
	
	private Conexion conexion;
	private JugadorSql jugadorSql;
	


public JugadorDao(){
	
 conexion=new Conexion();
 jugadorSql=new JugadorSql();
	
}
/**
 * metodo para ingreso de el jugador a la base de datos 
 */
public int insertarJugador(Jugador jugador, String equipo,String torneo){
	conexion.conectarBD();
	try{
		int id=jugador.getId();
		int numero=jugador.getNumber();
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(jugadorSql.insertarJugador(id,numero, equipo,torneo));
	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	return -1;
}


/**
 * metodo para la eliminaion de el jugador a la base de datos 
 */

public int eliminarJugador(int id){
	conexion.conectarBD();
	try{
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(jugadorSql.eliminarJugador(id));
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return -1;
}



/**
 * metodo para consultar los  jugador a la base de datos 
 */

public ResultSet ConsultarJugador(){
	if (conexion.conectarBD()){
		try{
		Statement sentencia=conexion.getConexion().createStatement();
		return	sentencia.executeQuery(jugadorSql.consultarJugador());
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	return null;
}




}
