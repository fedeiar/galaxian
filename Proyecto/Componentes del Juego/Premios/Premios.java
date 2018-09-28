package Premios;
import ObjetoGeneral.*;

import java.awt.Rectangle;

import Logica.*;
import Mapas.Mapa;
import Inteligencias.*;
public abstract class Premios extends Objeto {

	//------ATRIBUTOS------
	
	protected final static int ANCHO=10;
	protected final static int LARGO=10;
	
	protected int velocidadDeCaida;
	
	//--------CONSTRUCTOR-------
	
	public Premios (int x,int y,int velCaida,Logica l) {
		//---parte logica de los premios---
		
		super(l);
		inteligencia = new InteligenciaPremio(this);
		velocidadDeCaida = velCaida;
		
		//---parte grafica de los premios---
		rec = new Rectangle(x,y,ANCHO,LARGO);
	}
	
	//------METODOS------
	
	public int getVelocidadDeCaida() {
		return velocidadDeCaida;
	}
	
	
	//forma de morir comun a todos los premios
	
	public void morir() {
		log.eliminarObjeto(this);
	}
	
	
}
