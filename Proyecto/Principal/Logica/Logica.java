package Logica;
import TDALista.*;
import ObjetosDelJuego.*;
import Personajes.*;

import Mapas.*;

import java.util.Random;

import EnemigosConcretos.EnemigoConArma;
import Grafica.*;

public class Logica {

	//atributos
	
	protected PositionList<Enemigo> listaEnemigo;
	protected PositionList<Disparo> listaDisparo;
	
	protected Mapa mapa;
	protected GUI gui; // considerar sacar la GUI , para eso pasar la por parametro para cuando la necesite
	
	protected int puntaje  , vidasJugador ; //enemigos actuales removida, se puede saber con listaEnemigo.size()
	protected Jugador jugador;
	
	//agregar listas de premios y obstaculos
	
	//constructor
	
	public Logica( GUI g) {
		
		listaEnemigo = new ListaDE<Enemigo>();
		listaDisparo = new ListaDE<Disparo>();
	    puntaje = 0;
	    
	    mapa = new Mapa();
	    gui = g;
	    
	    jugador = new Jugador(mapa.getAncho()/2 , mapa.getAlto() - 60 ); // ver alto y ancho ¿porque si pongo -49 queda al borde?
	    vidasJugador = jugador.getVidas();
	    gui.add(jugador.getLabel());
	}
	
	//metodos
	
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public boolean hayEnemigos() {
		return !listaEnemigo.isEmpty();
	}
	
	public void moverJugador (int n) {
		jugador.mover(n , mapa.getAncho() );
	}
	
	public void moverBloqueEne() throws EmptyListException{
		if(!listaEnemigo.isEmpty()) {
			Random ran = new Random();
			int mov = ran.nextInt(2);
			for(Enemigo e : listaEnemigo) {
				e.mover(mov, mapa.getAncho());
			}
		}
		else {
			throw new EmptyListException("se intento mover enemigos cuando no quedaba ninguno");
		}
	}
	
	public void EmpezarJuego() {
		crearEnemigos();
		//podría ir un crear obstaculos
	}
	
	
	public void crearEnemigos() {
		listaEnemigo = mapa.obtenerEnemigos();
		for( Enemigo e : listaEnemigo) {
			gui.add(e.getLabel());
		}
	}
	
	
}
