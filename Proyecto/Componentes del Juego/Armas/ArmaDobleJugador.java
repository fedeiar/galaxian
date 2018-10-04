package Armas;
import Disparos.Disparo;
import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
import Logica.*;

public class ArmaDobleJugador extends Arma{

	//atributos
	
	//constructor
	
	public ArmaDobleJugador(Logica l , int velDisp , int fuerzaDisp) {
		super(l , velDisp, fuerzaDisp);
	}
	
	public void disparar(int x , int y) {
		DisparoComunJugador disparoJ = new DisparoComunJugador(log , velocidadDisparo,fuerzaDisparo, x-10 , y);
		log.agregarObjeto(disparoJ);
		
		disparoJ = new DisparoComunJugador(log , velocidadDisparo , fuerzaDisparo , x+10 , y);
		log.agregarObjeto(disparoJ);
	}
	
}
