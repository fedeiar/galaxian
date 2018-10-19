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
		cadencia = 400;
		
	}

	//metodos
	
	protected void crear_disparo(double x, double y) {
		
		Random ran = new Random();
		int r_disp = ran.nextInt(50);
		r_disp += 150;	
		
		for(int i=1 ; i<10 ; i++) {
			DisparoComunEnemigo dispE = new DisparoComunEnemigo(log,velocidadDisparo,fuerzaDisparo,r_disp * i % Mapa.MAX_X,y ,270);
			log.agregarObjeto(dispE);
		}
	
	}
	
	public void shootFromBelow() {
		
	}

}
