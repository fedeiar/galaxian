package Inteligencias;
import Disparos.*;
import Mapas.Mapa;

public class InteligenciaDisparoEnemigo extends Inteligencia {

	//atributos
	
	protected DisparoEnemigo dispE;
	
	//constructor
	
	public InteligenciaDisparoEnemigo(DisparoEnemigo DE) {
		dispE = DE;
	}
	
	//metodos
	
	public void accionar() {
		if(dispE.getY() > Mapa.MAX_Y)
			dispE.morir();
		else
			dispE.setY(dispE.getY() + dispE.getVelocidad());
	}
}
