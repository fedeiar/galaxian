package Logica;

import TDALista.*;
public class Tiempo extends Thread{
	
	//atributos
	
	private Logica log;
	public final static int SLEEP_TIME = 50;
	//constructor
	
	public Tiempo(Logica l) {
		log = l;
	}
	
	//metodos
	
	
	
	public void run() {
		while(log.hayMapa() && log.jugadorEstaVivo()) {
			try {
				if(!log.hayEnemigos() && log.hayMapa()) {
					log.getMapaSiguiente();
				}
				
				log.actualizarObjetos();
				
				
				log.accionarObjetos();
				
				log.detectarColisiones();
				
				
				
				Thread.sleep(SLEEP_TIME);
				
				//MUY IMPORTANTE RESPETAR EL ORDEN EN EL QUE SE REALIZAN ESTAS ACCIONES! de lo contrario aumenta 
				//significantemente el delay
				//de todas formas, dependiendo de la forma en la que esten ordenados se produce el error en ejecucion raro.
			}
			catch (InterruptedException  e) {
				e.printStackTrace();
				
			}	
			
		}
	}
	
	
}
