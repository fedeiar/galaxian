package Premios;

import Logica.Logica;
import Visitors.VisitorPremio;

public abstract class MagiaTemporal extends Premio implements Runnable{

	//atributos
	
	//constructor
	
	public MagiaTemporal(int x , int y , int velCaida, Logica l) {
		super(x,y,velCaida,l);
		
	}
	
	//metodos

}
