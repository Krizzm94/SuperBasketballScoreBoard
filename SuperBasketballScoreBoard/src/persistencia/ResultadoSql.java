package persistencia;

public class ResultadoSql {
	private String q="\'";
	
	public ResultadoSql(){
		
	}
	
	public String consultarResultado(){
		return "Select * from resultado";
		
	}
	
		
	public String eliminarResultado(String partido){
		String consulta="DELETE FROM resultado WHERE nombre="+q+partido+q;
		return consulta;
	}
	
	public String insertarResultado(String ganador, String local, String vist,String partido,String torneo){
		String consulta="INSERT INTO resultado VALUES("+q+ganador+q+","+q+local+q+","+q+vist+q+","+q+partido+q+","+q+torneo+q+")";
	return consulta;
	
	}
	

	



}
