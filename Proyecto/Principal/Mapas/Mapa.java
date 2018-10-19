package Mapas;

import Logica.Logica;
import ObjetoGeneral.Objeto;
import Premios.*;
import TDALista.PositionList;

public abstract class Mapa {

	//atributos
	
	 public final static int  MAX_X =900; //ancho del frame , ojo esta en publico, preguntar
	 public final static int MAX_Y =600;  //alto del frame , ojo esta en publico, preguntar
	 protected final static int CANT_MAX_PREMIOS  = 5;
	 
	 protected Logica log;
	 protected int cantEnemigos;
	 protected int lvl_PowerUp;
	 protected Mapa mapa_siguiente;
	 
	 protected Premio[] powerups;
	 //constructor
	 
	 public Mapa(Logica l) {
		 log = l;
		 cantEnemigos = 0;
		 lvl_PowerUp = 1;
		 
		 powerups = new Premio[CANT_MAX_PREMIOS];
		 powerups[0] = new CongelamientoTiempo(0,0,0,l);
		 powerups[1] = new Invulnerabilidad(0,0,0,l);
		 powerups[2] = new MejoraArmaDoble(0,0,0,l);
		 powerups[3] = new MejoraArmaSplit(0,0,0,l);
		 powerups[4] = new Pocion(0,0,0,l);
		 
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
