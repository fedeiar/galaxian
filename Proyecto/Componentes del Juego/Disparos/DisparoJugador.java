package Disparos;
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
		}
		
	//metodos
	
		public void serColisionado(Objeto o) {
			//cuerpo vacio ya que no tiene efecto que un disparo seaColisionado por alguien
		}
		
		
		
		public void afectarEnemigo(Enemigo e) {
			
			e.quitarHP(fuerzaDeImpacto);
			log.eliminarObjeto(this);
			
			System.out.println("Entro a DisparoJugador (yay)");
		}
		
		
}
