package Armas;

import Logica.Logica;

public abstract class ArmaJugador extends Arma{

	//atributos
	private boolean dispare;
	
	//constructor
	
	protected ArmaJugador(Logica l, int velDisp, int fuerzaDisp) {
		super(l, velDisp, fuerzaDisp);
		dispare = false;
	}
	
	//metodos
	
	public boolean puedo_shoot() {
		if(!dispare) {
			if(shoot_count < cadencia) {
				shoot_count++;
			}
			else {
				shoot_count = 0;
				dispare = true;
			}
		}
		
		return dispare;
	}
	
	public void ya_dispare() {
		dispare = false;
	}

}
