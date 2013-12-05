package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Equipo;
import logica.Torneo;

/**

 * En esta clase gestiona  los datos de los equipos  en la base de datos
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class EquipoDao {
	
	private Conexion conexion;
	private EquipoSql equipoSql;
	


public EquipoDao(){
	
 conexion=new Conexion();
 equipoSql=new EquipoSql();
	
}
/**
 * metodo para ingreso de el equipo a la base de datos 
 */
public int insertarEquipo(Equipo equipo, String torneo){
	conexion.conectarBD();
	try{
		String nombre=equipo.getNombre();
		String numJugadores=String.valueOf(equipo.getNumJugadores());
		String color=equipo.getColor();
		String lugar=equipo.getLugar();
	
		
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(equipoSql.insertarEquipo(nombre, numJugadores,color,lugar,torneo));

	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	return -1;
}



/**
 * metodo para la eliminaion de el equipo a la base de datos 
 */
public int eliminarEquipo(String nombre, String torneo){
	conexion.conectarBD();
	try{
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(equipoSql.eliminarEquipo(nombre, torneo));
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return -1;
}




/**
 * metodo para consultar los  equipo a la base de datos 
 */
public ResultSet ConsultarEquipos(){
	if (conexion.conectarBD()){
		try{
		Statement sentencia=conexion.getConexion().createStatement();
		return	sentencia.executeQuery(equipoSql.consultarEquipo());
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	return null;
}




}
