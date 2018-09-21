package Mapas;
import Grafica.*;
import Logica.*;
import ObjetoGeneral.*;
import TDALista.*;
import Personajes.*;
import EnemigosConcretos.*;

public class Mapa  {

	 //atributos
	
	 public final static int  MAX_X =900; //ancho del frame , ojo esta en publico, preguntar
	 public final static int MAX_Y =600;  //alto del frame , ojo esta en publico, preguntar
	 
	 private Logica log;
	 private int cantEnemigos;
	 //constructor
	 
	 public Mapa(Logica l) {
		 log = l;
		 cantEnemigos = 0;
	 }
	 
	 
	 
	//metodo a probar, si queda bien. podrian hacerse mapa abstracto y distintos mapas que implementen este metodo.
	 
	 public PositionList<Objeto> obtenerObjetosIniciales(){
		 PositionList<Objeto> L = new ListaDE<Objeto>();
		 for(int i = 0 ; i<5 ; i++) {
				EnemigoConArma ene = new EnemigoConArma( log, 200 + i*100 , 100  ,1);
				L.addLast(ene);
				cantEnemigos++;
		}
		 
		 //aqui podrían agregarse los obstaculos.
		 
		 return L;
	 }
	 
	 public int cantEnemigosVivos() {
		 return cantEnemigos;
	 }
}
