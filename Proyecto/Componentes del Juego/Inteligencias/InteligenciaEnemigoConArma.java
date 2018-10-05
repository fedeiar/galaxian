package Inteligencias;

import EnemigosConcretos.*;
import java.util.Random;



public class InteligenciaEnemigoConArma extends Inteligencia{
	
	//atributos
	
	protected EnemigoConArma ene;
	
	
	//constructor
	
	public InteligenciaEnemigoConArma(EnemigoConArma e) {
		ene = e;
	}
	
	//metodos
	
	public void accionar() {
		
		//con respecto al movimiento
		
		Random ran = new Random();
		int rmov = ran.nextInt(2);
		if(rmov==0) {
			moverIzquierda(AnchoMapa);
		}
		else
			if(rmov==1)
				moverDerecha(AnchoMapa);
		
		//con respecto al disparo
		
		
		if(ene.puedo_shoot()) {
			int rshoot = ran.nextInt(3);
			if(rshoot<2) { //0.66 chances
				ene.crearDisparo();
			}
		}
	}
	
	private void moverIzquierda(int ancho) {
		if(ene.getX() - ene.getVelocidadMovimiento() > 0) { 
			ene.setX(ene.getX() - ene.getVelocidadMovimiento()); //  y aca *
		}
	}
	
	private void moverDerecha(int ancho) {
		if(ene.getX() + ene.getVelocidadMovimiento() < ancho - ene.getAncho()) { //ver rec.getWidth() para ver si entra bien
			ene.setX(ene.getX() + ene.getVelocidadMovimiento()); // aca *
		}
	}

	
	
	
}
