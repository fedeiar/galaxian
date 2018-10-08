package Inteligencias;
import Disparos.*;
import Mapas.Mapa;

public class InteligenciaDisparoEnemigo extends Inteligencia {

	//atributos
	
	protected DisparoEnemigo dispE;
	
	//constructor
	
	public InteligenciaDisparoEnemigo(DisparoEnemigo DE) {
		super();
		dispE = DE;
	}
	
	//metodos
	
	public void accionar() {
			
		if(dispE.getY() > ALTO_MAPA)
			dispE.morir();
		else
			dispE.setY(dispE.getY() + dispE.getVelocidad());
			
	}

	
}
