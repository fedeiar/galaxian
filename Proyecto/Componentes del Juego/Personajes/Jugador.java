package Personajes;

import Logica.*;

import java.awt.Color;

import javax.swing.*;
public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	
	
	//considerar un atributo booleano de vulnerabilidad
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (int x , int y , Logica l) {
		super(x,y,l);
		//inicializar vulnerable cuando este el atributo
		
		miNivel = new NivelJugador_1();
		
		velocidadMovimiento = miNivel.getVelocidadMovimiento();
		HP = miNivel.GetHP();
		velocidadDisparo = miNivel.getVelocidadDisparo();
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(miNivel.getImagen());
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.red);
	
	}
	
	//----------------METODOS----------------
	
	public void setNivel(int n) {
		if(n==1)
			miNivel = new NivelJugador_1();
		else {
			//mas adelante agregar proximos niveles
		}
		
		etiqueta.setIcon(miNivel.getImagen());
	}
	
	//MOVIMIENTO ( ver los labels, si usar setX o solo mover el rectangulo )*
	
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
			setX(0);
	}
	
	private void moverIzquierda(int ancho) {
		if(rec.x - velocidadMovimiento > 0) { 
			setX(rec.x - velocidadMovimiento); //  y aca *
		}
		else {
			long aux = Math.round(rec.getWidth());
			setX(ancho - (int)aux); //si bien un long es un int pero mas largo, hace falta casting
			
			//SI LA GUI CRAHSEA REVISAR ACA!!!!!
		}
	}
	
	
	
}
