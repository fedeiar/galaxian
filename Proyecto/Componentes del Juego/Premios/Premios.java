package Premios;
import ObjetoGeneral.*;

import java.awt.Rectangle;

import Logica.*;
import Mapas.Mapa;

public abstract class Premios extends Objeto {

	//------ATRIBUTOS------
	
	protected final static int ANCHO=10;
	protected final static int LARGO=10;
	
	protected int velocidadDeCaida;
	
	//--------CONSTRUCTOR-------
	
	public Premios (int x,int y,int velCaida,Logica l) {
		//parte logica de los premios
		
		super(l);
		velocidadDeCaida = velCaida;
		
		//---parte grafica de los premios---
		rec = new Rectangle(x,y,ANCHO,LARGO);
	}
	
	//------METODOS------
	
	//forma de caer comun a todos los premios
	
	public void accionar() {
		if(this.getY() > Mapa.MAX_Y + LARGO) {
			log.eliminarObjeto(this);
		}
		else
			this.setY(this.getY() + velocidadDeCaida);
	}
	
	//forma de morir comun a todos los premios
	public void morir() { }
	
	
}
