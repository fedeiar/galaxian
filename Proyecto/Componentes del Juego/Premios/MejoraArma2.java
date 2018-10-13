package Premios;
import Logica.*;
import Personajes.Jugador;
import Visitors.*;

import java.awt.Color;

import javax.swing.JLabel;

import Armas.*;
public class MejoraArma2 extends ObjetosPreciosos{

	//atributos
	
	ArmaJugador premioArma;
	
	//constructor
	
	public MejoraArma2 (double x, double y, double velCaida,Logica l) {
		
		//----parte logica de la mejora----
		
		super(x,y,velCaida,l);
		premioArma = new ArmaDobleJugador(log,0,0); //la vel. y fuerza seran seteados despues.
		
		//----parte grafica de la mejora----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.BLUE);
	}
	
	//metodos
	
	public ArmaJugador getArma() {
		return premioArma;
	}
	
	
	//----VISITOR----
	
	public void serVisitado(Visitor v) {
		
	}
	
	public void activarPremio(Jugador j) {
		ArmaJugador old = j.getArma();
		ArmaJugador nueva = getArma();
		
		nueva.setVelocidadDisparo(old.getVelocidadDisparo());
		nueva.setFuerzaDisparo(old.getFuerzaDisparo());
		
		j.setArma(nueva);
		
		morir();
	}
}
