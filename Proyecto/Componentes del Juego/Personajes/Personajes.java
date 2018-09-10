package Personajes;

import Logica.*;
import ObjetosDelJuego.Objeto;

import java.awt.Rectangle;

public abstract class Personajes extends Objeto {
	
	//atributos
	
	protected int velocidadMovimiento;
	protected int HP; //puntos de vida
	protected int velocidadDisparo;
	
	
	protected Logica log;
	
	//constructor
	
	public Personajes(int x , int y , Logica l ) {
		rec = new Rectangle(x,y,40,20);
		log = l;
		
	}
	//metodos
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
	}
