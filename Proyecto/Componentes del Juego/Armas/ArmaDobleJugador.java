package Armas;

import Disparos.DisparoComunJugador;

import Logica.*;

public class ArmaDobleJugador extends ArmaJugador{

	//atributos
	
	//constructor
	
	public ArmaDobleJugador(Logica l , double velDisp , int fuerzaDisp) {
		super(l , velDisp, fuerzaDisp);
		
		cadencia = 200;
	}
	
	//metodos
	
	public void crear_disparo(double x , double y) {
		
		DisparoComunJugador disparoJ = new DisparoComunJugador(log , velocidadDisparo,fuerzaDisparo, x-10 , y , 110);
		log.agregarObjeto(disparoJ);
		
		disparoJ = new DisparoComunJugador(log , velocidadDisparo , fuerzaDisparo , x+10 , y , 70);
		log.agregarObjeto(disparoJ);
			
	}
	
}
