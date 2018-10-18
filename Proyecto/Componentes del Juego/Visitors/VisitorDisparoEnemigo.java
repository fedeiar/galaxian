package Visitors;

import Disparos.*;
import Personajes.Jugador;

public class VisitorDisparoEnemigo extends Visitor {

	//atributos
	
	protected DisparoEnemigo DE;
	
	//constructor
	
	public VisitorDisparoEnemigo(DisparoEnemigo D) {
		DE = D;
	}
	
	//metodos
	
	public void afectarJugador(Jugador j) {
		j.quitarHP(DE.getFuerzaImpacto());
		DE.morir();
	}
}
