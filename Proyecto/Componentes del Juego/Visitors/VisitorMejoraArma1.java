package Visitors;

import Logica.Logica;
import Personajes.Jugador;
import Premios.*;
import Armas.*;
public class VisitorMejoraArma1 extends Visitor{

	//atributos
	
	MejoraArma1 MJ;
	
	
	//constructor
	
	public VisitorMejoraArma1(MejoraArma1 M) {
		MJ = M;
		
	}
	
	//metodos
	
	public void afectarJugador(Jugador j) {
		Arma a = j.getArma();
		
		a.setVelocidadDisparo(a.getVelocidadDisparo() + 10);
		MJ.morir();
	}

}
