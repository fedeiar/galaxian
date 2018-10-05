package Armas;
import Logica.*;
import Disparos.*;


public class ArmaClasicaEnemigo extends ArmaEnemigo{

	//atributos
	
	//constructor
	
	public ArmaClasicaEnemigo(Logica l , int velDisp , int fuerzaDisp) {
		super(l,velDisp,fuerzaDisp);
		
		cadencia = 5;
	}
	
	//metodos
	
	public void disparar(int x , int y) {
		DisparoComunEnemigo dispE = new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,x,y);
		log.agregarObjeto(dispE);
	}
	
	
	
}
