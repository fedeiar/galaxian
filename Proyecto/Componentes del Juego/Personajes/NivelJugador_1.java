package Personajes;

public class NivelJugador_1 extends NivelPersonaje {

	//sin atributos
	
	//constructor
	
	public NivelJugador_1() {
		siguiente = null ; //cuando implementemos nivelJugador_2, ira eso en lugar de null
		velocidadMovimiento = 10;
		HP = 3;
		velocidadDisparo = 20;
		//considerar cambiar el icono por cada nivel
	}
}