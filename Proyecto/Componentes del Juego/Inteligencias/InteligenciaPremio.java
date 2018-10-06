package Inteligencias;

import Mapas.Mapa;
import Premios.*;

public class InteligenciaPremio extends Inteligencia {

	//atributos
	
	Premios Pr;
	
	//constructor
	
	public InteligenciaPremio(Premios P) {
		Pr = P;
	}
	
	//metodos
	
	public void accionar() {
		if(Pr.getY() > AltoMapa + Pr.getAlto()) {
			Pr.morir();
		}
		else
			Pr.setY(Pr.getY() + Pr.getVelocidadDeCaida());
	}
}
