package Inteligencias;
import Personajes.*;
import EnemigosConcretos.*;
import java.util.Random;

public abstract class Inteligencia {
	
	//atributos
	
	private Enemigo ene;
	
	//constructor
	
	public Inteligencia (Enemigo e) {
		ene = e;
		
	}
	//metodos
	
	public void mover(int anchoDelMapa) {
		Random ran = new Random();
		int mov = ran.nextInt(2);
		if(mov==0) {
			moverIzquierda(anchoDelMapa);
		}
		else
			if(mov==1)
				moverDerecha(anchoDelMapa);
	}
	
	private void moverIzquierda(int ancho) {
		if(ene.getX() - ene.getVelocidadMovimiento() > 0) { 
			ene.setX(ene.getX() - ene.getVelocidadMovimiento()); //  y aca *
		}
	}
	
	private void moverDerecha(int ancho) {
		if(ene.getX() + ene.getVelocidadMovimiento() < ancho - ene.getRectangulo().getWidth()) { //ver rec.getWidth() para ver si entra bien
			ene.setX(ene.getX() + ene.getVelocidadMovimiento()); // aca *
		}
	}
	
}
