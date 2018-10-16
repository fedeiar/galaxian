package Mapas;

import EnemigosConcretos.EnemigoConArma;
import Logica.Logica;
import ObjetoGeneral.Objeto;
import TDALista.ListaDE;
import TDALista.PositionList;

public class Mapa_2 extends Mapa {

	//atributos
	
	 
	 
	//constructor
		 
	 public Mapa_2(Logica l) {
		super(l);
		mapa_siguiente = null;
	 }
		 
	 //metodos
		

	public PositionList<Objeto> obtenerObjetosIniciales(){
		 PositionList<Objeto> L = new ListaDE<Objeto>();
		 for(int i=1 ; i<3 ; i++) {
			 for(int j=0 ; j<5 ; j++) {
				EnemigoConArma ene = new EnemigoConArma( log, 200 + j*100 , i*100  ,1 , powerups[ i % CANT_MAX_PREMIOS]);
				L.addLast(ene);
				cantEnemigos++;
			 }
		}
		 
		
		 
		 return L;
	 }
		 
}
