package Personajes;

import Inteligencias.*;
import Logica.*;

public abstract class Enemigo extends Personajes {

	//atributos
	
	
	protected Inteligencia inteligencia;
	protected NivelEnemigo_1 miNivel; // redefine el atributo de personaje
	
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
	
	public void quitarHP(int n) {
		if( HP - n > 0)
			HP -= n;
		else {
			//habria que destruir al enemigo
		}
	}
	
	public int getPuntaje() {
		return miNivel.getPuntaje();
	}
}
