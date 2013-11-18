package persistencia;

public class JugadorSql {
	private String q="\'";
	
	public JugadorSql(){
		
	}
	
	public String consultarJugador(){
		return "Select * from jugador";
		
	}
	
		
	public String eliminarJugador(int id){
		String consulta="DELETE FROM jugador WHERE id="+q+id+q;
		return consulta;
	}
	
	public String insertarJugador(int numero,String equipo){
		String consulta="INSERT INTO jugador VALUES("+q+q+","+q+numero+q+","+q+equipo+q+")";
	return consulta;
	
	}
	

	



}
