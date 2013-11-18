package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Torneo;


public class TorneoDao {
	
	private Conexion conexion;
	private TorneoSql torneoSql;
	


public TorneoDao(){
	
 conexion=new Conexion();
 torneoSql=new TorneoSql();
	
}

public int insertarTorneo(Torneo torneo){
	conexion.conectarBD();
	try{
		String nombre=torneo.getNombre();
		String numEquipos=String.valueOf(torneo.getNumEquipos());
	
		
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(torneoSql.insertarTorneo(nombre, numEquipos));

	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	return -1;
}




public int eliminarTorneo(String nombre){
	conexion.conectarBD();
	try{
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(torneoSql.eliminarTorneo(nombre));
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return -1;
}





public ResultSet ConsultarTorneos(){
	if (conexion.conectarBD()){
		try{
		Statement sentencia=conexion.getConexion().createStatement();
		return	sentencia.executeQuery(torneoSql.consultarTorneo());
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	return null;
}




}
