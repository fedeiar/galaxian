package Visitors;

import Logica.Logica;
import Personajes.*;
public abstract class Visitor {

	//atributos
	
	protected Logica log; //preguntar, no respeta el patron al 100% pero hace falta para eliminar por ejemplo el disparo.
	
	//constructor
	
	public Visitor(Logica l) {
		log = l;
	}
	
	//metodos
	
	public void afectarEnemigo(Enemigo e) {}
}
