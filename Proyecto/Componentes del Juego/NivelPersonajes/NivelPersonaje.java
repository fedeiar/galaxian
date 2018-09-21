package NivelPersonajes;
import java.awt.*;

import javax.swing.ImageIcon;
/**
 * Esta clase solo se encargara de inicializar los atributos del personaje(enemigo o jugador) acorde al nivel que posee.
 * @author Fede iar
 *
 */
public abstract class NivelPersonaje {
	
	//atributos
	
	protected NivelPersonaje siguiente;
	protected int velocidadMovimiento;
	protected int HP;
	protected int velocidadDisparo;
	protected int fuerzaDisparo;
	protected ImageIcon foto;
	
	//constructor
	
	public NivelPersonaje() {
		
	}
	
	//metodos
	
	public int getFuerzaDisparo() {
		return fuerzaDisparo;
	}
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	
	public NivelPersonaje getSiguiente() {
		return siguiente;
	}
	
	public ImageIcon getImagen() {
		return foto;
	}
	
	
}
