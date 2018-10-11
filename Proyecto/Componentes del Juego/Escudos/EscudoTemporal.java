package Escudos;

import Personajes.Jugador;

public class EscudoTemporal implements Runnable{
	
	//atributos
	
	protected Escudo escudo_nuevo;
	protected Escudo escudo_viejo;
	protected int durabilidad; //en milisegundos
	protected Jugador jugador;
	
	//constructor
	
	public EscudoTemporal(Jugador jug, Escudo new_shield, int tiempo) {
		escudo_nuevo = new_shield;
		durabilidad = tiempo;
		jugador = jug;
		escudo_viejo = jug.getEscudo();
	}
	
	//metodos
	
	public void run() {
		try {
			
			jugador.setEscudo(escudo_nuevo);
			
			Thread.sleep(durabilidad);
			
			jugador.setEscudo(escudo_viejo);
			
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
