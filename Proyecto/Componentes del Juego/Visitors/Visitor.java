package Visitors;

import Logica.Logica;
import Personajes.*;
public abstract class Visitor {

	//atributos
	
	 //preguntar, no respeta el patron al 100% pero hace falta para eliminar por ejemplo el disparo.
	
	//constructor
	
	public Visitor() {
		
	}
	
	//metodos
	
	public void afectarEnemigo(Enemigo e) {}
	
	public void afectarJugador(Jugador j) {}
}
