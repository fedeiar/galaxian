package ObjetosDelJuego;


import java.awt.Rectangle;
import Mapas.*;
import javax.swing.*;

public abstract class Objeto {
	
	//atributos
	
	protected Rectangle rec;
	protected JLabel etiqueta;
	protected ImageIcon imagen;
	
	protected final static int AnchoMapa=Mapa.MAX_X;
	protected final static int AltoMapa=Mapa.MAX_Y;
	
	//metodos
	
	public Rectangle getRectangulo() {
		return rec;
	}
	
	public int getX() {
		return rec.x;
	}
	
	public int getY() {
		return rec.y;
	}
	
	public void setX(int i) {
		rec.x = i;
		etiqueta.setBounds(rec);
	}
	
	public void setY (int i) {
		rec.y = i;
		etiqueta.setBounds(rec);
	}
	
	
	public JLabel getLabel() {
		return etiqueta;
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	
	/**
	 * método que será redefinido acorde al comportamiento de la clase que lo implemente
	 */
	public abstract void accionar(int direccion) ;
	
	
	
		
	
}
