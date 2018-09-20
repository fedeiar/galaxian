package Personajes;

import Logica.*;
import NivelPersonajes.NivelPersonaje;
import ObjetoGeneral.Objeto;

import java.awt.Rectangle;

public abstract class Personajes extends Objeto {
	
	//atributos
	protected final static int ANCHO = 30;
	protected final static int ALTO = 30;
	
	protected NivelPersonaje miNivel;
	
	protected int HP; // puntos de vida
	
	//protected Logica log;
	
	//constructor
	
	public Personajes(Logica l ,int x , int y) {
		super(l);
		rec = new Rectangle(x,y,ANCHO,ALTO);
		//log = l;
		
	}
	//metodos
	
	public abstract int getVelocidadDisparo();
	
	public abstract int getVelocidadMovimiento();
	
	public abstract int getHP();
	
	public abstract void quitarHP(int n); 
		
	
	
	
}
