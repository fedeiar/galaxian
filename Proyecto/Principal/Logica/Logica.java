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
	
	
	protected PositionList<Objeto>  listaObjetos;
	
	protected Mapa mapa;
	protected GUI gui; // considerar sacar la GUI , para eso pasar la por parametro para cuando la necesite
	protected Tiempo tiempoLog;
	
	protected int puntaje  , vidasJugador , cantEnemigos; // como hago para saber la cantidad de enemigos si son todos objetos?
														  // como aumento cantEnemigos cada vez que agrego un enemigo, si nose
														  // que tipo de objeto estoy agregando ?
	protected Jugador jugador;
	
	//agregar listas de premios y obstaculos
	
	//constructor
	
	public Logica( GUI g) {
		
		listaObjetos = new ListaDE<Objeto>();
	    puntaje = 0;
	    cantEnemigos = 0;
	    
	    mapa = new Mapa();
	    gui = g;
	    tiempoLog = new Tiempo(this);
	    
	    jugador = new Jugador(mapa.getAncho()/2 , mapa.getAlto() - 70 ); // ver alto y ancho ¿porque si pongo -49 queda al borde?
	    vidasJugador = jugador.getVidas();
	    gui.add(jugador.getLabel());
	}
	
	//metodos
	
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public int cantEnemigos() {
		return cantEnemigos;
	}
	
	public boolean hayEnemigos() {
		return cantEnemigos != 0;
	}
	
	
	public void empezarJuego() {
		tiempoLog.start(); 
	}
	
	public void crearObjetos() {
		listaObjetos = mapa.obtenerObjetosIniciales();
		for( Objeto o : listaObjetos) {
			
			if( o instanceof Enemigo)  //yase que esta mal no me maten pero de que otra forma hago
				cantEnemigos++;
			
			gui.add(o.getLabel());
		}
	}
	
	
	public void moverJugador (int direccion) {
		jugador.accionar(direccion);
	}
	
	public void accionarObjetos() throws EmptyListException{
		if(!listaObjetos.isEmpty()) {
			
			for(Objeto o : listaObjetos) {
				o.accionar(mapa.getAncho());
			}
		}
		else {
			throw new EmptyListException("se intento mover enemigos cuando no quedaba ninguno");
		}
	}
	
	//YASE QUE ESTA RECONTRA MAL PERO SINO NOSE COMO HACER
	
	public void eliminarEnemigo() {
		try {
			for(Position<Objeto> po : listaObjetos.positions())
				if(po.element() instanceof Enemigo) {
					Enemigo e = (Enemigo) po.element();
					puntaje+= e.getPuntaje();
					gui.remove(e.getLabel());
					gui.repaint();
					cantEnemigos--;
					listaObjetos.remove(po);
					break;
				}
		}
		catch(InvalidPositionException e) {
			e.printStackTrace();
		}
	}
}
