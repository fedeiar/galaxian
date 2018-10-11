package ObjetoGeneral;
import Inteligencias.*;
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
	
	protected Inteligencia inteligencia;
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
	
	
	/**
	 * método que sera redefinido por cada clase depende como reacciona al ser eliminado
	 */
	public abstract void morir();
	
	
	//----INTELIGENCIA----
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}
	
	public void setInteligencia(Inteligencia i) {
		inteligencia = i;
	}
	
	/**
	* todos los objetos recurren a su inteligencia para ACCIONAR
	*/
	public  void accionar() {
		inteligencia.accionar();
	}
			
	//---VISITOR---
	
	
	public void chocar(Objeto o) {
		o.serVisitado(this.vis);  // sería el "aceptar(Visitor v)"
	}
	
	public abstract void serVisitado(Visitor v);
	
	
	
	
}
