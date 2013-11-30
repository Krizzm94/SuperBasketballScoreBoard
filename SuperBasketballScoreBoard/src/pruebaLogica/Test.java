/**
 * 
 */
package pruebaLogica;

import logica.Equipo;
import logica.GestionTorneo;
import logica.Jugador;
import logica.Partido;
import logica.Torneo;

/**
 * @author Wolfran Pinzon
 * 
 */
public class Test {

	public static void main(String[] args) {
		GestionTorneo gestion = new GestionTorneo();
		
		/*crear torneos*/
		gestion.agregarTorneo(new Torneo("uptc", 4, null, null));
		gestion.agregarTorneo(new Torneo("sogamoso", 6, null, null));
		gestion.agregarTorneo(new Torneo("duitama", 12, null, null));
		
		/*crear equipos*/
		Equipo equipo=new Equipo("lakers", 8, "Azul", "sogamoso");
		Equipo equipo1=new Equipo("bulls", 8, "rojo", "sogamoso");
		Equipo equipo2=new Equipo("uptc", 8, "amarillo", "sogamoso");
		Equipo equipo3=new Equipo("miami", 8, "blanco", "sogamoso");
		Equipo equipo4=new Equipo("invensibles", 8, "negro", "sogamoso");
		Equipo equipo5=new Equipo("duitama", 8, "verde", "duitama");
		
		/*crear jugadores*/
		Jugador jugador1=new Jugador( 1);
		Jugador jugador2=new Jugador( 2);
		Jugador jugador3=new Jugador( 3);
		Jugador jugador4=new Jugador( 4);
		Jugador jugador5=new Jugador( 5);
		Jugador jugador6=new Jugador( 6);
		Jugador jugador7=new Jugador( 7);
		Jugador jugador8=new Jugador( 8);
		
		/*agregar equipos*/
		gestion.getTorneos().get(0).agregarEquipo(equipo);
		gestion.getTorneos().get(0).agregarEquipo(equipo1);
		gestion.getTorneos().get(0).agregarEquipo(equipo2);
		gestion.getTorneos().get(0).agregarEquipo(equipo3);
		
		gestion.getTorneos().get(1).agregarEquipo(equipo);
		gestion.getTorneos().get(1).agregarEquipo(equipo3);
		gestion.getTorneos().get(1).agregarEquipo(equipo5);
		
		gestion.getTorneos().get(2).agregarEquipo(equipo);
		gestion.getTorneos().get(2).agregarEquipo(equipo1);
		gestion.getTorneos().get(2).agregarEquipo(equipo2);
		gestion.getTorneos().get(2).agregarEquipo(equipo3);
		gestion.getTorneos().get(2).agregarEquipo(equipo4);
		gestion.getTorneos().get(2).agregarEquipo(equipo5);

		/*agregar jugadores*/
		gestion.getTorneos().get(0).getEquipos()[0].agregarJugador(jugador1);
		gestion.getTorneos().get(0).getEquipos()[0].agregarJugador(jugador2);
		gestion.getTorneos().get(0).getEquipos()[0].agregarJugador(jugador3);
		gestion.getTorneos().get(0).getEquipos()[0].agregarJugador(jugador4);
		gestion.getTorneos().get(0).getEquipos()[0].agregarJugador(jugador5);
		gestion.getTorneos().get(0).getEquipos()[0].agregarJugador(jugador6);
		
		gestion.getTorneos().get(0).getEquipos()[1].agregarJugador(jugador1);
		gestion.getTorneos().get(0).getEquipos()[1].agregarJugador(jugador2);
		gestion.getTorneos().get(0).getEquipos()[1].agregarJugador(jugador3);
		gestion.getTorneos().get(0).getEquipos()[1].agregarJugador(jugador4);
		gestion.getTorneos().get(0).getEquipos()[1].agregarJugador(jugador5);
		gestion.getTorneos().get(0).getEquipos()[1].agregarJugador(jugador6);
		gestion.getTorneos().get(0).getEquipos()[1].agregarJugador(jugador7);
		gestion.getTorneos().get(0).getEquipos()[1].agregarJugador(jugador8);
		
		gestion.getTorneos().get(1).getEquipos()[0].agregarJugador(jugador1);
		gestion.getTorneos().get(1).getEquipos()[0].agregarJugador(jugador2);
		gestion.getTorneos().get(1).getEquipos()[0].agregarJugador(jugador3);
		gestion.getTorneos().get(1).getEquipos()[0].agregarJugador(jugador4);
		gestion.getTorneos().get(1).getEquipos()[0].agregarJugador(jugador5);
		gestion.getTorneos().get(1).getEquipos()[0].agregarJugador(jugador6);
		
		gestion.getTorneos().get(2).getEquipos()[1].agregarJugador(jugador1);
		gestion.getTorneos().get(2).getEquipos()[1].agregarJugador(jugador2);
		gestion.getTorneos().get(2).getEquipos()[1].agregarJugador(jugador3);
		gestion.getTorneos().get(2).getEquipos()[1].agregarJugador(jugador4);
		gestion.getTorneos().get(2).getEquipos()[1].agregarJugador(jugador5);
		gestion.getTorneos().get(2).getEquipos()[1].agregarJugador(jugador6);
		gestion.getTorneos().get(2).getEquipos()[1].agregarJugador(jugador7);
		gestion.getTorneos().get(2).getEquipos()[1].agregarJugador(jugador8);
		
		/*crear partidos*/
		Partido partido1=new Partido(equipo2, equipo5, "20 dic", "20:00");
		Partido partido2=new Partido(equipo1, equipo, "20 dic", "20:00");
		Partido partido3=new Partido(equipo4, equipo3, "20 dic", "20:00");
		
		/*agregar partidos*/
		gestion.getTorneos().get(2).agregarPartido(partido1);
		gestion.getTorneos().get(0).agregarPartido(partido2);
		gestion.getTorneos().get(2).agregarPartido(partido3);
		
		
		/*listar informacion*/
		System.out.println(gestion.listarTorneos());
		 
		
	}
	
	
}
