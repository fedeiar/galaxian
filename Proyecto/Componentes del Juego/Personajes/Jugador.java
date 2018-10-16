package Personajes;
import Visitors.*;
import Escudos.*;
import Armas.*;
import Inteligencias.*;
import Logica.*;
import ObjetoGeneral.Objeto;

import java.awt.Rectangle;

import javax.swing.*;

import Disparos.Disparo;
import Disparos.DisparoComunJugador;
import Disparos.DisparoJugador;
public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	protected final static int ANCHO = 30;
	protected final static int ALTO = 30;
	public final static int maxHP = 10;
	public final static int VidasIniciales = 0;
	
	protected int vidas; //al perder toda su HP, el jugador pierde una vida
	
	protected int velocidad_movimiento;
	
	protected Escudo mi_escudo;
	protected Arma mi_arma;
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (Logica l,double x , double y ) { 
		
		//---parte logica del jugador---
		super(l);
		vis = new VisitorJugador();
		inteligencia = new InteligenciaJugador(this);
		mi_arma = new ArmaClasicaJugador(log); 
		mi_escudo = new SinEscudo();
		
		HP = maxHP;
		velocidad_movimiento = 20;
		vidas = VidasIniciales;
		
		
		//---parte grafica del jugador---
		
		rec = crear_rectangulo(x,y,ANCHO,ALTO);
		imagen = new ImageIcon("Sprites/Frisk.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
		
		
	}
	
	//----------------METODOS----------------
	
	
	//VELOCIDAD de movimiento
	
	public double getVelocidadMovimiento() {
		return velocidad_movimiento;
	}
	
	
	public void setVelocidadMovimiento(int n) {
		velocidad_movimiento = n;
	}
	
	//ARMA
	
	public Arma getArma() {
		return mi_arma;
	}
	
	public void setArma(Arma a) {
		mi_arma = a;
	}
	
	//Vidas , HP y escudo
	
	public Escudo getEscudo() {
		return mi_escudo;
	}
	
	public void setEscudo(Escudo e){
		mi_escudo = e;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getVidas() {
		return vidas;
	}
		
	public void quitarHP(int n) {
		int daño = mi_escudo.getDaño(n);
		
		if ( HP - daño > 0)
			HP -= daño;
		else {
			vidas--;
			HP = maxHP;
		}
		if(vidas<0) {
			HP = 0;
			vidas = 0;
			morir();
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
		double x = getX() + getAncho() / 2;
		double y = getY();
		
		mi_arma.disparar(x, y);
	}
	
	//---FORMA DE MORIR DEL JUGADOR---
	
	public void morir() {
		log.perder();
	}
	
	
	//-----VISITOR-----
	
	public void serVisitado(Visitor v) {
		v.afectarJugador(this);
	}

	
	
}
