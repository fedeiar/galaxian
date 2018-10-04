package Visitors;
import Disparos.*;
import Logica.Logica;
import Personajes.*;

public class VisitorDisparoJugador extends Visitor {

	//atributos
	
	protected DisparoJugador dis;
	
	//constructor
	public VisitorDisparoJugador(DisparoJugador d) {
		dis = d;
		
	}
	
	//metodos

	public void afectarEnemigo(Enemigo e) { //seria el visitarEnemigo(this)
		e.quitarHP(dis.getFuerzaImpacto());
		dis.morir(); 
		
	}
}
