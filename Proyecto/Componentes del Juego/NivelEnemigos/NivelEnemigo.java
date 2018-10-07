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
	protected int velocidad_movimiento_horizontal;
	protected int velocidad_movimiento_vertical;
	protected int HP;
	protected int puntosQueDa;
	protected int fuerzaImpacto;
	
	//constructor
	
	public NivelEnemigo() {
		
	}
	
	//metodos
	
	
	public int getFuerzaImpacto() {
		return fuerzaImpacto;
	}
	
	public int getVelocidadMovimientoHorizontal() {
		return velocidad_movimiento_horizontal;
	}
	
	public int getVelocidadMovimientoVertical() {
		return velocidad_movimiento_vertical;
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
