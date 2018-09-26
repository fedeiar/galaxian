package Visitors;
import Disparos.*;
import Logica.Logica;
import Personajes.*;

public class VisitorDisparoJugador extends Visitor {

	//atributos
	
	protected DisparoJugador dis;
	
	//constructor
	public VisitorDisparoJugador(Logica l ,DisparoJugador d) {
		super(l);
		dis = d;
		
	}
	
	//metodos
	
	public void afectarEnemigo(Enemigo e) { //seria el visitarEnemigo(this)
		e.quitarHP(dis.getFuerzaImpacto());
		log.eliminarObjeto(dis); //por esto es necesario la logica
		
		System.out.println("entre al visitorDisparoJugador (yay)");
	}
}
