package Armas;

import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
import Logica.Logica;

public class ArmaClasicaJugador extends Arma{
	
	//atributos

	//constructor
	
	public ArmaClasicaJugador(Logica l) {
		super(l);
		fuerzaDisparo = 2;
		velocidadDisparo = 20;
		cadencia = 400;
	}
	
	
	//metodos
	
	public void crear_disparo(double x , double y) {
		
		DisparoComunJugador disparoJ = new DisparoComunJugador(log,velocidadDisparo,fuerzaDisparo, x , y , 90);
		log.agregarObjeto(disparoJ);
			
	}

}
