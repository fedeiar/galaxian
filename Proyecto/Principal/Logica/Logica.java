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
	
	protected PositionList<Objeto> lista_agregar;
	protected PositionList<Objeto> lista_eliminar;
	protected PositionList<Objeto> lista_objetos;
	
	protected Mapa mapa;
	protected GUI gui;
	protected Tiempo tiempoLog;
	
	protected int puntaje  , vidasJugador , cantEnemigos; 
	
	protected Jugador jugador;
	
	
	//constructor
	
	public Logica( GUI g) {
		
		lista_objetos = new ListaDE<Objeto>();
		lista_agregar = new ListaDE<Objeto>();
		lista_eliminar = new ListaDE<Objeto>();
		
		
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
		return cantEnemigos > 0;
	}
	
	public boolean hayObjetos() {
		return !lista_objetos.isEmpty();
	}
	
	public void empezarJuego() {
		tiempoLog.start(); 
	}
	
	//inicializacion de los distintos objetos y cambio de mapas
	
	public boolean hayMapaSiguiente() {
		if(mapa.getMapaSiguiente()==null)
			return false;
		else
			return true;
	}
	
	public void getMapaSiguiente() {
		mapa = mapa.getMapaSiguiente();
		if(mapa!=null) //si bien siempre da true, esta por las dudas.
			crearObjetosIniciales();
	}
	
	public void crearObjetosIniciales() { //se ejecuta cada vez que empieza un mapa nuevo.
		resetearMapa();
		lista_agregar = mapa.obtenerObjetosIniciales();
		cantEnemigos = mapa.cantEnemigosVivos();
		
		lista_agregar.addLast(jugador); //necesito agregarlo manualmente cada vez que empieza un nuevo mapa ya que
										//fue removido de la lista de objetos cuando se reseteo el mapa.
		
	}
	
	private void resetearMapa() {
		try {
			while(!lista_objetos.isEmpty()) {
				Position<Objeto> po = lista_objetos.first();
				
				gui.remove(po.element().getLabel());
				lista_objetos.remove(po);
			}
		}
		catch(InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
		gui.repintar();
	}
	
	public void agregarObjeto(Objeto o) {
		lista_agregar.addFirst(o);
	}
	
	public void eliminarObjeto(Objeto o) {
		lista_eliminar.addLast(o);
	}
	
	public void actualizarObjetos() {
		
		for(Position<Objeto> po : lista_agregar.positions()) {
			lista_objetos.addLast(po.element());
			gui.add(po.element().getLabel());
		}
		
		lista_agregar = new ListaDE<Objeto>(); //ya agregamos lo que teniamos que agregar, reiniciamos la lista
		
		
		for(Position<Objeto> po : lista_eliminar.positions()) {
			eliminar(po.element());
		}
		
		lista_eliminar = new ListaDE<Objeto>(); //ya eliminamos lo que habia que eliminar, reiniciamos la lista
		
		gui.repintar();
	}	
	
	private void eliminar(Objeto o) {
		try {
			for(Position<Objeto> po : lista_objetos.positions()) {
				if(po.element() == o) {
					
					gui.remove(po.element().getLabel());
					lista_objetos.remove(po);
					break;
				}
			}
		}
		catch(InvalidPositionException e) {
			e.printStackTrace();
		}
	}
	
	
	public void lanzarDisparoJugador() { 
		jugador.disparar();
	}
	
	//movimiento de los objetos
	
	public void moverJugador (int direccion) { 
		jugador.mover(direccion);
	 }
	
	public void accionarObjetos() throws EmptyListException{
		if(!lista_objetos.isEmpty()) {
			
			for(Objeto o : lista_objetos) {
				o.accionar();
			}
			gui.repintar();
		}
		else {
			throw new EmptyListException("se intento mover enemigos cuando no quedaba ninguno");
		}
	}
	
	public void congelarObjetos(){
		for(Objeto o : lista_objetos) {
			o.congelar();
		}
	}
	
	//prototipo para detectar colisiones
	
	public void detectarColisiones() {
		Objeto objs[] = new Objeto[lista_objetos.size()]; //necesito un arreglo asi tengo un indice para
														  //recorrerlo 2 veces sin tener repetidos
		int i=0;
		
		for(Position<Objeto> po : lista_objetos.positions()) {
			objs[i] = po.element();
			i++;
		}
		
		for(i=0; i<objs.length ; i++) {
			for(int j=i+1 ; j<objs.length ; j++) {
				if(objs[i].getRectangulo().intersects(objs[j].getRectangulo())) { // si true quiere decir que colisionaron
					
					objs[i].chocar(objs[j]); 
					objs[j].chocar(objs[i]);
					/*es necesario hacer las 2 colisiones, ya que si por ejemplo un "enemigo" CHOCA A un "disparo"
					esto no tendrá efecto y no pasa nada, pero sí viceversa.
					*/
				}
			}
		}			
	}
	
}
