package Logica;
import TDALista.*;
import ObjetosDelJuego.*;
import Personajes.*;
import Disparo.*;
import Mapas.*;
import Grafica.*;

public class Logica {

	//atributos
	
	protected PositionList<Enemigo> listaEnemigo;
	protected PositionList<Disparo> listaDisparo;
	protected Mapa mapa;
	protected GUI gui;
	protected int puntaje , enemigosActuales , vidasJugador ;
	protected Jugador player;
	
	//agregar listas de premios y obstaculos
	
	//constructor
	
	public Logica(Mapa m , GUI g) {
		listaEnemigo = new ListaDE<Enemigo>();
		listaDisparo = new ListaDE<Disparo>();
	    puntaje = 0;
	    enemigosActuales = 0;
	    vidasJugador = 1;
	    mapa = m;
	    gui = g;
	    
		
		
	}
	
	//metodos
	
	
}
