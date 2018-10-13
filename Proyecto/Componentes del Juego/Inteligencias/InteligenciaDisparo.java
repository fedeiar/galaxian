package Inteligencias;
import Disparos.*;
public abstract class InteligenciaDisparo extends Inteligencia{

	//atributos
	
	protected Disparo disp;
	double direccion; 
	
	//constructor

	public InteligenciaDisparo(Disparo d , double direc) { //la direccion pasada por parametro es en grados.
		disp = d;
		direccion = Math.toRadians(direc);
	}
	
	public void accionar() {
		if(fueraDeLimite(disp)) {
			disp.morir();
		}
		else { 
			disp.setX(disp.getX() + disp.getVelocidad() * Math.cos(direccion));
			disp.setY(disp.getY() + disp.getVelocidad() * Math.sin(direccion));
		}
	}
	
	private boolean fueraDeLimite(Disparo shoot) {
		
	}

}
