package ClasesMasGenerales;

public abstract class Personajes extends Objeto {
	
	//atributos
	
	protected int velocidad;
	
	
	//metodos
	
	public int getVelocidad() {
		return velocidad;
	}
	/**
	 * a la velocidad actual le añade (o resta) el entero pasado por parametro.
	 * @param v
	 */
	public void modificarVelocidad(int v) {
		velocidad += v;
	}
	
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
		else {
			if (!(P.getx() + x <0))
				P.setx(0);
			else {
				if(!(P.getx() + x > MAX_X))
					P.setx(MAX_X);
				else {
					if(!(P.gety() + y < 0))
						P.sety(0);
					else {
						if(!(P.gety() + y > MAX_Y))
							P.sety(MAX_Y);
					}
				}
			}
		}
		
	}
}
