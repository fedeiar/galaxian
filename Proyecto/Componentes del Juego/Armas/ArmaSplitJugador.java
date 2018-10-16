package Armas;

import Disparos.DisparoSplit;
import Logica.Logica;

public class ArmaSplitJugador extends Arma{

	//atributos

	//constructor
	
	public ArmaSplitJugador(Logica l) {
		super(l);	
		velocidadDisparo = 20;
		fuerzaDisparo = 4;
		cadencia = 350;
	}
	
	
	//metodos

	
	protected void crear_disparo(double x, double y) {
		DisparoSplit disparoS  = new DisparoSplit(log,velocidadDisparo,fuerzaDisparo,x,y,90);
		log.agregarObjeto(disparoS);
	}

}
