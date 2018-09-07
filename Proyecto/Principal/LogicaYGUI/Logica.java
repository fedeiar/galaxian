package LogicaYGUI;
import TDALista.*;
import ClasesGeneralesEnArbolHerencia.*;
import EnemigosYJugador.*;

public class Logica {

	//atributos
	
	PositionList<Objeto> L;
	Jugador player;
	
	//constructor
	
	public Logica() {
		L = new ListaDE<Objeto>();
		player = new Jugador (2 , 10 , 5);
		
		
	}
	
	//metodos
	
	/**
	 * Desplaza al personaje X posiciones en horizontal e Y posiciones en vertical 
	 * @param x
	 * @param y
	 */
	
	public void desplazar(int x , int y) {
		// la GUI debe encargarse de que el jugador no se salga de los limites,
		// ya que la GUI sera quien contenga los atributos del ancho y alto del frame.
		player.ubicarObjeto(player.getPosicion().getx() + x, player.getPosicion().gety() + y);
	}
}
