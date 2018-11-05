package Armas;

import java.util.Random;

import Disparos.DisparoComunEnemigo;
import Disparos.DisparoSansEnemigo;
import Logica.Logica;
import Mapas.Mapa;

public class ArmaSans extends Arma{

	//atributos
	 
	private int switch_shoot;
	//constructor
	
	public ArmaSans(Logica l) {
		super(l);
		velocidadDisparo = 15;
		fuerzaDisparo = 3;
		cadencia = 550;
		switch_shoot = 0;
	}

	//metodos
	
	protected void crear_disparo(double x, double y) {
		
		
		
		switch(switch_shoot) {
		case 0 : for(int i=0 ; i<13 ; i++) {
				 	log.agregarObjeto(new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,(30 + 80 * i) % (Mapa.MAX_X - 20) , y ,270));
				 }
			     break;
		case 1 : for(int i=0 ; i<13 ; i++) {
				 	log.agregarObjeto(new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,(60 + 80 * i) % (Mapa.MAX_X - 20) , y ,270));
			     }
				 break;
		case 2 : for(int i=0 ; i<13 ; i++) {
		 			log.agregarObjeto(new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,(90 + 80 * i) % (Mapa.MAX_X - 20) , y ,270));
	     		 }
		 		 break;
		case 3 : for(int i=0 ; i<13 ; i++) {
 				 	log.agregarObjeto(new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,(120 + 80 * i) % (Mapa.MAX_X - 20) , y ,270));
 		 		 }
 		 	     break;
		}
		
		switch_shoot = (switch_shoot + 1) % 4;
		
	
	}
	

}
