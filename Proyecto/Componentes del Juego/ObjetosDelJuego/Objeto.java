package ObjetosDelJuego;

import ClasesGeneralesFueraDeArbolH.*;
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
	
	public JLabel getLabel() {
		return etiqueta;
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public void setX(int i) {
		rec.x = i;
		etiqueta.setBounds(rec);
	}
	
	public void setY (int i) {
		rec.y = i;
		etiqueta.setBounds(rec);
	}
	
		
	//agregar metodos colisionar() y serVisitado()
}
