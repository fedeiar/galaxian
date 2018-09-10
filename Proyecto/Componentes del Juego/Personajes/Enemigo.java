package Personajes;

import Logica.*;

public abstract class Enemigo extends Personajes {

	//atributos
	
	protected int puntosQueDa;
	protected Inteligencia inteligencia;
	
	//constructor
	
	public Enemigo(int x, int y, Logica l) {
		super(x,y,l);
	}
	
	//metodos
	
	/**
	 * Devuelve los puntos que otorga el enemigo al ser eliminado.
	 * @return
	 */
	public int getPuntos() {
		return puntosQueDa;
	}
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}
	
	/**
	 * Se establece cuantos puntos otorgara el enemigo al ser eliminado.
	 * @param p
	 */
	public void setPuntos(int p) {
		puntosQueDa = p;
	}
	
	public void setInteligencia(Inteligencia i) {
		inteligencia = i;
	}
	
}
