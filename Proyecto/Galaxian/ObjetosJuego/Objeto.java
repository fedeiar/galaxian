package ObjetosJuego;

public abstract class Objeto {
	
	//atributos
	protected	final static int MAX_X = 800;
	protected	final static int MAX_Y = 600;
	
	protected	int HP;
	protected Posicion P;
	
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
}
