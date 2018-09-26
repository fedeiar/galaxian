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
	    
	    mapa = new Mapa(this);
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
	
	public void lanzarPremio(int x,int y) { //aqui deberiamos implementar un prototype
		Premios P;
		
		//por ahora dejarlo asi, despues tratar de cambiarlo.
		P = new MejoraArma1(x,y,mapa.getLevelMapa() * 10 , this ,jugador.getVelocidadDisparo() * 2);
		
		listaObjetos.addLast(P);
		gui.add(P.getLabel());
		
	}
	
	public void lanzarDisparoJugador() {
		DisparoJugador disparoJ = new DisparoJugador(this,jugador.getVelocidadDisparo(),jugador.getFuerzaDisparo(),
													 jugador.getX() + jugador.getAncho()/2 , jugador.getY() );
		listaObjetos.addFirst(disparoJ);
		gui.add(disparoJ.getLabel());
		
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
	
	//metodo agregado a probar 
	
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
					
					objs[i].serVisitado(objs[j].getVisitor()); //sería el "aceptar(objs[j].getVisitor())"
					objs[j].serVisitado(objs[i].getVisitor());
					/*es necesario hacer las 2 colisiones, ya que si por ejemplo un disparo ES COLISIONADO POR un enemigo
					esto no tendrá efecto y no pasa nada, pero sí viceversa.
					*/
				}
			}
		}
		gui.repintar();
					
	}
	
}
