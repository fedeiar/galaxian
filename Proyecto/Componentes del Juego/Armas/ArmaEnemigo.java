package Armas;

import Logica.Logica;

public abstract class ArmaEnemigo extends Arma {

	//atributos
	
	//constructor
	
	protected ArmaEnemigo(Logica l, int velDisp, int fuerzaDisp) {
		super(l, velDisp, fuerzaDisp);
	}
	
	//metodos

	
	public boolean puedo_shoot() {
		if(shoot_count<cadencia) {
			shoot_count++;
			return false;
		}
		else {
			shoot_count = 0;
			return true;
		}
				
	}
}
