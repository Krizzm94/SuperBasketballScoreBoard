package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Falta;
import logica.Torneo;


public class FaltaDao {
	
	private Conexion conexion;
	private FaltaSql faltaSql;
	


public FaltaDao(){
	
 conexion=new Conexion();
 faltaSql=new  FaltaSql();
	
}

public int insertarFalta(Falta falta, int idJugador){
	conexion.conectarBD();
	try{
		int id=falta.getId();

		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(faltaSql.insertarFalta(id, idJugador));

	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	return -1;
}




public ResultSet ConsultarFalta(){
	if (conexion.conectarBD()){
		try{
		Statement sentencia=conexion.getConexion().createStatement();
		return	sentencia.executeQuery(faltaSql.consultarFalta());
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	return null;
}




}
