package Mapas;

import EnemigosConcretos.EnemigoADesarmar;
import EnemigosConcretos.EnemigoConArma;
import EnemigosConcretos.EnemigoKamikazeAleatorio;
import EnemigosConcretos.EnemigoKamikazeDirigido;
import Logica.Logica;
import ObjetoGeneral.Objeto;
import TDALista.ListaDE;
import TDALista.PositionList;

public class Mapa_3 extends Mapa {

	//atributos
	
	 
	 
	//constructor
		 
	 public Mapa_3(Logica l) {
		super(l);
		mapa_siguiente = null;
	 }
		 
	 //metodos
		

	public PositionList<Objeto> obtenerObjetosIniciales(){
		PositionList<Objeto> L = new ListaDE<Objeto>();
		 
		
		for(int i=0 ; i<5 ; i++) {
			EnemigoConArma ene = new EnemigoConArma( log, 400 + i*100 , 100  , 2 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		for(int i=0 ; i<5 ; i++) {
			EnemigoADesarmar ene = new EnemigoADesarmar( log, 300 + i*100 , 160  , 2 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		for(int i=0 ; i<5 ; i++) {
			EnemigoKamikazeAleatorio ene = new EnemigoKamikazeAleatorio( log, 300 + i*100 , 220  , 2 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		return L;
	 }
		 
}
