package Inteligencias;
import java.util.Random;

import Logica.Tiempo;
import Personajes.*;
public abstract class InteligenciaEnemigo extends Inteligencia{ //esta bien esta interfaz intermedia?

	//atributos
	
	protected boolean puedo_accionar;
	
	//constructor
	
	protected InteligenciaEnemigo() {
		super();
		puedo_accionar = true;
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
	
	//---CONTADOR Y SER CONGELADO---
	
	public void congelar() {
		puedo_accionar = false;
		contador = 0;
	}
	
	protected void contar() {
		contador++;
		int segundos = 4000/Tiempo.SLEEP_TIME; //2 segundos, para 3 segundos cambiar 2000 por 3000 por ejemplo.
		if(contador == segundos) {
			contador=0;	
			puedo_accionar = true;
		}
	}
	
}