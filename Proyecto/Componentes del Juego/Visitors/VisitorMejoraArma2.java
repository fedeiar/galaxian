package Visitors;
import Premios.*;
import Personajes.*;
import Armas.*;
public class VisitorMejoraArma2 extends Visitor{

	//atributos
	
	MejoraArma2 MJ;
	
	//constructor
	
	public VisitorMejoraArma2(MejoraArma2 M) {
		MJ = M;
	}
	
	//atributos
	
	public void afectarJugador(Jugador j) {
		ArmaJugador old = j.getArma();
		ArmaJugador nueva = MJ.getArma();
		
		nueva.setVelocidadDisparo(old.getVelocidadDisparo());
		nueva.setFuerzaDisparo(old.getFuerzaDisparo());
		
		j.setArma(nueva);
		
		MJ.morir();
	}
}
