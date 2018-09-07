package ClasesGeneralesEnArbolHerencia;

import ClasesGeneralesFueraDeArbolH.Posicion;

public abstract class Objeto {
	
	//atributos
	
	//mudar estos atributos a la GUI
	
	
	protected	int HP;
	
	protected Posicion P;
	
	protected int ancho;
	protected int alto;
	
	//metodos
	
	public int obtenerHP() {
		return HP;
	}
	
	/**
	 * le resta o suma a la vida actual del personaje, el entero pasado por parametro
	 * @param hp
	 */
	
	public void modificarHP(int hp) {
		if (HP - hp > 0)
			HP -= hp;
		else
			HP=0;
	}
	
	public Posicion getPosicion() {
		return P;
	}
	
	
	/**
	 * ubica al jugador en la posicion (x,y) pasada por parametro
	 * @param x
	 * @param y
	 */
	public void ubicarObjeto (int x , int y) {
		P.setx(x);
		P.sety(y);
	}
	
	//agregar metodos colisionar() y serVisitado()
}
