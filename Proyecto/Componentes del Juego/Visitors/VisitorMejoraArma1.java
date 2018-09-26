package Visitors;

import Logica.Logica;
import Personajes.Jugador;
import Premios.*;

public class VisitorMejoraArma1 extends Visitor{

	//atributos
	
	MejoraArma1 MJ;
	
	
	//constructor
	
	public VisitorMejoraArma1(Logica l , MejoraArma1 M) {
		super(l);
		MJ = M;
		
	}
	
	//metodos
	
	public void afectarJugador(Jugador j) {
		j.setVelocidadDisparo(j.getVelocidadDisparo() + MJ.getModificadorVelocidadDisparo());
		log.eliminarObjeto(MJ);
	}

}
