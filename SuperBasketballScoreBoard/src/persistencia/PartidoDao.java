package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Partido;
import logica.Torneo;


public class PartidoDao {
	
	private Conexion conexion;
	private PartidoSql partidoSql;
	


public PartidoDao(){
	
 conexion=new Conexion();
 partidoSql=new  PartidoSql();
	
}

public int insertarPartido(Partido partido, String local, String vis, String torneo){
	conexion.conectarBD();
	try{
		String fecha=partido.getFecha();
		String hora=partido.getHora();

		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(partidoSql.insertarPartido(local, vis, fecha, hora, torneo));

	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	return -1;
}




public int eliminarPartido(String local,String visitante,String torneo){
	conexion.conectarBD();
	try{
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(partidoSql.eliminarPartido(local, visitante, torneo));
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return -1;
}





public ResultSet ConsultarPartidos(){
	if (conexion.conectarBD()){
		try{
		Statement sentencia=conexion.getConexion().createStatement();
		return	sentencia.executeQuery(partidoSql.consultarPartido());
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	return null;
}




}
