package Disparos;

import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;

public class DisparoEnemigo extends Disparo {

    //atributos
	
	//constructor
	
		public DisparoEnemigo(Logica l , int v , int f , int x , int y) {
			super(l,v,f,x,y);
		}
		
	//metodos
		public void afectarEnemigo(Enemigo e) {}
		public void serColisionado(Objeto o) {}
		
		
		public void colisionar(Objeto o) {
			
		}
}
