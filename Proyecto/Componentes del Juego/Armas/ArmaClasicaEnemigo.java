package Armas;
import Logica.*;
import Disparos.*;


public class ArmaClasicaEnemigo extends Arma{

	//atributos
	
	//constructor
	
	public ArmaClasicaEnemigo(Logica l , double velDisp , int fuerzaDisp) {
		super(l,velDisp,fuerzaDisp);
		
		cadencia = 500;
	}
	
	//metodos
	
	public void crear_disparo(double x , double y) {
		
		DisparoComunEnemigo dispE = new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,x,y,270);
		log.agregarObjeto(dispE);
	
	}
	
	
	
}
