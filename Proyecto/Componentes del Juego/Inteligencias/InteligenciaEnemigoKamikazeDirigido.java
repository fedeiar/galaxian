package Inteligencias;
import java.util.Random;

import Personajes.*;
public class InteligenciaEnemigoKamikazeDirigido extends InteligenciaEnemigo{

	//atributos
	protected final static int TIEMPO_ESPERA = 4000;
	protected final double POS_INICIAL;
	
	protected Jugador jugador;
	protected Enemigo ene;
	protected long time;
	
	protected boolean me_tiro;
	protected boolean me_pase;
	//constructor
	
	public InteligenciaEnemigoKamikazeDirigido(Enemigo e, Jugador j) {
		jugador = j;
		ene = e;
		
		POS_INICIAL = ene.getY();
		
		time = System.currentTimeMillis();
		
		me_tiro = false;
		me_pase = false;
	}
	
	//metodos
	
	public void accionar() {
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > TIEMPO_ESPERA) {
			
			if(!me_tiro) {
				Random ran = new Random();
				int r = ran.nextInt(3);
				if(r>=0 && r<2)
					me_tiro=true;
				else
					time = System.currentTimeMillis(); //vuelvo a esperar
			}
			
			if(me_tiro) {
				if(!me_pase)
					bajarRastreando();
				else {
					bajarEnLineaRecta();
				}
			}
			
		}
		else
			this.movimiento_estandar(ene);
	}
	
	private void bajarRastreando() {
		if(ene.getY() + ene.getAlto() < ALTO_MAPA) {
			ene.setY(ene.getY() + ene.getVelocidadMovimiento() * 2);
			
			if(jugador.getX() > ene.getX()) //es decir, si esta a la derecha del enemigo entonces
				ene.setX(ene.getX() + 4);   //lo muevo a la derecha, sino
			else
				ene.setX(ene.getX() - 4);  //a la izquierda.
		}
		else {
			ene.setY(0);
			me_pase=true;
		}
	}
	
	private void bajarEnLineaRecta() {
		if(ene.getY() > POS_INICIAL)
			ene.setY(ene.getY() + ene.getVelocidadMovimiento());
		else {
			ene.setY(POS_INICIAL);
			me_pase = false;
			me_tiro = false;
			time = System.currentTimeMillis();
		}
	}

}
