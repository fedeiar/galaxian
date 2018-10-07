package Inteligencias;

import EnemigosConcretos.*;
import java.util.Random;



public class InteligenciaEnemigoConArma extends InteligenciaEnemigo{
	
	//atributos
	
	protected EnemigoConArma ene;
	
	
	//constructor
	
	public InteligenciaEnemigoConArma(EnemigoConArma e) {
		ene = e;
	}
	
	//metodos
	
	public void accionar() {
		
		//con respecto al movimiento
		
		movimiento_estandar(ene);
		
		//con respecto al disparo
		
		
		if(ene.puedo_shoot()) {
			Random ran = new Random();
			int rshoot = ran.nextInt(3);
			if(rshoot<2) { //0.66 chances
				ene.crearDisparo();
			}
		}
	}
	
	

	
	
	
}
