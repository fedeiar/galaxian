package Logica;

public class TiempoEntreNiveles extends Thread {

	//atributos
	
	Logica log;
	//constructor
	
	public TiempoEntreNiveles(Logica l) {
		log = l;
		
	}
	
	//metodos
	
	public void run() {
		try {
			
			Thread.sleep(5000);
			log.getMapaSiguiente();
			
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
