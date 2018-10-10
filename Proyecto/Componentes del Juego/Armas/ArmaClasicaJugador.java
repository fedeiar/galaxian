package Armas;

import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
import Logica.Logica;

public class ArmaClasicaJugador extends ArmaJugador{
	
	//atributos
	
	
	//constructor
	
	public ArmaClasicaJugador(Logica l , int velDisp , int fuerzaDisp) {
		super(l , velDisp , fuerzaDisp);
		
		cadencia = 400;
	}
	
	
	//metodos
	
	public void disparar(int x , int y) {
		long elapsed_time = System.currentTimeMillis() - time;
		if(elapsed_time > cadencia) {
			DisparoComunJugador disparoJ = new DisparoComunJugador(log,velocidadDisparo,fuerzaDisparo, x , y);
			log.agregarObjeto(disparoJ);
			
			time = System.currentTimeMillis(); // renuevo el tiempo para que haya que volver a esperar
		}
	}

}
