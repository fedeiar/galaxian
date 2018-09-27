package Inteligencias;
import Personajes.*;
import EnemigosConcretos.*;
import java.util.Random;

public abstract class Inteligencia {
	
	//atributos
	
	protected Enemigo ene;
	
	//constructor
	
	public Inteligencia (Enemigo e) {
		ene = e;
		
	}
	
	//metodos
	
	public abstract void mover(int anchoDelMapa);	
}
