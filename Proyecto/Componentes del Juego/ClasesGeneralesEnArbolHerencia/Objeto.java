package ClasesGeneralesEnArbolHerencia;

import ClasesGeneralesFueraDeArbolH.*;

public abstract class Objeto {
	
	//atributos
	
	//mudar estos atributos a la GUI
	
	
	protected	int HP;
	
	protected Posicion P;
	
	protected Dimension dim;
	
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
	public void setPosicion (int x , int y) {
		P.setx(x);
		P.sety(y);
	}
	
	public Dimension getDimension() {
		return dim;
	}
	
	public void setDimension(int ancho , int alto) {
		dim.setAncho(ancho);
		dim.setAlto(alto);
	}
	
	//agregar metodos colisionar() y serVisitado()
}
