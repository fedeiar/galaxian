package Visitors;
import Disparos.*;
import Logica.Logica;
import Personajes.*;

public class VisitorDisparoJugador extends Visitor {

	//atributos
	
	protected Disparo dis;
	
	//constructor
	public VisitorDisparoJugador(Logica l ,Disparo d) {
		super(l);
		dis = d;
		
	}
	
	//metodos
	
	public void afectarEnemigo(Enemigo e) { //seria el visitarEnemigo(this)
		e.quitarHP(dis.getFuerzaImpacto());
		log.eliminarObjeto(dis);
		
		System.out.println("entre al visitorDisparoJugador");
	}
}
