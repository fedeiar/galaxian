package Visitors;

import Logica.Logica;
import Personajes.*;
public abstract class Visitor {

	//atributos
	
	
	
	//constructor
	
	public Visitor() {
		
	}
	
	//metodos
	
	public void afectarEnemigo(Enemigo e) {}
	
	public void afectarJugador(Jugador j) {}
}
