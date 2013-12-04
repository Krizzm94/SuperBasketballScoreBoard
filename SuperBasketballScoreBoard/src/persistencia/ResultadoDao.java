package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import logica.Resultado;
import logica.Torneo;


public class ResultadoDao {
	
	private Conexion conexion;
	private ResultadoSql resultadoSql;
	


public ResultadoDao(){
	
 conexion=new Conexion();
 resultadoSql=new ResultadoSql();
	
}

public int insertarResultado(String torneo,Resultado resul){
	conexion.conectarBD();
	try{
		String ganador=resul.getGanador();
		String pLocal=String.valueOf(resul.getPunLocal());
		String pVist=String.valueOf(resul.getPunVist());
		String partido=String.valueOf(resul.getIdPartido());
	
		
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(resultadoSql.insertarResultado(ganador, pLocal, pVist, partido,torneo));

	}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	return -1;
}




public int eliminarResultado(String partido){
	conexion.conectarBD();
	try{
		Statement sentencia=conexion.getConexion().createStatement();
		return sentencia.executeUpdate(resultadoSql.eliminarResultado(partido));
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	}
	return -1;
}





public ResultSet Consultar(){
	if (conexion.conectarBD()){
		try{
		Statement sentencia=conexion.getConexion().createStatement();
		return	sentencia.executeQuery(resultadoSql.consultarResultado());
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	return null;
}




}
