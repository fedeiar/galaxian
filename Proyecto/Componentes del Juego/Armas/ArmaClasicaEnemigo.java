package Armas;
import Logica.*;
import Disparos.*;


public class ArmaClasicaEnemigo extends ArmaEnemigo{

	//atributos
	
	//constructor
	
	public ArmaClasicaEnemigo(Logica l , int velDisp , int fuerzaDisp) {
		super(l,velDisp,fuerzaDisp);
		
		cadencia = 500;
	}
	
	//metodos
	
	public void crear_disparo(int x , int y) {
		
		DisparoComunEnemigo dispE = new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,x,y);
		log.agregarObjeto(dispE);
	
	}
	
	
	
}
