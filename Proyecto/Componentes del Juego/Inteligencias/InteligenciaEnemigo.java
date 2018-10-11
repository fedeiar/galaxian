package Inteligencias;
import java.util.Random;

import Logica.Tiempo;
import Personajes.*;
public abstract class InteligenciaEnemigo extends Inteligencia{ //esta bien esta interfaz intermedia?

	//atributos
	
	
	//constructor
	
	protected InteligenciaEnemigo() {
		super();
	}
	
	//metodos
	
	
	protected void movimiento_estandar(Enemigo ene) { //esta bien pasarlo por parametro? sino como seria con atributos
		Random ran = new Random();
		int rmov = ran.nextInt(2);
		if(rmov==0) {
			moverIzquierda(ene);
		}
		else
			if(rmov==1)
				moverDerecha(ene);
		
		
	}
	
	private void moverIzquierda(Enemigo ene) {
		if(ene.getX() - ene.getVelocidadMovimiento() > 0) { 
			ene.setX(ene.getX() - ene.getVelocidadMovimiento()); //  y aca *
		}
	}
	
	private void moverDerecha(Enemigo ene) {
		if(ene.getX() + ene.getVelocidadMovimiento() < ANCHO_MAPA - ene.getAncho()) { //ver rec.getWidth() para ver si entra bien
			ene.setX(ene.getX() + ene.getVelocidadMovimiento()); // aca *
		}
	}
	
	
}