package Visitors;

import Logica.Logica;
import Obstaculos.Obstaculo;
import Personajes.*;
public abstract class Visitor {

	//atributos
	
	
	
	//constructor
	
	public Visitor() {
		
	}
	
	//metodos
	
	public void afectarEnemigo(Enemigo e) {}
	
	public void afectarJugador(Jugador j) {}
	
	public void afectarObstaculo (Obstaculo o) {}
	
	
}
