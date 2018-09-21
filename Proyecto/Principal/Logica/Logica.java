package Logica;
import TDALista.*;
import Personajes.*;

import Mapas.*;
import ObjetoGeneral.*;

import java.util.Random;

import EnemigosConcretos.EnemigoConArma;
import Grafica.*;

public class Logica {

	//atributos
	
	
	protected PositionList<Objeto>  listaObjetos;
	
	protected Mapa mapa;
	protected GUI gui; // considerar sacar la GUI , para eso pasar la por parametro para cuando la necesite
	protected Tiempo tiempoLog;
	
	protected int puntaje  , vidasJugador , cantEnemigos; 
	
	protected Jugador jugador;
	
	//agregar listas de premios y obstaculos
	
	//constructor
	
	public Logica( GUI g) {
		
		listaObjetos = new ListaDE<Objeto>();
	    puntaje = 0;
	    cantEnemigos = 0;
	    
	    mapa = new Mapa(this);
	    gui = g;
	    tiempoLog = new Tiempo(this);
	    
	    jugador = new Jugador(this, mapa.getAncho()/2 , mapa.getAlto() - 70 ); // ver alto y ancho ¿porque si pongo -49 queda al borde?
	    vidasJugador = jugador.getVidas();
	    gui.add(jugador.getLabel());
	}
	
	//metodos
	
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int p) {
		puntaje = p;
	}
	
	public int cantEnemigos() {
		return cantEnemigos;
	}
	
	public void setCantEnemigos(int cant) {
		cantEnemigos = cant;
	}
	
	public boolean hayEnemigos() {
		return cantEnemigos != 0;
	}
	
	
	public void empezarJuego() {
		tiempoLog.start(); 
	}
	
	public void crearObjetos() {
		listaObjetos = mapa.obtenerObjetosIniciales();
		cantEnemigos = mapa.cantEnemigosVivos();
		
		for( Objeto o : listaObjetos) {
			gui.add(o.getLabel());
		}
		
		
	}
	
	
	public void moverJugador (int direccion) {
		jugador.mover(direccion);
	}
	
	public void accionarObjetos() throws EmptyListException{
		if(!listaObjetos.isEmpty()) {
			
			for(Objeto o : listaObjetos) {
				o.accionar();
			}
		}
		else {
			throw new EmptyListException("se intento mover enemigos cuando no quedaba ninguno");
		}
	}
	
	//este metodo de todas formas será removido mas adelante para ser reemplazado por eliminarObjeto(Objeto o)
	
	public void eliminarEnemigo() {
		try {
			if(!listaObjetos.isEmpty()) {
				Position<Objeto> po = listaObjetos.last();
				
				gui.remove(po.element().getLabel());
				gui.repaint();
				po.element().morir();
				
				listaObjetos.remove(po);
			}
		}
		catch(InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
	}
	
	//metodo agregado a probar (por ahora solo usado por disparo)
	
	public void eliminarObjeto(Objeto o) {
		try {
			for(Position<Objeto> po : listaObjetos.positions()) {
				if(po.element() == o) {
					
					gui.remove(po.element().getLabel());
					gui.repaint();
					po.element().morir();
					
					listaObjetos.remove(po);
					break;
				}
			}
		}
		catch(InvalidPositionException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
