package Personajes;
import java.awt.*;

import javax.swing.ImageIcon;

public abstract class NivelPersonaje {
	
	//atributos
	
	protected NivelPersonaje siguiente;
	protected int velocidadMovimiento;
	protected int HP;
	protected int velocidadDisparo;
	protected ImageIcon foto;
	
	//constructor
	
	public NivelPersonaje() {
		
	}
	
	//metodos
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	public void restarVida(int n) {
		HP -= n;
	}
	
	public NivelPersonaje getSiguiente() {
		return siguiente;
	}
	
	public ImageIcon getImagen() {
		return foto;
	}
}
