
public abstract class Personajes extends Objeto {
	
	//atributos
	
	
	//metodos
	/**
	 * Desplaza al personaje X posiciones en horizontal e Y posiciones en vertical 
	 * @param x
	 * @param y
	 */
	
	public void desplazar(int x , int y) {
		//es decir, si no se salio de los limites
		if(!(P.getx() + x <0) && !(P.getx() + x > MAX_X) && !(P.gety() + y < 0) && !(P.gety() + y > MAX_Y)) {
			P.setx(P.getx() + x);
			P.sety(P.gety() + y);
		}
	}
}
