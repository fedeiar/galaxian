package Inteligencias;

import Personajes.Enemigo;

public class InteligenciaDummy extends Inteligencia {

	//atributos
	
	protected final int tiempo_freeze = 4000;
	
	protected Enemigo ene;
	protected long time;
	protected Inteligencia vieja_inteligencia;
	
	//constructor
	
	public InteligenciaDummy(Enemigo e) {
		ene = e;
		vieja_inteligencia = e.getInteligencia();
		time = System.currentTimeMillis();
	}

	
	//metodos
	
	
	public void accionar() {
		long elapsed_time = System.currentTimeMillis() - time;
		
		if(elapsed_time > tiempo_freeze) {
			ene.setInteligencia(vieja_inteligencia);
			
			//no vuelvo a setear el tiempo ya que despues de esto esta inteligencia se destruira
		}
		
		
	}
	
}
