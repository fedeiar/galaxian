package Personajes;
import Visitors.*;
import TDALista.*;
import Escudos.*;
import Armas.*;
import Inteligencias.*;
import Logica.*;

import javax.swing.*;

public class Jugador extends Personajes {
	
	//--------------ATRIBUTOS----------------
	protected final static int ANCHO = 30;
	protected final static int ALTO = 30;
	public final static int maxHP = 10;
	public final static int VidasIniciales = 0;
	
	protected int vidas; //al perder toda su HP, el jugador pierde una vida
	
	protected int velocidad_movimiento;
	
	protected PositionList<Escudo> mi_escudo_temporal;
	protected Escudo mi_escudo_permanente;
	
	protected Arma mi_arma;
	
	//--------------CONSTRUCTOR--------------
	
	public Jugador (Logica l,double x , double y ) { 
		
		//---parte logica del jugador---
		super(l);
		vis = new VisitorJugador();
		inteligencia = new InteligenciaJugador(this);
		mi_arma = new ArmaClasicaJugador(log);
		
		mi_escudo_permanente = new SinEscudo();
		mi_escudo_temporal = new ListaDE<Escudo>();
		
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
	
	public void setEscudoTemporal(Escudo e) {
		mi_escudo_temporal.addLast(e);	
	}
	
	public void eliminarEscudoTemporal() {
		try {
			mi_escudo_temporal.remove(mi_escudo_temporal.first());
		}
		catch(InvalidPositionException | EmptyListException e) {
			e.printStackTrace();
		}
	}
	
	public void setEscudoPermanente(Escudo e){
		mi_escudo_permanente = e;
	}
	
	public int getHP() {
		return HP;
	}
	
	public int getVidas() {
		return vidas;
	}
		
	public void quitarHP(int n) {
		try {
		
			int daño;
			if(!mi_escudo_temporal.isEmpty())
				daño = mi_escudo_temporal.last().element().getDaño(n);
			else
				daño = mi_escudo_permanente.getDaño(n);
		
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
		catch(EmptyListException e) {
			e.printStackTrace();
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
