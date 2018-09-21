package Disparos;

import java.awt.*;
import Logica.*;
import javax.swing.*;

import ObjetoGeneral.Objeto;

public abstract class Disparo extends Objeto {

	//atributos
	protected final static int ANCHO = 4;
	protected final static int LARGO = 5;
	
	protected int velocidadMovimiento;
	protected int fuerzaDeImpacto;
	
	
	//constuctor
	
	public Disparo (Logica l,int v ,int f, int x , int y) {
		super(l);
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
	
	//movimiento
	
	public void accionar() {
		if(this.getY() < 0)
			log.eliminarObjeto(this);
		else
			this.setY(this.getY() - velocidadMovimiento); 
		
	}
	
	public void morir() {
		
	}
	
	
	
}
