package persistencia;

/**
 * @author Cristhian Camilo Medina Solano
 *
 */
public class JugadorSql {
	private String q="\'";

	public JugadorSql(){

	}

	public String consultarJugador(){
		return "Select * from torneo";

	}


	public String eliminarJugador(String id){
		String consulta="DELETE FROM torneo WHERE nombre="+q+id+q;
		return consulta;
	}

	public String insertarJugador(String id,String numero,String equipo, String torneo){
		String consulta="INSERT INTO torneo VALUES("+q+id+q+","+q+numero+q+")";
		return consulta;

	}






}
