package Armas;

import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
import Logica.Logica;

public class ArmaClasicaJugador extends ArmaJugador{
	
	//atributos
	
	//constructor
	
	public ArmaClasicaJugador(Logica l , int velDisp , int fuerzaDisp) {
		super(l , velDisp , fuerzaDisp);
		
		cadencia = 5;
	}
	
	
	//metodos
	
	public void disparar(int x , int y) {
		DisparoComunJugador disparoJ = new DisparoComunJugador(log,velocidadDisparo,fuerzaDisparo, x , y);
		log.agregarObjeto(disparoJ);
	}

}
