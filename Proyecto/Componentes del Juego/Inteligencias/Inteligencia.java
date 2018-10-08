package Inteligencias;
import Personajes.*;
import EnemigosConcretos.*;
import Logica.Logica;
import Mapas.Mapa;

import java.util.Random;
import Logica.*;
public abstract class Inteligencia { //debe extender a alguien?
	
	protected final static int ANCHO_MAPA=Mapa.MAX_X; //preguntar de donde sacar el ancho
	protected final static int ALTO_MAPA=Mapa.MAX_Y;  //preguntar de donde sacar el ancho
	
	//atributos
	
	protected boolean puedo_accionar;
	protected int contador;
	
	//constructor
	
	public Inteligencia () {
		puedo_accionar = true;
		contador = 0;
	}
	
	//metodos
	
	public abstract void accionar();	
	
	public void congelar() {
		puedo_accionar = false;
		contador = 0;
	}
	
	protected  void contar() {	
		
	}
	
	public void setDireccion(int n) { 
		/*
		metodo hecho exclusivamente para inteligenciaJugador,
		donde ademas será redefinido.
		*/
	}
	
	public void setShoot() {
		/*
		metodo hecho exclusivamente para inteligenciaJugador,
		donde ademas será redefinido.
		*/
	}
	
	public void activarEscudo() {
		/*
		metodo hecho exclusivamente para inteligenciaJugador,
		donde ademas será redefinido.
		*/
	}
}
