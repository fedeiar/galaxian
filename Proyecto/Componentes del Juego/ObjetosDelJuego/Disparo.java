package ObjetosDelJuego;

import java.awt.*;

import javax.swing.*;

public class Disparo extends Objeto {

	//atributos
	private final static int ANCHO = 4;
	private final static int LARGO = 5;
	
	private int velocidadMovimiento;
	
	//constuctor
	
	public Disparo (int v , int x , int y) {
		rec = new Rectangle(x,y,ANCHO,LARGO);
		velocidadMovimiento = v;
		
		etiqueta = new JLabel();
		//hacerle un seticon si hace falta
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.YELLOW);
		
	}
	
	//metodos
	
	public int getVelocidad() {
		return velocidadMovimiento;
	}
	
	
	
}
