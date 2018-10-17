package Visitors;
import Disparos.*;
import Logica.Logica;
import Personajes.*;

public class VisitorDisparoJugador extends Visitor {

	//atributos
	
	protected DisparoJugador dis;
	protected boolean disparo_inhabilitado; //es necesario ya que si un disparo toca a 2 enemigos a la vez, mata a los 2
	//constructor
	public VisitorDisparoJugador(DisparoJugador d) {
		dis = d;
		disparo_inhabilitado = false;
	}
	
	//metodos

	public void afectarEnemigo(Enemigo e) { //seria el visitarEnemigo(this)
		if(!disparo_inhabilitado) {
			e.quitarHP(dis.getFuerzaImpacto());
			dis.morir(); 
		}
		disparo_inhabilitado = true;
		
	}
}
