package Inteligencias;
import java.util.Random;

import EnemigosConcretos.*;
public class InteligenciaEnemigoKamikaze extends InteligenciaEnemigo {

	//atributos
	protected final static int ESPERA_CUMPLIDA = 50;
	protected final int POS_INICIAL;
	
	protected boolean me_pase;
	protected boolean me_tiro;
	
	EnemigoKamikaze ene;
	protected int esperar_antes_de_tirarse;
		
	//constructor
	
	public InteligenciaEnemigoKamikaze(EnemigoKamikaze e) {
		super();
		ene = e;
		esperar_antes_de_tirarse = 0;
		
		POS_INICIAL = e.getY();
		me_pase = false;
		me_tiro = false;
	}
	
	//metodos
	
	public void accionar() {
		if(puedo_accionar) {
			
			if(esperar_antes_de_tirarse == ESPERA_CUMPLIDA) {
			
				if(!me_tiro) {
					Random ran = new Random();
					int r = ran.nextInt(3);
					if(r>=0 && r<2)
						me_tiro=true;
					else
						esperar_antes_de_tirarse = 0;
				}
			
				if(ene.getY() + ene.getAlto() < ALTO_MAPA) {
				
					if(me_tiro) {
					
						bajar();
				
						if(me_pase && ( ene.getY() > POS_INICIAL) ){
							ene.setY(POS_INICIAL);
							me_pase = false;
							me_tiro = false;
							esperar_antes_de_tirarse = 0;	
						}
					
					}
				
				}
				else {
					ene.setY(0);
					me_pase = true;
				}
			
			}
			else {
				esperar_antes_de_tirarse++;
				movimiento_estandar(ene);
			}
			
		}
		else
			contar();
	}
	
	private void bajar() {
		ene.setY(ene.getY() + (ene.getVelocidadMovimiento() * 3) );
		
		Random ran = new Random();
		int r = ran.nextInt(2);
		if(r==0) {
			
			if(ene.getX() + ene.getAncho() < ANCHO_MAPA) {
				ene.setX(ene.getX() + ene.getVelocidadMovimiento());
			}
			else {
				ene.setX(0);
			}
			
		}
		else {
			
			if(ene.getX() > 0) {
				ene.setX(ene.getX() - ene.getVelocidadMovimiento());
			}
			else {
				ene.setX(ANCHO_MAPA - ene.getAncho());
			}
			
		}
	}
	
	
}
