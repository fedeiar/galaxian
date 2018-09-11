package Personajes;

import Logica.*;

public abstract class Enemigo extends Personajes {

	//atributos
	
	
	protected Inteligencia inteligencia;
	
	//constructor
	
	public Enemigo(int x, int y, Logica l , int nivel) {
		super(x,y,l);
		setNivel(nivel);
		miNivel = new NivelEnemigo_1();
		
		//no inicializamos los demas atributos porque estan en miNivel.
		//y como los enemigos no agarran powerups, van a permanecer constantes.
	}
	
	private void setNivel(int n) {
		if (n==1)
			miNivel = new NivelEnemigo_1();
		else {
			//mas adelante cuando esten implementados los otros nivelEnemigo_, iran aqui
		}
	}
	
	//metodos
	
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}
	
	public void setInteligencia(Inteligencia i) {
		inteligencia = i;
	}
	
	
}
