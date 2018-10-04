package Personajes;
import Visitors.*;
import Armas.*;
import Inteligencias.*;
import Logica.*;
import ObjetoGeneral.Objeto;
import javax.swing.*;

import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	
	protected int vidas; //al perder toda su HP, el jugador pierde una vida
	
	protected int velocidadMovimiento;
	
	protected final static int maxHP = 10;
	
	protected Arma miArma;
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (Logica l,int x , int y ) { 
		
		//---parte logica del jugador---
		super(l,x,y);
		vis = new VisitorJugador();
		inteligencia = new InteligenciaJugador(this);
		miArma = new ArmaClasicaJugador(log , 20 , 1); //los 2 parametros enteros son la velocidad y fuerza del ARMA
		
		HP = maxHP;
		velocidadMovimiento = 20;
		vidas = 3;
		
		//---parte grafica del jugador---
		imagen = new ImageIcon("Sprites/Frisk.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
		
		
	}
	
	//----------------METODOS----------------
	
	
	//VELOCIDAD de movimiento
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
	
	public void setVelocidadMovimiento(int n) {
		velocidadMovimiento = n;
	}
	
	//ARMA
	
	public Arma getArma() {
		return miArma;
	}
	
	public void setArma(Arma a) {
		miArma = a;
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
			HP = maxHP;
		}
		if(vidas<0) {
			morir();
		}
		
	}
	
	//-----MOVIMIENTO------
		
	
	public void mover (int dir) {
		inteligencia.setDireccion(dir);
	}
	
	//------DISPARO------
	
	public void disparar(int disp) {
		inteligencia.setShoot(disp);
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
