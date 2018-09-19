package ObjetosDelJuego;


import java.awt.Rectangle;
import javax.swing.*;

public abstract class Objeto {
	
	//atributos
	
	protected Rectangle rec;
	protected JLabel etiqueta;
	protected ImageIcon imagen;
	
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
	public abstract void accionar(int anchoDelMapa) ;
	
	
	
		
	
}
