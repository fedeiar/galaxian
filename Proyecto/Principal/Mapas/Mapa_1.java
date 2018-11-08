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
		
		 
		 
		 L.addLast(new BarricadaParaEnemigos (log , 5 , MAX_Y / 2));
		 L.addLast(new BarricadaParaEnemigos (log , 300 , MAX_Y / 2));
		 L.addLast(new BarricadaParaEnemigos (log , 600 , MAX_Y / 2));
		 
		 
		 L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 10 , MAX_Y /2 - 60));
		 L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 200 , MAX_Y /2 - 60));
		 L.addLast(new DestruidosPorTodos (log, MAX_X - Obstaculo.ANCHO - 500 , MAX_Y /2 - 60));
		 
		 for(int i = 0 ; i<10 ; i++) {
			 EnemigoConArma ene = new EnemigoConArma(log , 200 + i*70 , 50 , 1 , powerups[ i % CANT_MAX_PREMIOS].clone());
			 L.addLast(ene);
			 cantEnemigos++;
		 }
		
		 for(int i = 0 ; i<6 ; i++) {
			EnemigoKamikazeAleatorio ene = new EnemigoKamikazeAleatorio( log, 300 + i*70 , 100  ,1 , powerups[ i % CANT_MAX_PREMIOS].clone());
			L.addLast(ene);
			cantEnemigos++;
		}
		
		 
		 
		
		 return L;
	 }
	 
	
}
