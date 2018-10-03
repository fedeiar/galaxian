package Disparos;

import java.awt.*;
import Logica.*;
import javax.swing.*;

import ObjetoGeneral.Objeto;

public abstract class Disparo extends Objeto {

	//atributos
	protected final static int ANCHO = 4;
	protected final static int LARGO = 20;
	
	protected int velocidadMovimiento;
	protected int fuerzaDeImpacto;
	
	
	//constuctor
	
	public Disparo (Logica l,int v ,int f, int x , int y) {
		super(l);
		
		velocidadMovimiento = v;
		fuerzaDeImpacto = f;
		
		
		//---parte grafica del disparo---
		rec = new Rectangle(x,y,ANCHO,LARGO);
		
		etiqueta = new JLabel();
		//hacer un seticon si hace falta
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.RED);
		
	}
	
	//metodos
	
	public int getVelocidad() {
		return velocidadMovimiento;
	}
	
	public int getFuerzaImpacto() {
		return fuerzaDeImpacto;
	}
	
	
	
	//---forma de morir---
	
	public void morir() {
		log.eliminarObjeto(this);
	}
	
	
	
}
