package Armas;

import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
import Logica.Logica;

public class ArmaClasicaJugador extends ArmaJugador{
	
	//atributos
	
	
	//constructor
	
	public ArmaClasicaJugador(Logica l , double velDisp , int fuerzaDisp) {
		super(l , velDisp , fuerzaDisp);
		
		cadencia = 400;
	}
	
	
	//metodos
	
	public void crear_disparo(double x , double y) {
		
		DisparoComunJugador disparoJ = new DisparoComunJugador(log,velocidadDisparo,fuerzaDisparo, x , y , 90);
		log.agregarObjeto(disparoJ);
			
	}

}
