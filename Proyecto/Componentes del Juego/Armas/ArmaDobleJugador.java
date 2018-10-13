package Armas;
import Disparos.Disparo;
import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
import Logica.*;

public class ArmaDobleJugador extends ArmaJugador{

	//atributos
	
	//constructor
	
	public ArmaDobleJugador(Logica l , double velDisp , int fuerzaDisp) {
		super(l , velDisp, fuerzaDisp);
		
		cadencia = 200;
	}
	
	public void crear_disparo(double x , double y) {
		
		DisparoComunJugador disparoJ = new DisparoComunJugador(log , velocidadDisparo,fuerzaDisparo, x-10 , y);
		log.agregarObjeto(disparoJ);
		
		disparoJ = new DisparoComunJugador(log , velocidadDisparo , fuerzaDisparo , x+10 , y);
		log.agregarObjeto(disparoJ);
			
	}
	
}
