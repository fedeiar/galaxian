package Visitors;

import Logica.Logica;
import Personajes.Jugador;
import Premios.*;

public class VisitorMejoraArma1 extends Visitor{

	//atributos
	
	MejoraArma1 MJ;
	
	
	//constructor
	
	public VisitorMejoraArma1(MejoraArma1 M) {
		MJ = M;
		
	}
	
	//metodos
	
	public void afectarJugador(Jugador j) {
		j.setVelocidadDisparo(j.getVelocidadDisparo() + MJ.getModificadorVelocidadDisparo());
		MJ.morir();
	}

}
