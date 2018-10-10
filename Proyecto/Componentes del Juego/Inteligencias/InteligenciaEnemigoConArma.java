package Inteligencias;

import EnemigosConcretos.*;
import java.util.Random;



public class InteligenciaEnemigoConArma extends InteligenciaEnemigo{
	
	//atributos
	
	protected EnemigoConArma ene;
	
	
	//constructor
	
	public InteligenciaEnemigoConArma(EnemigoConArma e) {
		super();
		ene = e;
	}
	
	//metodos
	
	public void accionar() {
		if(puedo_accionar) {
			
			//CON RESPECTO AL MOVIMIENTO
		
			movimiento_estandar(ene);
		
			//CON RESPECTO AL DISPARO
		
		
			if(ene.puedo_shoot()) {
				Random ran = new Random();
				int rshoot = ran.nextInt(3);
				if(rshoot<2) { //0.66 chances
					ene.crearDisparo();
				}
			}
			
		}
		else
			contar();
	}
	
	

	
	
	
}
