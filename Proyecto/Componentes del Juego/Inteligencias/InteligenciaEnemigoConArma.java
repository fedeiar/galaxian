package Inteligencias;

import Personajes.*;
import java.util.Random;



public class InteligenciaEnemigoConArma extends InteligenciaEnemigo{
	
	//atributos
	
	protected Enemigo ene;
	
	
	//constructor
	
	public InteligenciaEnemigoConArma(Enemigo e) {
		super();
		ene = e;
	}
	
	//metodos
	
	public void accionar() {
		

		//CON RESPECTO AL MOVIMIENTO
		
		movimiento_estandar(ene);
		
		//CON RESPECTO AL DISPARO
			
		Random ran = new Random();
		int rshoot = ran.nextInt(3);
		if(rshoot<2) { //0.66 chances
			ene.crearDisparo();
		}
			
	}
	
	

	
	
	
}
