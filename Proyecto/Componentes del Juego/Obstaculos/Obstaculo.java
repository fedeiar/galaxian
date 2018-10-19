package Obstaculos;

import Inteligencias.InteligenciaDummyPermanente;
import Logica.Logica;
import ObjetoGeneral.Objeto;

public abstract class Obstaculo extends Objeto {

	//atributos
	
	protected int HP;
	
	//constructor
		public Obstaculo(Logica l , double x ,double y) {
			super(l);
			inteligencia = new InteligenciaDummyPermanente();
			
		}
		
	//metodos

}
