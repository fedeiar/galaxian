package Personajes;

public class Nivel_1 extends Nivel {

	//sin atributos
	
	//construtor
	
	public Nivel_1() {
		siguiente = null ; //cuando implementemos nivel_2, ira eso en lugar de null
		velocidadMovimiento = 10;
		HP = 3;
		velocidadDisparo = 20;
		//considerar cambiar el icono por cada nivel
	}
}
