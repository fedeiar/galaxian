package Mapas;
import Grafica.*;
import Logica.*;
import ObjetoGeneral.*;
import TDALista.*;
import Personajes.*;
import EnemigosConcretos.*;
import Obstaculos.*;
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
		 
		 SANS sans = new SANS(log , MAX_X / 2 + 150 , 50 , -1 , powerups[0]);
		 L.addLast(sans);
		 cantEnemigos++;
		 
		 Obstaculo obs1 = new DestruidosPorTodos(log, 50 , MAX_Y /2);
		 Obstaculo obs2 = new BarricadaParaEnemigos(log, MAX_X - 100 , MAX_Y /2);
		 L.addLast(obs2);
		 L.addLast(obs1);
		 
		 /*
		 for(int i = 0 ; i<5 ; i++) {
				EnemigoKamikazeDirigido ene = new EnemigoKamikazeDirigido( log, 300 + i*100 , 100  ,1 , powerups[ i % CANT_MAX_PREMIOS].clone());
				L.addLast(ene);
				cantEnemigos++;
		}
		
		 for(int i = 0 ; i<5 ; i++) {
			 EnemigoKamikaze ene = new EnemigoKamikaze(log , 300 + i*100 , 200 , 1 , powerups[ i % CANT_MAX_PREMIOS].clone());
			 L.addLast(ene);
			 cantEnemigos++;
		 }
		*/
		 
		 //aqui podrían agregarse los obstaculos.
		 
		 return L;
	 }
	 
	
}
