package Personajes;

public abstract class Nivel {
	
	//atributos
	
	protected Nivel siguiente;
	protected int velocidadMovimiento;
	protected int HP;
	protected int velocidadDisparo;
	
	//constructor
	
	public Nivel() {
		
	}
	
	//metodos
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
	public int GetHP() {
		return HP;
	}
	
	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	public void restarVida() {
		HP--;
	}
	
	public Nivel getSiguiente() {
		return siguiente;
	}
}
