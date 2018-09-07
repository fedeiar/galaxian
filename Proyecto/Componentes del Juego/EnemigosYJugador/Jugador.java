package EnemigosYJugador;

import ClasesGeneralesEnArbolHerencia.Personajes;
import ClasesGeneralesFueraDeArbolH.Posicion;
import Disparo.Disparo;
import Disparo.DisparoP;

public class Jugador extends Personajes {
	
	//atributos
	
	private final static int MAX_HP=100;

	protected DisparoP D;
	
	
	//constructor
	/**
	 * inicializa a un jugador con una determinada velocidad de movimiento, velocidad de disparo y fuerza del disparo pasados por parametro.
	 * Luego, se le asigna una cantidad de puntos de vida, posicion, y tamaño que ocupa (en pixeles).
	 * @param v
	 * @param vd
	 */
	public Jugador (int v , int vd , int fd) {
		velocidad = v;
		D = new DisparoP(vd,fd);
		HP = MAX_HP;
		P = new Posicion(20,400);
		ancho = 5;
		alto = 5;
	}
	
	//metodos
	/**
	 * devuelve el disparo del jugador con todas sus caracteristicas
	 * @return
	 */
	public Disparo getDisparo() {
		return D;
	}
	
	public void modificarDisparo(int vd,int fd) {
		D.modificarFuerza(fd);
		D.modificarVelocidad(vd);
	}
}
