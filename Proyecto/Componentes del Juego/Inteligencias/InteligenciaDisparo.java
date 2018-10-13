package Inteligencias;
import Disparos.*;
public  class InteligenciaDisparo extends Inteligencia{

	//atributos
	
	protected Disparo disp;
	double direccion; 
	
	//constructor

	public InteligenciaDisparo(Disparo d , double direc) { //la direccion pasada por parametro es en grados.
		disp = d;
		direccion = Math.toRadians(direc);
	}
	
	public void accionar() {
		if(fueraDeLimite()) {
			disp.morir();
		}
		else { 
			disp.setX(disp.getX() + disp.getVelocidad() * Math.cos(direccion));
			disp.setY(disp.getY() + disp.getVelocidad() * ( - Math.sin(direccion))); //negativo ya que para subir hay que restar en Y
		}
	}
	
	private boolean fueraDeLimite() {
		if( (disp.getX() < 0) || (disp.getX() > ANCHO_MAPA) || (disp.getY() < 0) || (disp.getY() > ALTO_MAPA))
			return true;
		else
			return false;
	}

}
