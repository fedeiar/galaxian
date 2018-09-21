package Logica;
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
	    
	    mapa = new Mapa(this);
	    gui = g;
	    tiempoLog = new Tiempo(this);
	    
	    jugador = new Jugador(this, mapa.getAncho()/2 , mapa.getAlto() - 70 ); // ver alto y ancho ¿porque si pongo -49 queda al borde?
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
	
	public void lanzarDisparoJugador() {
		DisparoJugador disparoJ = new DisparoJugador(this,jugador.getVelocidadDisparo(),jugador.getFuerzaDisparo(),
													 jugador.getX() + jugador.getAncho()/2 , jugador.getY());
		listaObjetos.addFirst(disparoJ);
		gui.add(disparoJ.getLabel());
		gui.repintar();
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
	
	//este metodo de todas formas será removido mas adelante para ser reemplazado por eliminarObjeto(Objeto o)
	//solo esta para pasar el sprint
	
	public void eliminarEnemigo() {
		try {
			if(!listaObjetos.isEmpty()) {
				Position<Objeto> po = listaObjetos.last();
				
				gui.remove(po.element().getLabel());
				po.element().morir();
				
				listaObjetos.remove(po);
				
				gui.repintar();
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
					po.element().morir();
					
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
		Objeto objs[] = new Objeto[listaObjetos.size()]; //necesito un arreglo de forma de tener un indice para recorrerlo 2 veces sin tener repetidos
		int i=0;
		
		for(Position<Objeto> po : listaObjetos.positions()) {
			objs[i] = po.element();
			i++;
		}
		
		for(i=0; i<objs.length ; i++) {
			for(int j=i+1 ; j<objs.length ; j++) {
				if(objs[i].getRectangulo().intersects(objs[j].getRectangulo())) { // si true quiere decir que colisionaron
					if( objs[i] instanceof DisparoJugador) {
						System.out.println("soy un disparo jugador, soy objs[i]");
					}
					if( objs[j] instanceof EnemigoConArma) {
						System.out.println("soy un enemigoConArma, soy objs[j]");
					}
					objs[i].serColisionado(objs[j]);
					objs[j].serColisionado(objs[i]);
					/*es necesario hacer las 2 colisiones, ya que si por ejemplo un disparo ES COLISIONADO POR un enemigo
					esto no tendrá efecto y no pasa nada, pero sí viceversa.
					*/
				}
			}
		}
		gui.repintar();
					
	}
	
}
