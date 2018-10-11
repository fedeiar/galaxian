package Inteligencias;
import Personajes.*;
import EnemigosConcretos.*;
import Logica.Logica;
import Mapas.Mapa;

import java.util.Random;
import Logica.*;
public abstract class Inteligencia { //debe extender a alguien?
	
	
	//atributos
	
	protected final static int ANCHO_MAPA=Mapa.MAX_X; //preguntar de donde sacar el ancho
	protected final static int ALTO_MAPA=Mapa.MAX_Y;  //preguntar de donde sacar el ancho
	
	
	//constructor
	
	public Inteligencia () {
	}
	
	//metodos
	
	public abstract void accionar();	
	
	protected  void contar() {
		
	}
	
	//  METODOS HECHOS EXCLUSIVAMENTE PARA InteligenciaJugador,
	//	DONDE ADEMAS SERAN REDEFINIDOS.
	
	public void setDireccion(int n) { 
		
	}
	
	public void setShoot() {
		
	}
	
	public void activarEscudo() {
		
	}
}
