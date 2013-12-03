package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Equipo;
import logica.Torneo;


public class EquipoDao {
	
	private Conexion conexion;
	private EquipoSql equipoSql;
	


public EquipoDao(){
	
 conexion=new Conexion();
 equipoSql=new EquipoSql();
	
}

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
