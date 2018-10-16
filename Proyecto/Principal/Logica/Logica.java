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
	
	private PositionList<Objeto> lista_agregar;
	private PositionList<Objeto> lista_eliminar;
	private PositionList<Objeto> lista_objetos;
	
	private Mapa mapa;
	private GUI gui;
	private Tiempo tiempo;
	
	private int puntaje  , vidasJugador , cantEnemigos; 
	
	private Jugador jugador;
	
	//constructor
	
	public Logica( GUI g) {
		
		lista_objetos = new ListaDE<Objeto>();
		lista_agregar = new ListaDE<Objeto>();
		lista_eliminar = new ListaDE<Objeto>();
		
	    mapa = new Mapa_1(this);
	    gui = g;

	}
	
	//metodos
	
	public int getHPJugador() {
		return jugador.getHP();
	}
	public int getVidasJugador() {
		return jugador.getVidas();
	}
	public boolean jugadorEstaVivo() {
		return jugador!=null;
	}

	public int getPuntaje() {
		return puntaje;
	}
	
	public PositionList<Objeto> getListaObjetos(){
		return lista_objetos;
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
	
	public void empezarJuego() {
		puntaje = 0;
		cantEnemigos = 0;
		
		mapa = new Mapa_1(this);
		
		jugador = new Jugador (this, Mapa.MAX_X/2 , Mapa.MAX_Y - 70 );
		gui.add(jugador.getLabel());
		vidasJugador = jugador.getVidas();
		
		
		crearObjetosIniciales();
		tiempo = new Tiempo(this);
		tiempo.start();
		
		gui.requestFocus();
	}
	
	//inicializacion de los distintos objetos y cambio de mapas
	
	public boolean hayMapa() {
		if(mapa==null)
			return false;
		else
			return true;
	}
	
	public void getMapaSiguiente() {
		mapa = mapa.getMapaSiguiente();
		if(mapa!=null) //si bien siempre da true, esta por las dudas.
			crearObjetosIniciales();
	}
	
	private void crearObjetosIniciales() { //se ejecuta cada vez que empieza un mapa nuevo.
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
	
	//----AGREGACION Y ELIMINACION DE OBJETOS----
	
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
	
	
	
	//----MOVIMIENTO DE LOS OBJETOS----
	
	
	public void lanzarDisparoJugador() { 
		jugador.disparar();
	}
	
	public void moverJugador (int direccion) { 
		jugador.mover(direccion);
	}
	
	public void accionarObjetos() {
			
		for(Objeto o : lista_objetos) {
			o.accionar();
		}
		gui.repintar();
		
	}
	
	//----DETECCION DE COLISIONES----
	
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
					esto no tendr� efecto y no pasa nada, pero s� viceversa.
					*/
				}
			}
		}
	}
	
	//----VICTORIA Y DERROTA----
	
	public void perder() {
		eliminarTodo();
		jugador = null;
		gui.mostrarPanelDerrota();
	}
	
	private void eliminarTodo() {
		resetearMapa();
		lista_agregar = new ListaDE<Objeto>();
		lista_eliminar = new ListaDE<Objeto>();
	}
	
}
