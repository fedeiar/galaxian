package Personajes;

import Logica.*;

import ObjetoGeneral.Objeto;

import java.awt.Rectangle;
import Armas.*;
public abstract class Personajes extends Objeto {
	
	//atributos
	
	protected final static int ANCHO = 30;
	protected final static int ALTO = 30;
	
	
	
	protected int HP; // puntos de vida
	

	
	//constructor
	
	public Personajes(Logica l ,int x , int y) {
		super(l);
		rec = new Rectangle(x,y,ANCHO,ALTO);
		
		
	}
	
	//metodos
	
	
	public abstract int getVelocidadMovimiento();
	
	public abstract int getHP();
	
	public abstract void quitarHP(int n); 
		
	
	
}
