package Escudos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Escudo{

	//atributos
	protected final static int ANCHO = 20;
	protected final static int ALTO = 20;
	protected final  double POS_X = 0;
	protected final  double POS_Y = 20;
	
	protected double pos_x;
	protected double pos_y;
	
	protected JLabel etiqueta;
	protected Rectangle rec;
	protected ImageIcon imagen;
	
	
	//constructor
	
	protected Escudo() {
		
	}
	
	//metodos
	
	public abstract int getDaño(int n);
	
	public Rectangle crear_rectangulo(double x , double y , int ancho , int alto) {
		pos_x = x;
		pos_y = y;
		int rounded_x = (int) Math.round(pos_x);
		int rounded_y = (int) Math.round(pos_y);
		Rectangle R = new Rectangle(rounded_x,rounded_y,ancho,alto);
		
		return R;
	}
	
}
