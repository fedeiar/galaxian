package Inteligencias;
import Personajes.*;
import EnemigosConcretos.*;
import Mapas.Mapa;

import java.util.Random;

public abstract class Inteligencia { //debe extender a alguien?
	
	protected final static int AnchoMapa=Mapa.MAX_X; //preguntar de donde sacar el ancho
	protected final static int AltoMapa=Mapa.MAX_Y;  //preguntar de donde sacar el ancho
	
	//atributos
	
	
	
	//constructor
	
	public Inteligencia () {
		
	}
	
	//metodos
	
	public abstract void accionar();	
}
