package Disparos;
import Visitors.*;
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
		            
		
		
		public void serVisitado(Visitor v) {}
		
		
}
