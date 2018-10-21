package Armas;

import Disparos.Disparo;
import Logica.Logica;

public abstract class Arma {
	
	//atributos
	
	protected Logica log;
	
	protected double velocidadDisparo;
	protected int fuerzaDisparo;
	
	protected int cadencia; //cadencia de cada arma, medida en milisegundos
	
	private long time;
	
	
	//constructor
	
	protected Arma(Logica l) {
		log = l;
		
		time = System.currentTimeMillis();
	}
	
	//metodos
	
	//getters y setters
	
	public int getFuerzaDisparo() {
		return fuerzaDisparo;
	}
	
	public double getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	public void setVelocidadDisparo(double vel) {
		velocidadDisparo = vel;
	}
	
	public void setFuerzaDisparo(int str) {
		fuerzaDisparo = str;
	}
	
	//metodos especiales
	

	public void disparar(double x , double y) {
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > cadencia) {
			crear_disparo(x,y);
			time = System.currentTimeMillis();
		}
	}
	
	protected abstract void crear_disparo(double x , double y);
}
