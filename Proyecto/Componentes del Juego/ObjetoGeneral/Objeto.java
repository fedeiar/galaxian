package ObjetoGeneral;

import Visitors.*;
import java.awt.Rectangle;
import Mapas.*;
import Personajes.Enemigo;

import javax.swing.*;
import Logica.*;

public abstract class Objeto {
	
	//atributos
	
	protected Rectangle rec;
	protected JLabel etiqueta;
	protected ImageIcon imagen;
	protected final static int AnchoMapa=Mapa.MAX_X;
	protected final static int AltoMapa=Mapa.MAX_Y;
	
	protected Logica log;
	protected Visitor vis;
	
	//constructor
	
	public Objeto(Logica l) {
		log = l;
	}
	
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
	
	public int getAncho() {
		return rec.width;
	}
	
	public int getAlto() {
		return rec.height;
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
	public abstract void accionar() ;
	
	/**
	 * método que sera redefinido por cada clase depende como reacciona al ser eliminado
	 */
	public abstract void morir();
		
	//---prototipo colisionar (patron visitor implícito)---
	
	//la idea de este metodo es poder obtener el visitor de forma dinamica de cada objeto desde logica. preguntar si esta bien.
	public Visitor getVisitor() {
		return vis;
	}
	
	public abstract void serVisitado(Visitor v);
	
	
	
	
}
