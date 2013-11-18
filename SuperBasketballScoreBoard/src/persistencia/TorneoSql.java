package persistencia;

public class TorneoSql {
	private String q="\'";
	
	public TorneoSql(){
		
	}
	
	public String consultarTorneo(){
		return "Select * from torneo";
		
	}
	
		
	public String eliminarTorneo(String nombre){
		String consulta="DELETE FROM torneo WHERE nombre="+q+nombre+q;
		return consulta;
	}
	
	public String insertarTorneo(String nombre,String numeroEquipos){
		String consulta="INSERT INTO torneo VALUES("+q+nombre+q+","+q+numeroEquipos+q+")";
	return consulta;
	
	}
	

	



}
