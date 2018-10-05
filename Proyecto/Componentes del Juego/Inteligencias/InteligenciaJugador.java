package Inteligencias;
import Personajes.*;
import Disparos.DisparoJugador;

public class InteligenciaJugador extends Inteligencia{


	//atributos
	
	
	protected Jugador jug;
	
	
	protected int quiero_shoot; //sería si el jugador apreta para disparar
	protected int direccion;
	
	//constructor
	public InteligenciaJugador(Jugador j) {
		jug = j;
		direccion = 0;
		quiero_shoot = 0;
		
	}
	
	//metodos
	
	public void accionar() {
		//---CON RESPECTO AL MOVIMIENTO---
		
		if(direccion==1) {
			moverIzquierda();
		}
		else
			if(direccion==2)
				moverDerecha();
		
		direccion = 0; //para que no se siga moviendo y se quede quieto si no se le ordeno nada.
		
		
		//---CON RESPECTO AL DISPARO---
		
		
		if (jug.puedo_shoot() && quiero_shoot==1) { 
			
			jug.crearDisparo();
			jug.ya_dispare(); //de esta forma "descargo" el disparo
		}
		
		quiero_shoot=0;
		
	}
	
	private void moverIzquierda() {
		if(jug.getX() - jug.getVelocidadMovimiento() > 0) { 
			jug.setX(jug.getX() - jug.getVelocidadMovimiento()); //  y aca *
		}
		else {
			long aux = Math.round(jug.getAncho());
			jug.setX(AnchoMapa - (int)aux); //si bien un long es un int pero mas largo, hace falta casting
			
		}
	}
	
	private void moverDerecha() {
		if(jug.getX() + jug.getVelocidadMovimiento() < AnchoMapa - jug.getAncho()) { //ver rec.getWidth() para ver si entra bien
			jug.setX(jug.getX() + jug.getVelocidadMovimiento()); // aca *
		}
		else
			jug.setX(0);
	}
	
	//metodos especiales para la inteligencia del jugador
	
	public void setDireccion(int dir) {
		direccion = dir;
	}
	
	public void setShoot(int sho) {
		quiero_shoot = sho;
	}
	
	
}
