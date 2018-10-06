package Inteligencias;
import EnemigosConcretos.*;
public class InteligenciaEnemigoKamikaze extends Inteligencia {

	//atributos
	
	protected final int pos_inicial;
	
	
	EnemigoKamikaze ene;
	protected int esperar_antes_de_tirarse;
		
	//constructor
	
	public InteligenciaEnemigoKamikaze(EnemigoKamikaze e) {
		ene = e;
		esperar_antes_de_tirarse = 0;
		
		pos_inicial = e.getY();
	}
	
	//metodos
	
	public void accionar() {
		esperar_antes_de_tirarse++;
		
		if(esperar_antes_de_tirarse == 100) { 
			if(ene.getY() + ene.getAlto() < AltoMapa) {
				ene.setY(ene.getY() + ene.getVelocidadMovimiento());
			}
			else
			
		}
	}
	
	private void bajar() {
		
	}
	
	
}
