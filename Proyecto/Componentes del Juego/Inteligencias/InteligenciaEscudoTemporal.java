package Inteligencias;
import TDALista.*;

import Escudos.*;
import Personajes.*;
import Premios.Premio;
public class InteligenciaEscudoTemporal extends Inteligencia {

	//atributos
	
	
	private Jugador jugador;
	private Premio premio;
	private long time;
	private int durabilidad;
	
	//constructor
	
	public InteligenciaEscudoTemporal(Premio p ,Escudo e , Jugador j , int dur) {
		premio = p;
		jugador = j;
		time = System.currentTimeMillis();
		durabilidad = dur;
		
		
		
		System.out.println("empezo el escudo");
	}
	
	//metodos
	
	public void accionar() {
		premio.setX(jugador.getX());
		premio.setY(jugador.getY());
		
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > durabilidad) {
			jugador.eliminarEscudoTemporal();
			premio.morir();
			System.out.println("termino el escudo");
		}
	}
	
	
}
