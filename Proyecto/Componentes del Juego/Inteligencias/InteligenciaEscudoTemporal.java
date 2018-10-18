package Inteligencias;
import Escudos.*;
import Personajes.*;
import Premios.Premio;
public class InteligenciaEscudoTemporal extends Inteligencia {

	//atributos
	
	private Escudo nuevo_escudo;
	private Escudo viejo_escudo;
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
		
		nuevo_escudo = e;
		viejo_escudo = jugador.getEscudo();
		
		jugador.setEscudo(e);
		
		System.out.println("empezo el escudo");
	}
	
	//metodos
	
	public void accionar() {
		premio.setX(jugador.getX());
		premio.setY(jugador.getY());
		
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > durabilidad) {
			jugador.setEscudo(viejo_escudo);
			premio.morir();
			System.out.println("termino el escudo");
		}
	}
	
	
}
