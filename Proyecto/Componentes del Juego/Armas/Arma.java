package Armas;

import Disparos.Disparo;
import Logica.Logica;

public abstract class Arma {
	
	//atributos
	
	protected Logica log;
	
	protected int velocidadDisparo;
	protected int fuerzaDisparo;
	
	protected int cadencia;
	protected int shoot_count;
	//constructor
	
	protected Arma(Logica l , int velDisp , int fuerzaDisp) {
		log = l;
		velocidadDisparo = velDisp;
		fuerzaDisparo = fuerzaDisp;
		shoot_count = 0;
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
	

	
	public abstract boolean puedo_shoot();
	
	public abstract void disparar(int x , int y);
}
