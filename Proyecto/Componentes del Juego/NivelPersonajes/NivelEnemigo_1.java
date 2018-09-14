package NivelPersonajes;

public class NivelEnemigo_1 extends NivelPersonaje {

	//atributos
	
	protected int puntosQueDa;
	
	//constructor
	
	public NivelEnemigo_1() {
		siguiente = null ; //cuando implementemos nivelEnemigo_2, ira eso en lugar de null
		velocidadMovimiento = 10;
		HP = 1;
		velocidadDisparo = 10;
		
		puntosQueDa = 50;
		//los enemigos no tendran icono desde miNivel, ya que el icono cambia dependiendo del tipo de enemigo.
	}
	
	public int getPuntaje() {
		return puntosQueDa;
	}
	
}
