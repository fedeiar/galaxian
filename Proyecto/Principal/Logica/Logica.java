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
	protected Jugador jugador;
	
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
	    jugador = new Jugador(mapa.getAncho()/2 , mapa.getAlto() - 60 , this); // ver alto y ancho ¿porque si pongo -49 queda al borde?
		
	}
	
	//metodos
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public void mover (int n) {
		jugador.mover(n , mapa.getAncho() );
	}
	
}
