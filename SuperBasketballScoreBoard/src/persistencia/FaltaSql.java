package persistencia;

public class FaltaSql {
	private String q="\'";
	
	public FaltaSql(){
		
	}
	
	public String consultarFalta(){
		return "Select * from falta";
		
	}
	
	
	public String insertarFalta(int id, int idJugador_){
		String consulta="INSERT INTO falta VALUES("+q+id+q+","+q+idJugador_+q+")";
	return consulta;
	
	}
	

	



}
