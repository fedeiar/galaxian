package Personajes;

import Logica.*;

import java.awt.Color;

import javax.swing.*;
public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	
	private int vidas; //al perder toda su HP, el jugador pierde una vida
	
	
	//considerar un atributo booleano de vulnerabilidad
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (int x , int y , Logica l) {
		super(x,y,l);
		//inicializar vulnerable cuando este el atributo
		
		miNivel = new NivelJugador_1();
		
		velocidadMovimiento = miNivel.getVelocidadMovimiento();
		HP = miNivel.getHP();
		velocidadDisparo = miNivel.getVelocidadDisparo();
		vidas = 3;
		
		
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
			
			//SI CRAHSEA REVISAR ACA!!!!!
		}
	}
	
	//Vidas y HP
	public int getHP() {
		return HP;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public void quitarHP(int n) {
		if ( HP - n > 0)
			HP -= n;
		else
			vidas--;
		
		if(vidas<0) {
			//habria que ver como destruir al jugador, es decir game over.
		}
		
	}
	
}
