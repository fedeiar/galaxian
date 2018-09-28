package Mapas;
import Grafica.*;
import Logica.*;
import ObjetoGeneral.*;
import TDALista.*;
import Personajes.*;
import EnemigosConcretos.*;

public class Mapa_1 extends Mapa {

	 //atributos
	
	 
	 
	 //constructor
	 
	 public Mapa_1(Logica l) {
		super(l);
		mapa_siguiente = new Mapa_2(log);
	}
	 
	 //metodos
	

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
	 
	
}
