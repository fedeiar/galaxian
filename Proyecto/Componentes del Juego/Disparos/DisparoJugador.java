package Disparos;
import Visitors.*;
import Inteligencias.*;
import EnemigosConcretos.EnemigoConArma;
import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;
import Obstaculos.*;
public abstract class DisparoJugador extends Disparo{
	
	//atributos
	
	//constructor
	
		protected DisparoJugador(Logica l , double v , int f , double x , double y , double direc) {
			super(l,v,f,x,y,direc);
			vis = new VisitorDisparoJugador(this); //esto lo diferencia con un disparo enemigo
			
		}
		
	//metodos
	
		
		
	//-----VISITOR-----
		
	public void serVisitado(Visitor v) {
		//cuerpo vacio ya que no tiene efecto que un disparo seaVisitado por alguien
	}
		
		
		
		
		
}
