package ObjetosDelJuego;

import java.awt.*;

import javax.swing.*;

public class Disparo extends Objeto {

	//atributos
	private final static int ANCHO = 4;
	private final static int LARGO = 5;
	
	private int velocidadMovimiento;
	private int fuerzaDeImpacto;
	//constuctor
	
	public Disparo (int v ,int f, int x , int y) {
		rec = new Rectangle(x,y,ANCHO,LARGO);
		velocidadMovimiento = v;
		fuerzaDeImpacto = f;
		
		etiqueta = new JLabel();
		//hacerle un seticon si hace falta
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.YELLOW);
		
	}
	
	//metodos
	
	public int getVelocidad() {
		return velocidadMovimiento;
	}
	
	public int getFuerzaImpacto() {
		return fuerzaDeImpacto;
	}
	
	
	
}
