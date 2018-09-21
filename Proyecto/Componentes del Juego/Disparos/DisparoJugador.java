package Disparos;
import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;
import Obstaculos.*;
public class DisparoJugador extends Disparo{
	
	//atributos
	
	//constructor
	
		public DisparoJugador(Logica l , int v , int f , int x , int y) {
			super(l,v,f,x,y);
		}
		
	//metodos
	
		public void serColisionado(Objeto o) {}
		
		//aquel que use a colisionar, si pasa un objeto, como sabra java cual metodo utilizar?
		
		public void colisionar(Enemigo e) {
			
		}
		
		public void colisionar(Obstaculos o) {
			
		}
}
