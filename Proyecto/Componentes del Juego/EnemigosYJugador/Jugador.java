package EnemigosYJugador;

import ClasesGeneralesEnArbolHerencia.Personajes;
import ClasesGeneralesFueraDeArbolH.*;
import Disparo.Disparo;
import Disparo.DisparoP;

public class Jugador extends Personajes {
	
	//atributos
	
	private final static int MAX_HP=100;

	protected DisparoP dis;
	
	
	//constructor
	/**
	 * inicializa a un jugador con una determinada velocidad de movimiento, velocidad de disparo y fuerza del disparo pasados por parametro.
	 * Luego, se le asigna una cantidad de puntos de vida, posicion, y tamaño que ocupa (en pixeles).
	 * @param v
	 * @param vd
	 */
	public Jugador (int v , int vd , int fd) {
		velocidad = v;
		dis = new DisparoP(vd,fd);
		HP = MAX_HP;
		P = new Posicion(400,530);
		dim = new Dimension(50,20);
	}
	
	//metodos
	/**
	 * devuelve el disparo del jugador con todas sus caracteristicas
	 * @return
	 */
	public Disparo getDisparo() {
		return dis;
	}
	
	public void modificarDisparo(int vd,int fd) {
		dis.modificarFuerza(fd);
		dis.modificarVelocidad(vd);
	}
}
