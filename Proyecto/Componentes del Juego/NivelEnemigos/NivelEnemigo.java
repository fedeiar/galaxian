package NivelEnemigos;
import java.awt.*;

import javax.swing.ImageIcon;
/**
 * Esta clase solo se encargara de inicializar los atributos del enemigo acorde al nivel que posee.
 * @author Fede iar
 *
 */
public abstract class NivelEnemigo {
	
	//atributos
	
	protected NivelEnemigo siguiente;
	protected int velocidadMovimiento;
	protected int HP;
	protected int velocidadDisparo;
	protected int fuerzaDisparo;
	protected int puntosQueDa;
	
	//constructor
	
	public NivelEnemigo() {
		
	}
	
	//metodos
	
	public int getFuerzaDisparo() {
		return fuerzaDisparo;
	}
	
	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
	public int getHP() {
		return HP;
	}

	public int getPuntaje() {
		return puntosQueDa;
	}
	
	public NivelEnemigo getSiguiente() {
		return siguiente;
	}
	
	
	
	
}
