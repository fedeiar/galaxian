package Inteligencias;
import Personajes.*;
import EnemigosConcretos.*;
import Logica.Logica;

import java.awt.Rectangle;
import java.util.Random;
import Disparos.*;


public class InteligenciaEnemigoConArma extends Inteligencia{
	
	//atributos
	
	protected EnemigoConArma ene;
	int puedo_shoot;
	
	//constructor
	
	public InteligenciaEnemigoConArma(EnemigoConArma e , Logica l) {
		ene = e;
		log = l;
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
				DisparoEnemigo disparoE = new DisparoEnemigo(log,ene.getVelocidadDisparo(),ene.getFuerzaDisparo()
											  , ene.getX() + ene.getAncho() / 2 , ene.getY() + ene.getAlto() );
				log.agregarObjeto(disparoE);
						
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
