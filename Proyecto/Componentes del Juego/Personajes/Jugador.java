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
	
	
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (Logica l,int x , int y ) { 
		
		//---parte logica del jugador---
		super(l,x,y);
		
		miNivel = new NivelJugador_1();
		
		velocidadMovimiento = miNivel.getVelocidadMovimiento();
		HP = miNivel.getHP();
		velocidadDisparo = miNivel.getVelocidadDisparo();
		vidas = 3;
		
		//---parte grafica del jugador---
		imagen = new ImageIcon("Sprites/Frisk.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
		
		
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
			morir();
		}
		
	}
	
	//-----MOVIMIENTO------
	
	public void accionar() {}
	
	
	public void mover(int n) {
		if(n==0) {
			moverIzquierda();
		}
		else
			if(n==1)
				moverDerecha();
	}
	
	private void moverIzquierda() {
		if(rec.x - velocidadMovimiento > 0) { 
			setX(rec.x - velocidadMovimiento); //  y aca *
		}
		else {
			long aux = Math.round(rec.getWidth());
			setX(AnchoMapa - (int)aux); //si bien un long es un int pero mas largo, hace falta casting
			
			//SI CRAHSEA REVISAR ACA!!!!!
		}
	}
	
	private void moverDerecha() {
		if(rec.x + velocidadMovimiento < AnchoMapa - rec.getWidth()) { //ver rec.getWidth() para ver si entra bien
			setX(rec.x + velocidadMovimiento); // aca *
		}
		else
			setX(0);
	}
	
	
	
}
