package Personajes;
import java.awt.*;

import javax.swing.ImageIcon;

public abstract class Nivel {
	
	//atributos
	
	protected Nivel siguiente;
	protected int velocidadMovimiento;
	protected int HP;
	protected int velocidadDisparo;
	protected ImageIcon foto;
	
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
	
	public void restarVida(int n) {
		HP -= n;
	}
	
	public Nivel getSiguiente() {
		return siguiente;
	}
	
	public ImageIcon getImagen() {
		return foto;
	}
}
