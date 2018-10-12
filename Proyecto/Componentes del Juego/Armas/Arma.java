package Armas;

import Disparos.Disparo;
import Logica.Logica;

public abstract class Arma {
	
	//atributos
	
	protected Logica log;
	
	protected int velocidadDisparo;
	protected int fuerzaDisparo;
	
	protected int cadencia; //cadencia de cada arma, medida en milisegundos
	
	protected long time;
	
	
	//constructor
	
	protected Arma(Logica l , int velDisp , int fuerzaDisp) {
		log = l;
		velocidadDisparo = velDisp;
		fuerzaDisparo = fuerzaDisp;
		time = System.currentTimeMillis();
	}
	
	//metodos
	
	//getters y setters
	
	public int getFuerzaDisparo() {
		return fuerzaDisparo;
	}
	
	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	public void setVelocidadDisparo(int vel) {
		velocidadDisparo = vel;
	}
	
	public void setFuerzaDisparo(int str) {
		fuerzaDisparo = str;
	}
	
	//metodos especiales
	

	public void disparar(int x , int y) {
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > cadencia) {
			crear_disparo(x,y);
			time = System.currentTimeMillis();
		}
	}
	
	protected abstract void crear_disparo(int x , int y);
}
