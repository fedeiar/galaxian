package NivelEnemigos;

public class NivelEnemigo_1 extends NivelEnemigo {

	//atributos
	
	
	
	//constructor
	
	public NivelEnemigo_1() {
		siguiente = new NivelEnemigo_2() ;
		HP = 2;
		velocidad_movimiento = 3;
		fuerza_impacto = 5;
		puntosQueDa = 50;
		
	}
	
	
}
