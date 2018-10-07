package Inteligencias;
import EnemigosConcretos.*;
public class InteligenciaEnemigoKamikaze extends InteligenciaEnemigo {

	//atributos
	protected final static int ESPERA_CUMPLIDA = 50;
	protected final int pos_inicial;
	
	protected boolean me_pase;
	
	EnemigoKamikaze ene;
	protected int esperar_antes_de_tirarse;
		
	//constructor
	
	public InteligenciaEnemigoKamikaze(EnemigoKamikaze e) {
		ene = e;
		esperar_antes_de_tirarse = 0;
		
		pos_inicial = e.getY();
		me_pase = false;
	}
	
	//metodos
	
	public void accionar() {
		if(esperar_antes_de_tirarse < ESPERA_CUMPLIDA)
		esperar_antes_de_tirarse++;
		
		if(esperar_antes_de_tirarse == ESPERA_CUMPLIDA) { 
			
			if(ene.getY() + ene.getAlto() < ALTO_MAPA) {
				
				bajar();
				
				if(me_pase && ( ene.getY() > pos_inicial) ){
					me_pase = false;
					esperar_antes_de_tirarse = 0;	
				}
				
			}
			else {
				ene.setY(0);
				me_pase = true;
			}
			
		}
		else {
			movimiento_estandar(ene);
		}
		
	}
	
	private void bajar() {
		ene.setY(ene.getY() + ene.getVelocidadMovimientoVertical());
	}
	
	
}
