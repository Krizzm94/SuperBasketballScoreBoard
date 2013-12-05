package persistencia;
/**

 * En esta clase se crea los metodos que administran informacion de los partidos
 

 * @author: Melissa Gutierrez, Cristian Medina, Wolfran Pinzon 
 
 */
public class PartidoSql {
	private String q="\'";
	
	public PartidoSql(){
		
	}
	
	public String consultarPartido(){
		return "Select * from partido";
		
	}
	
		
	public String eliminarPartido(String local,String vis, String torneo){
		String consulta="DELETE FROM partido WHERE local="+q+local+q+"AND visitante="+q+vis+q+"AND nombre_torneo="+q+torneo+q;
		return consulta;
	}
	
	public String insertarPartido(String local,String visitante, String fecha, String hora, String torneo){
		String consulta="INSERT INTO partido VALUES("+q+local+q+","+q+visitante+q+","+q+fecha+q+","+q+hora+q+","+q+torneo+q+")";
	return consulta;
	
	}
	

	



}
