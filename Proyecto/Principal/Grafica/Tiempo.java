package Grafica;
import Logica.*;
import TDALista.*;
public class Tiempo extends Thread{
	
	//atributos
	
	private Logica log;
	
	//constructor
	
	public Tiempo(Logica l) {
		log = l;
	}
	
	//metodos
	
	//Cuando se terminen los enemigos, habría que volver a ejecutar start() cuando se inicializen los nuevos enemigos.
	
	public void run() {
		while(log.hayObjetos()) {
			try {
				
				log.accionarObjetos();
				log.detectarColisiones();
				
				Thread.sleep(100);
				
				
			}
			catch (InterruptedException | EmptyListException e) {
				e.printStackTrace();
				
			}
			
		}
	}
}
