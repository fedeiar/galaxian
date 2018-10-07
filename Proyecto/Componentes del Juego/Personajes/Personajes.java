package Personajes;

import Logica.*;

import ObjetoGeneral.Objeto;

import java.awt.Rectangle;
import Armas.*;
public abstract class Personajes extends Objeto {
	
	//atributos
	
	protected int HP; // puntos de vida
	

	
	//constructor
	
	public Personajes(Logica l) {
		super(l);
	}
	
	//metodos
	
	
	public abstract int getVelocidadMovimiento();
	
	public abstract void quitarHP(int n); 
		
	
	
}
