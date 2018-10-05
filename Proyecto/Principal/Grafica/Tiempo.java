package Grafica;
import Logica.*;
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
		while(true) {
			try {
				if(!log.hayEnemigos() && log.hayMapaSiguiente()) {
					log.getMapaSiguiente();
				}
				
				
				if(log.hayObjetos())
					log.accionarObjetos();
				
				log.detectarColisiones();
				
				
				log.actualizarObjetos();
				
				
				Thread.sleep(SLEEP_TIME);
				
				//MUY IMPORTANTE RESPETAR EL ORDEN EN EL QUE SE REALIZAN ESTAS ACCIONES! de lo contrario aumenta 
				//significantemente el delay
				//de todas formas, dependiendo de la forma en la que esten ordenados se produce el error en ejecucion raro.
			}
			catch (InterruptedException | EmptyListException e) {
				e.printStackTrace();
				
			}	
			
		}
	}
	
	
}
