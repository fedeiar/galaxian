package Inteligencias;
import Logica.*;
import java.awt.Rectangle;


public class InteligenciaEnemigoConArma implements Inteligencia{
	
	Rectangle rec;
	
	public InteligenciaEnemigoConArma(Rectangle r) {
		rec=r; //Seria el rectangulo correspondiete al enemigo. 
		
	}
	
	
	
	//Este metodo estapara que compile, pero el que vale es el de abajo pero nos faltan metodos.
	public void mover(int n, int ancho) {}
	
	
	
	/*
	public void mover(int n , int ancho) {
		if(n==0) {
			moverIzquierda(ancho);
		}
		else
			if(n==1)
				moverDerecha(ancho);
	}
	
	
	private void moverDerecha(int ancho) {
		if(rec.x + velocidadMovimiento < ancho - rec.getWidth()) { //ver rec.getWidth() para ver si entra bien
			setX(rec.x + velocidadMovimiento); // aca *
		}
		else
			moverIzquierda(ancho);
	}
	
	private void moverIzquierda(int ancho) {
		if(rec.x - velocidadMovimiento > 0) { 
			setX(rec.x - velocidadMovimiento); //  y aca *
		}
		else {
			moverDerecha(ancho);
		}
	}
	
	
	*/
	
	
}
