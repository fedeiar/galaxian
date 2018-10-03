package Inteligencias;

import EnemigosConcretos.*;
import java.util.Random;



public class InteligenciaEnemigoConArma extends Inteligencia{
	
	//atributos
	
	protected EnemigoConArma ene;
	int puedo_shoot;
	
	//constructor
	
	public InteligenciaEnemigoConArma(EnemigoConArma e) {
		ene = e;
		puedo_shoot=0;
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
		
		puedo_shoot++;
		if(puedo_shoot==10) {
			int rshoot = ran.nextInt(3);
			if(rshoot<2) { //0.66 chances
				ene.crearDisparo();
						
			}
			
			puedo_shoot=0;
		}
	}
	
	private void moverIzquierda(int ancho) {
		if(ene.getX() - ene.getVelocidadMovimiento() > 0) { 
			ene.setX(ene.getX() - ene.getVelocidadMovimiento()); //  y aca *
		}
	}
	
	private void moverDerecha(int ancho) {
		if(ene.getX() + ene.getVelocidadMovimiento() < ancho - ene.getRectangulo().getWidth()) { //ver rec.getWidth() para ver si entra bien
			ene.setX(ene.getX() + ene.getVelocidadMovimiento()); // aca *
		}
	}

	
	
	
}
