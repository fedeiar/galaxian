package ObjetosJuego;

public class Jugador extends Personajes {
	
	//atributos
	
	private final static int MAX_HP=100;

	protected DisparoP D;
	
	
	//constructor
	/**
	 * inicializa a un jugador con una determinada velocidad de movimiento, velocidad de disparo , fuerza del disparo,
	 * puntos de vida, y posicion.
	 * @param v
	 * @param vd
	 */
	public Jugador (int v , int vd , int fd) {
		velocidad = v;
		D = new DisparoP(vd,fd);
		HP = MAX_HP;
		P = new Posicion(20,400);
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
