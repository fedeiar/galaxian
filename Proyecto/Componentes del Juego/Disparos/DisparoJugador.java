package Disparos;
import Visitors.*;
import Inteligencias.*;
import EnemigosConcretos.EnemigoConArma;
import Logica.*;
import ObjetoGeneral.*;
import Personajes.*;
import Obstaculos.*;
public class DisparoJugador extends Disparo{
	
	//atributos
	
	//constructor
	
		public DisparoJugador(Logica l , int v , int f , int x , int y) {
			super(l,v,f,x,y);
			vis = new VisitorDisparoJugador(this); //esto lo diferencia con un disparo enemigo
			inteligencia = new InteligenciaDisparoJugador(this);
		}
		
	//metodos
	
		
		
	//-----VISITOR-----
		
	public void serVisitado(Visitor v) {
		//cuerpo vacio ya que no tiene efecto que un disparo seaVisitado por alguien
	}
		
		
		
		
		
}
