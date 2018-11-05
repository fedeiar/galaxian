package Armas;

import java.util.Random;

import Disparos.DisparoComunEnemigo;
import Disparos.DisparoSansEnemigo;
import Logica.Logica;
import Mapas.Mapa;

public class ArmaSans extends Arma{

	//atributos
	 
	
	//constructor
	
	public ArmaSans(Logica l) {
		super(l);
		velocidadDisparo = 15;
		fuerzaDisparo = 3;
		cadencia = 550;
		
	}

	//metodos
	
	protected void crear_disparo(double x, double y) {
		
		Random ran = new Random();
		int r_disp = ran.nextInt(4);
		
		switch(r_disp) {
		case 0 : for(int i=0 ; i<13 ; i++) {
				 	log.agregarObjeto(new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,(30 + 80 * i) % (Mapa.MAX_X - 20) , y ,270));
				 }
			     break;
		case 1 : for(int i=0 ; i<13 ; i++) {
				 	log.agregarObjeto(new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,(70 + 80 * i) % (Mapa.MAX_X - 20) , y ,270));
			     }
				 break;
		case 2 : for(int i=0 ; i<13 ; i++) {
		 			log.agregarObjeto(new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,(110 + 80 * i) % (Mapa.MAX_X - 20) , y ,270));
	     		 }
		 		 break;
		case 3 : for(int i=0 ; i<13 ; i++) {
 				 	log.agregarObjeto(new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,(150 + 80 * i) % (Mapa.MAX_X - 20) , y ,270));
 		 		 }
 		 break;
		}
		
		
	
	}
	

}
