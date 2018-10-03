package Inteligencias;
import Personajes.*;
public class InteligenciaJugador extends Inteligencia{


	//atributos
	
	int direccion;
	Jugador jug;
	
	//constructor
	public InteligenciaJugador(Jugador j) {
		jug = j;
		direccion = 0;
	}
	
	//metodos
	
	public void accionar() {
		
		if(direccion==1) {
			moverIzquierda();
		}
		else
			if(direccion==2)
				moverDerecha();
		
		direccion = 0; //para que no se siga moviendo y se quede quieto si no se le ordeno nada.
		
	}
	
	private void moverIzquierda() {
		if(jug.getX() - jug.getVelocidadMovimiento() > 0) { 
			jug.setX(jug.getX() - jug.getVelocidadMovimiento()); //  y aca *
		}
		else {
			long aux = Math.round(jug.getAncho());
			jug.setX(AnchoMapa - (int)aux); //si bien un long es un int pero mas largo, hace falta casting
			
		}
	}
	
	private void moverDerecha() {
		if(jug.getX() + jug.getVelocidadMovimiento() < AnchoMapa - jug.getAncho()) { //ver rec.getWidth() para ver si entra bien
			jug.setX(jug.getX() + jug.getVelocidadMovimiento()); // aca *
		}
		else
			jug.setX(0);
	}
	
	public void setDireccion(int dir) {
		direccion = dir;
	}

}
