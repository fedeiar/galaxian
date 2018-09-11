package Mapas;
import Grafica.*;
public abstract class Mapa  {

	 //atributos
	
	 private final static int  MAX_X=900; //ancho del frame
	 private final static int MAX_Y=600;  //alto del frame
	 
	 protected GUI gui;
	 //constructor
	 
	 public Mapa(GUI g) {
		 gui = g;
	 }
	 
	 //metodos
	 
	 public int getAncho() {
		 return MAX_X;
	 }
	 
	 public int getAlto() {
		 return MAX_Y;
	 }
	 
	public abstract void crearNivel();
}
