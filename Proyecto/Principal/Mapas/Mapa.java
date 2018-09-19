package Mapas;
import Grafica.*;
import TDALista.*;
import Personajes.*;
import EnemigosConcretos.*;
import ObjetosDelJuego.*;
public class Mapa  {

	 //atributos
	
	 public final static int  MAX_X=900; //ancho del frame , ojo esta en publico, preguntar
	 public final static int MAX_Y=600;  //alto del frame , ojo esta en publico, preguntar
	 
	 
	 //constructor
	 
	 public Mapa() {
		 
	 }
	 
	 //metodos
	 
	 public int getAncho() {
		 return MAX_X;
	 }
	 
	 public int getAlto() {
		 return MAX_Y;
	 }
	 
	//metodo a probar, si queda bien. podrian hacerse mapa abstracto y distintos mapas que implementen este metodo.
	 
	 public PositionList<Objeto> obtenerObjetosIniciales(){
		 PositionList<Objeto> L = new ListaDE<Objeto>();
		 for(int i = 0 ; i<5 ; i++) {
				Enemigo ene = new EnemigoConArma( 200 + i*100 , 100  ,1);
				L.addLast(ene);
		}
		 
		 //aqui podrían agregarse los obstaculos.
		 
		 return L;
	 }
}
