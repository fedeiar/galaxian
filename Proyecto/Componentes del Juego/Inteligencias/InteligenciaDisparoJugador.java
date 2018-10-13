package Inteligencias;
import Disparos.*;
public class InteligenciaDisparoJugador extends Inteligencia{

	//atributos
	
	protected DisparoJugador disJ;
	
	//constructor
	
	public InteligenciaDisparoJugador(DisparoJugador DJ) {
		disJ = DJ;
	}
	
	//metodos
	
	
	public void accionar() {
		
		if(disJ.getY() < 0)
			disJ.morir();
		else
			disJ.setY(disJ.getY() - disJ.getVelocidad()); 
		
	}

}
