package Logica;
import Premios.*;
import TDALista.*;
import Personajes.*;

import Mapas.*;
import ObjetoGeneral.*;
import Disparos.*;
import EnemigosConcretos.EnemigoConArma;

import java.util.Random;


import Grafica.*;

public class Logica {

	//atributos
	
	
	protected PositionList<Objeto>  listaObjetos;
	
	protected Mapa mapa;
	protected GUI gui;
	protected Tiempo tiempoLog;
	
	protected int puntaje  , vidasJugador , cantEnemigos; 
	
	protected Jugador jugador;
	
	
	//constructor
	
	public Logica( GUI g) {
		
		listaObjetos = new ListaDE<Objeto>();
	    puntaje = 0;
	    cantEnemigos = 0;
	    
	    mapa = new Mapa_1(this);
	    gui = g;
	    tiempoLog = new Tiempo(this);
	    
	    jugador = new Jugador(this, Mapa.MAX_X/2 , Mapa.MAX_Y - 70 ); // ver alto y ancho ¿porque si pongo -49 queda al borde?
	    vidasJugador = jugador.getVidas();
	    gui.add(jugador.getLabel());
	}
	
	//metodos
	
	public int getHPJugador() {
		return jugador.getHP();
	}
	public int getVidasJugador() {
		return jugador.getVidas();
	}
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
	
	public boolean hayObjetos() {
		return !listaObjetos.isEmpty();
	}
	
	public void empezarJuego() {
		tiempoLog.start(); 
	}
	
	public boolean hayMapaSiguiente() {
		if(mapa==null)
			return false;
		else
			return true;
	}
	public void getMapaSiguiente() {
		mapa = mapa.getMapaSiguiente();
		if(mapa!=null)
			crearObjetos();
	}
	
	
	//hacer un deleteAll() para borrar los objetos q hayan quedado colgados
	public void crearObjetos() {
		resetearMapa();
		listaObjetos = mapa.obtenerObjetosIniciales();
		cantEnemigos = mapa.cantEnemigosVivos();
		gui.repintar();
		for( Objeto o : listaObjetos) {
			gui.add(o.getLabel());
		}
	}
	
	private void resetearMapa() {
		try {
			while(!listaObjetos.isEmpty()) {
				gui.remove(listaObjetos.first().element().getLabel());
				listaObjetos.remove(listaObjetos.first());
			}
		}
		catch(InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
		gui.repintar();
	}
	
	public void agregarObjeto(Objeto o) {
		listaObjetos.addFirst(o);
		gui.add(o.getLabel());
	}
	
	
	public void lanzarDisparoJugador() { //metodo auxiliar que debera ser eliminado
		jugador.disparar();
	}
	
	public void moverJugador (int direccion) {
		jugador.mover(direccion);
	}
	
	public void accionarObjetos() throws EmptyListException{
		if(!listaObjetos.isEmpty()) {
			
			for(Objeto o : listaObjetos) {
				o.accionar();
			}
			gui.repintar();
		}
		else {
			throw new EmptyListException("se intento mover enemigos cuando no quedaba ninguno");
		}
	}
	
	
	//metodo agregado a probar 
	
	public void eliminarObjeto(Objeto o) {
		try {
			for(Position<Objeto> po : listaObjetos.positions()) {
				if(po.element() == o) {
					
					gui.remove(po.element().getLabel());
					
					
					listaObjetos.remove(po);
					break;
				}
			}
			gui.repintar();
		}
		catch(InvalidPositionException e) {
			e.printStackTrace();
		}
	}
	
	//prototipo para detectar colisiones, funciona en O(n^2), dudoso
	
	public void detectarColisiones() {
		Objeto objs[] = new Objeto[listaObjetos.size() + 1]; //necesito un arreglo de forma de tener un indice para recorrerlo 2 veces sin tener repetidos
		int i=0;
		
		for(Position<Objeto> po : listaObjetos.positions()) {
			objs[i] = po.element();
			i++;
		}
		objs[i] = jugador ; //guardo al jugador en la ultima posicion ya que jugador no pertenece a la lista de objetos
		
		for(i=0; i<objs.length ; i++) {
			for(int j=i+1 ; j<objs.length ; j++) {
				if(objs[i].getRectangulo().intersects(objs[j].getRectangulo())) { // si true quiere decir que colisionaron
					System.out.println("hubo colision entre 2 objetos");
					
					objs[i].chocar(objs[j]); 
					objs[j].chocar(objs[i]);
					/*es necesario hacer las 2 colisiones, ya que si por ejemplo un "enemigo" CHOCA A un "disparo"
					esto no tendrá efecto y no pasa nada, pero sí viceversa.
					*/
				}
			}
		}
		gui.repintar();
					
	}
	
}
