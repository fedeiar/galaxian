package Personajes;
import Visitors.*;
import Inteligencias.*;
import Logica.*;
import ObjetoGeneral.Objeto;
import javax.swing.*;

import Disparos.DisparoJugador;
public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	
	protected int vidas; //al perder toda su HP, el jugador pierde una vida
	
	//jugador tiene como atributos estos datos ya que ademas de los provistos por nivel, pueden ser incrementados por algun powerup
	protected int velocidadMovimiento;
	protected int velocidadDisparo;
	protected int fuerzaDisparo;
	
	protected final static int maxHP = 10;
	
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (Logica l,int x , int y ) { 
		
		//---parte logica del jugador---
		super(l,x,y);
		vis = new VisitorJugador();
		inteligencia = new InteligenciaJugador(this);
		
		
		HP = maxHP;
		velocidadMovimiento = 20;
		velocidadDisparo = 20;
		fuerzaDisparo = 1;
		vidas = 3;
		
		//---parte grafica del jugador---
		imagen = new ImageIcon("Sprites/Frisk.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
		
		
	}
	
	//----------------METODOS----------------
	
	
	//VELOCIDAD de movimiento y disparo
	
	public int getFuerzaDisparo() {
		return fuerzaDisparo;
	}
	
	public int getVelocidadDisparo() {
		return velocidadDisparo;
	}
	
	public int getVelocidadMovimiento() {
		return velocidadMovimiento;
	}
	
	public void setFuerzaDisparo(int n) {
		fuerzaDisparo = n;
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
		DisparoJugador disparoJ = new DisparoJugador(log, getVelocidadDisparo() , getFuerzaDisparo() ,
				 getX() + getAncho() / 2 , getY() );
		log.agregarObjeto(disparoJ);
	}
	
	//-----VISITOR-----
	
	public void serVisitado(Visitor v) {
		v.afectarJugador(this);
	}
	
}
