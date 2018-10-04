package Disparos;
import Visitors.*;
import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;
import Inteligencias.*;
public abstract class DisparoEnemigo extends Disparo {

    //atributos
	
	//constructor
	
		public DisparoEnemigo(Logica l , int v , int f , int x , int y) {
			super(l,v,f,x,y);
			vis = new VisitorDisparoEnemigo(this);
			inteligencia = new InteligenciaDisparoEnemigo(this);
		}
		
	//metodos
		            
		
		
	//----VISITOR----
	
	public void serVisitado(Visitor v) {
		//cuerpo vacio ya que no tiene efecto que un disparo seaVisitado por alguien
	}
		
		
}
