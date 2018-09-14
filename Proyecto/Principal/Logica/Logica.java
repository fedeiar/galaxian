package Logica;
import TDALista.*;
import ObjetosDelJuego.*;
import Personajes.*;

import Mapas.*;
import Grafica.*;

public class Logica {

	//atributos
	
	protected PositionList<Enemigo> listaEnemigo;
	protected PositionList<Disparo> listaDisparo;
	
	protected Mapa mapa;
	protected GUI gui; // considerar sacar la GUI , para eso pasar la por parametro para cuando la necesite
	
	protected int puntaje , enemigosActuales , vidasJugador ;
	protected Jugador jugador;
	
	//agregar listas de premios y obstaculos
	
	//constructor
	
	public Logica(Mapa m , GUI g) {
		
		listaEnemigo = new ListaDE<Enemigo>();
		listaDisparo = new ListaDE<Disparo>();
	    puntaje = 0;
	    enemigosActuales = 0;
	    mapa = m;
	    gui = g;
	    jugador = new Jugador(mapa.getAncho()/2 , mapa.getAlto() - 60 , this); // ver alto y ancho ¿porque si pongo -49 queda al borde?
	    vidasJugador = jugador.getVidas();
	}
	
	//metodos
	
	public Jugador getJugador() {
		return jugador;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void mover (int n) {
		jugador.mover(n , mapa.getAncho() );
	}
	
	public void crearEnemigosConArma(int n) {
		for(int i = 0 ; i<n ; i++) {
			Enemigo ene = new EnemigoConArma(25 + i*100 , 100 , this ,1);
			gui.getContentPane().add(ene.getLabel());
			listaEnemigo.addLast(ene);
		}
	}
	
	
}
