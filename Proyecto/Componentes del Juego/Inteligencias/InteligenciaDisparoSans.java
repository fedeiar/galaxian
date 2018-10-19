package Inteligencias;
import Disparos.*;
public  class InteligenciaDisparoSans extends Inteligencia{

	//atributos
	
	protected Disparo disp;
	double direccion; //direccion del disparo, medida en grados. (entre 0 y 360)
	
	//constructor

	public InteligenciaDisparoSans(Disparo d , double direc) {
		disp = d;
		direccion = Math.toRadians(direc);
	}
	
	//metodos
	
	public void accionar() {
		if(!fueraDeLimite()) {
			disp.setX(disp.getX() + disp.getVelocidad() * Math.cos(direccion));
			disp.setY(disp.getY() + disp.getVelocidad() * ( - Math.sin(direccion))); //negativo ya que para subir hay que restar en Y
		}
	}
	
	private boolean fueraDeLimite() {
		if(disp.getX() < 0)
			disp.setX(ANCHO_MAPA - disp.getAncho());
		else
			if ( disp.getX() > ANCHO_MAPA )
				disp.setX(0);
			else
				if (disp.getY() < 0)
					disp.setY(ALTO_MAPA - disp.getAlto());
				else
					if (disp.getY() > ALTO_MAPA)
						disp.setY(0);
					else
						return false;
		
		return true;
	}

}
