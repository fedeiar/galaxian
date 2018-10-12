package Escudos;
import Personajes.*;
public class ShieldManager {

	//como hago para que si un thread quiere usar este setEscudo, y  el thread que lo está ocupando termine inmediatamente
	//(finalizando el metodo, o almenos ejecutando un finally) y empiece a operar el otro thread?
	public static synchronized void setEscudo(Jugador jug , Escudo nuevo_escudo ,int durabilidad) throws InterruptedException {
		
			System.out.println("entre a la operacion");
			
			Escudo viejo_escudo = jug.getEscudo();
			jug.setEscudo(nuevo_escudo);
			
			Thread.sleep(durabilidad); //de alguna forma, si otro thread quiere ingresar al metodo, quiero que el thread que
								//estaba "durmiendo" se "despierte", termine el metodo y asi dejar ingresar al otro thread,
								//con el fin de reiniciar el tiempo del escudo, no sumarselo al tiempo que faltaba.
			
			jug.setEscudo(viejo_escudo);
			
			System.out.println("sali de la operacion");
		
	}
	
}
