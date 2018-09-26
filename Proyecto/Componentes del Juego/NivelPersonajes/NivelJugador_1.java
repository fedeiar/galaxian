package NivelPersonajes;

public class NivelJugador_1 extends NivelPersonaje {

	//sin atributos
	
	//constructor
	
	public NivelJugador_1() {
		siguiente = null ; //cuando implementemos nivelJugador_2, ira eso en lugar de null
		HP = 10;
		velocidadMovimiento = 20;
		velocidadDisparo = 20;
		fuerzaDisparo = 1;
		
	
	}
}
