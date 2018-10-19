package Inteligencias;

import EnemigosConcretos.SANS;

public class InteligenciaSans extends InteligenciaEnemigo{

	//atributos
	
	protected SANS sans;
	
	protected long time;
	
	protected long cadencia_ataqueEspecial;
	protected long duracion_ataqueEspecial;
	
	protected boolean ataqueEspecialEnProceso;
	
	//constructor
	
	public InteligenciaSans(SANS s) {
		sans = s;
		cambio_direccion = 5500;
		
		time = System.currentTimeMillis();
		
		
		cadencia_ataqueEspecial = 30000;
		duracion_ataqueEspecial = 15000;
		
		ataqueEspecialEnProceso = false;
	}
	
	public void accionar() {
		
		//CON RESPECTO AL MOVIMIENTO
		
		movimiento_estandar(sans);
		
		//CON RESPECTO AL DISPARO
		
		if(!ataqueEspecialEnProceso)
			sans.crear_disparos();
		else {
			long elapsed_time = System.currentTimeMillis() - time;
			if (elapsed_time > duracion_ataqueEspecial) 
				ataqueEspecialEnProceso = false;
		}
		
		//CON RESPECTO A LOS PODERES
		
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > cadencia_ataqueEspecial) {
			ataqueEspecialEnProceso = true;
			time = System.currentTimeMillis();
			
			sans.lanzar_poder();
		}
		
	}

}
