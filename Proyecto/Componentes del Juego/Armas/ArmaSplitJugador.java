package Armas;

import Disparos.DisparoSplit;
import Logica.Logica;

public class ArmaSplitJugador extends ArmaJugador {

	//atributos
	
	
	//constructor
	
	public ArmaSplitJugador(Logica l, double velDisp, int fuerzaDisp) {
		super(l, velDisp, fuerzaDisp);	
		
		cadencia = 350;
	}
	
	
	//metodos

	
	protected void crear_disparo(double x, double y) {
		DisparoSplit disparoS  = new DisparoSplit(log,velocidadDisparo,fuerzaDisparo,x,y,90);
		log.agregarObjeto(disparoS);
	}

}
