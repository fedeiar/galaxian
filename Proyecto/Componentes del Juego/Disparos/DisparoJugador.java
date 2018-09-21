package Disparos;
import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;
public class DisparoJugador extends Disparo{
	
	//atributos
	
	//constructor
	
		public DisparoJugador(Logica l , int v , int f , int x , int y) {
			super(l,v,f,x,y);
		}
		
	//metodos
	
		public void serColisionado(Objeto o) {}
		
		
		public void colisionar(Objeto o) {
			//debo castear objeto? y si es un enemigo? y si es barricada??
		}
		
		
}
