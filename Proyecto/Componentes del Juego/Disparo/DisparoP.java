package Disparo;

public class DisparoP implements Disparo {

	//atributos
	
	private int velocidad;
	private int fuerzaDeImpacto;
	
	//constuctor
	
	public DisparoP (int v , int f) {
		velocidad = v;
		fuerzaDeImpacto = f;
	}
	
	//metodos
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public int getFuerza() {
		return fuerzaDeImpacto;
	}
	
	/**
	 * le suma (o resta) a la velocidad actual el entero pasado por parametro.
	 * @param v
	 */
	public void modificarVelocidad(int v) {
		velocidad += v;
	}
	
	/**
	 * le suma (o resta) a la fuerza de impacto actual el entero pasado por parametro.
	 * @param v
	 */
	public void modificarFuerza(int f) {
		fuerzaDeImpacto += f;
	}
}
