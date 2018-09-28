package Mapas;

import Logica.Logica;
import ObjetoGeneral.Objeto;
import TDALista.PositionList;

public abstract class Mapa {

	//atributos
	
	 public final static int  MAX_X =900; //ancho del frame , ojo esta en publico, preguntar
	 public final static int MAX_Y =600;  //alto del frame , ojo esta en publico, preguntar
	 
	 protected Logica log;
	 protected int cantEnemigos;
	 protected int lvl_PowerUp;
	 protected Mapa mapa_siguiente;
	 
	 //constructor
	 
	 public Mapa(Logica l) {
		 log = l;
		 cantEnemigos = 0;
		 lvl_PowerUp = 1;
	 }
	 
	 //metodos
	 
	 public int cantEnemigosVivos() {
		 return cantEnemigos;
	 }
	 
	 public int getLevelMapa() {
		 return lvl_PowerUp;
	 }
	 
	 public Mapa getMapaSiguiente() {
		 return mapa_siguiente;
	 }
	 
	 public abstract PositionList<Objeto> obtenerObjetosIniciales();
}
