package Personajes;

import Logica.*;
import ObjetosDelJuego.Objeto;

import java.awt.Rectangle;

public abstract class Personajes extends Objeto {
	
	//atributos
	protected final static int ANCHO = 50;
	protected final static int ALTO = 20;
	
	protected NivelPersonaje miNivel;
	
	protected int velocidadMovimiento;
	protected int HP; //puntos de vida
	protected int velocidadDisparo;
	
	
	protected Logica log;
	
	//constructor
	
	public Personajes(int x , int y , Logica l ) {
		rec = new Rectangle(x,y,ANCHO,ALTO);
		log = l;
		
	}
	//metodos
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
}
