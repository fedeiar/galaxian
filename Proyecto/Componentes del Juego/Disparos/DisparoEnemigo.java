package Disparos;
import Visitors.*;
import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;
import Inteligencias.*;
public class DisparoEnemigo extends Disparo {

    //atributos
	
	//constructor
	
		public DisparoEnemigo(Logica l , int v , int f , int x , int y) {
			super(l,v,f,x,y);
			inteligencia = new InteligenciaDisparoEnemigo(this);
		}
		
	//metodos
		            
		
		
	//----VISITOR----
	
	public void serVisitado(Visitor v) {}
		
		
}
