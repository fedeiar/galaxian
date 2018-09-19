package Personajes;

import Logica.*;
import NivelPersonajes.*;

import java.awt.Color;

import javax.swing.*;
public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	
	protected int vidas; //al perder toda su HP, el jugador pierde una vida
	
	//jugador tiene como atributos estos datos ya que ademas de los provistos por nivel, pueden ser incrementados por algun powerup
	protected int velocidadMovimiento;
	protected int velocidadDisparo;
	
	protected NivelJugador_1 miNivel; //redefine el atributo miNivel de Personajes
	
	//considerar un atributo booleano de vulnerabilidad
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (int x , int y ) { //parametro logica removido para probar
		
		//---parte logica del jugador---
		super(x,y);
		
		miNivel = new NivelJugador_1();
		
		velocidadMovimiento = miNivel.getVelocidadMovimiento();
		HP = miNivel.getHP();
		velocidadDisparo = miNivel.getVelocidadDisparo();
		vidas = 3;
		
		//---parte grafica del jugador---
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(miNivel.getImagen());
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.red);
	
	}
	
	//----------------METODOS----------------
	
	//NIVELES
	
	public NivelPersonaje getNivel() {
		return miNivel;
	}
	
	public void setNivel(int n) {
		if(n==1)
			miNivel = new NivelJugador_1();
		else {
			//mas adelante agregar proximos niveles
		}
		
		etiqueta.setIcon(miNivel.getImagen());
	}
	
	//VELOCIDAD de movimiento y disparo
	
	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
	public void setVelocidadDisparo(int n) {
		velocidadDisparo = n;
	}
	
	public void setVelocidadMovimiento(int n) {
		velocidadMovimiento = n;
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
		else {
			vidas--;
			HP = miNivel.getHP();
		}
		if(vidas<0) {
			//habria que ver como destruir al jugador, es decir game over.
		}
		
	}
	
	//MOVIMIENTO ( ver los labels, si usar setX o solo mover el rectangulo )*
	
	public void accionar(int lado) {
		mover(lado, AnchoMapa);
	}
	
	public void mover(int n , int ancho) {
		if(n==0) {
			moverIzquierda(ancho);
		}
		else
			if(n==1)
				moverDerecha(ancho);
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
	
	private void moverDerecha(int ancho) {
		if(rec.x + velocidadMovimiento < ancho - rec.getWidth()) { //ver rec.getWidth() para ver si entra bien
			setX(rec.x + velocidadMovimiento); // aca *
		}
		else
			setX(0);
	}
	
	
	
}
