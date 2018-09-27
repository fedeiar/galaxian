package Disparos;
import Visitors.*;
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
		}
		
	//metodos
	
		public void serVisitado(Visitor v) {
			//cuerpo vacio ya que no tiene efecto que un disparo seaColisionado por alguien
		}
		
		
		
		
		
}
