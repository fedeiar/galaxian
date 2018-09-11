package ObjetosDelJuego;

public class Disparo extends Objeto {

	//atributos
	private final static int ANCHO = 10;
	private final static int LARGO = 5;
	
	private int velocidadMovimiento;
	
	//constuctor
	
	public Disparo (int v) {
		velocidadMovimiento = v;
		
	}
	
	//metodos
	
	public int getVelocidad() {
		return velocidadMovimiento;
	}
	
	
	
}
