package Escudos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Escudo{

	//atributos
	protected final static int ANCHO = 20;
	protected final static int ALTO = 20;
	protected final  int POS_X = 0;
	protected final  int POS_Y = 20;
	
	protected JLabel etiqueta;
	protected Rectangle rec;
	protected ImageIcon imagen;
	
	
	//constructor
	
	protected Escudo() {
		
	}
	
	//metodos
	
	public abstract int getDaño(int n);
	
	
	
}
