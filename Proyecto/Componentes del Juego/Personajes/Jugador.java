package Personajes;
import Visitors.*;
import Armas.*;
import Inteligencias.*;
import Logica.*;
import ObjetoGeneral.Objeto;

import java.awt.Rectangle;

import javax.swing.*;

import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	protected final static int ANCHO = 30;
	protected final static int ALTO = 30;
	public final static int maxHP = 10;
	
	protected int vidas; //al perder toda su HP, el jugador pierde una vida
	
	protected int velocidad_movimiento;
	
	protected boolean escudo;
	protected ArmaJugador miArma;
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (Logica l,int x , int y ) { 
		
		//---parte logica del jugador---
		super(l);
		vis = new VisitorJugador();
		inteligencia = new InteligenciaJugador(this);
		miArma = new ArmaClasicaJugador(log , 20 , 1); //los 2 parametros enteros son la velocidad y fuerza del ARMA
		
		HP = maxHP;
		velocidad_movimiento = 20;
		vidas = 3;
		escudo = false;
		
		//---parte grafica del jugador---
		rec = new Rectangle(x,y,ANCHO,ALTO);
		imagen = new ImageIcon("Sprites/Frisk.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
		
		
	}
	
	//----------------METODOS----------------
	
	
	//VELOCIDAD de movimiento
	
	public int getVelocidadMovimiento() {
		return velocidad_movimiento;
	}
	
	
	public void setVelocidadMovimiento(int n) {
		velocidad_movimiento = n;
	}
	
	//ARMA
	
	public ArmaJugador getArma() {
		return miArma;
	}
	
	public void setArma(ArmaJugador a) {
		miArma = a;
	}
	
	//Vidas , HP y escudo
	
	public void activarEscudo(){
		try {
			escudo = true;
			Thread.sleep(6000); //cual thread?
			escudo = false;
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getVidas() {
		return vidas;
	}
		
	public void quitarHP(int n) {
		if(!escudo) {
			if ( HP - n > 0)
				HP -= n;
			else {
				vidas--;
				HP = maxHP;
			}
			if(vidas<0) {
				morir();
			}
		}
	}
	
	//-----MOVIMIENTO------
		
	
	public void mover (int dir) {
		inteligencia.setDireccion(dir);
	}
	
	//------DISPARO------
	
	
	public void disparar() {
		inteligencia.setShoot();
	}
	
	public void crearDisparo() {
		int x = getX() + getAncho() / 2;
		int y = getY();
		
		miArma.disparar(x, y);
	}
	
	
	//-----VISITOR-----
	
	public void serVisitado(Visitor v) {
		v.afectarJugador(this);
	}
	
}
