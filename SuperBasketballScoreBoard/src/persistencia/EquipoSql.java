package persistencia;
/**

 * En esta clase se crea los metodos que administran informacion de los equipos
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class EquipoSql {
	private String q="\'";
	
	public EquipoSql(){
		
	}
	
	public String consultarEquipo(){
		return "Select * from equipo";
		
	}
	
		
	public String eliminarEquipo(String nombre, String torneo){
		String consulta="DELETE FROM equipo WHERE nombre="+q+nombre+q+"and nombre_torneo="+q+torneo+q;
		return consulta;
	}
	
	public String insertarEquipo(String nombre,String numeroJugadores,String color, String lugar, String torneo){
		String consulta="INSERT INTO equipo VALUES("+q+nombre+q+","+q+numeroJugadores+q+","+q+color+q+","+q+lugar+q+","+q+torneo+q+")";
	return consulta;
	
	}
	

	



}
