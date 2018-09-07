package EnemigosYJugador;

import ClasesGeneralesEnArbolHerencia.Personajes;
import Inteligencias.Inteligencia;

public abstract class Enemigo extends Personajes {

	//atributos
	
	protected int puntos;
	protected Inteligencia inteligencia;

	
	//metodos
	
	/**
	 * Devuelve los puntos que otorga el enemigo al ser eliminado.
	 * @return
	 */
	public int getPuntos() {
		return puntos;
	}
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}
	
	/**
	 * Se establece cuantos puntos otorgara el enemigo al ser eliminado.
	 * @param p
	 */
	public void setPuntos(int p) {
		puntos = p;
	}
	
	public void setInteligencia(Inteligencia i) {
		inteligencia = i;
	}
	
}
