package ObjetoGeneral;


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
	 * m�todo que ser� redefinido acorde al comportamiento de la clase que lo implemente
	 */
	public abstract void accionar() ;
	
	/**
	 * m�todo que sera redefinido por cada clase depende como reacciona al ser eliminado
	 */
	public abstract void morir();
		
	//prototipo colisionar (patron visitor impl�cito)
	
	public abstract void serColisionado(Objeto o);
	
	public abstract void afectarEnemigo(Enemigo e);
	
	public void colisionar(Objeto o) {
		//no posee cuerpo ya que ser� el metodo por defecto en caso de una colision sin efectos
		//e.g: un disparo enemigo con un enemigo.
		System.out.println("entro a Objeto");
	}
	
	
	
}
