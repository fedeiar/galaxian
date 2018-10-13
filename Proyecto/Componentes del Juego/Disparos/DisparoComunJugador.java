package Disparos;

import Logica.Logica;

public class DisparoComunJugador extends DisparoJugador{

	//atributos
	
	//constructor
	
	public DisparoComunJugador(Logica l, double v , int f, double x , double y) {
		super(l,v,f,x,y);
	}
	
	//metodos
	
	public void morir() {
		log.eliminarObjeto(this);
	}
}
