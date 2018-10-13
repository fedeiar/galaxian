package Premios;
import Logica.*;
import Personajes.Jugador;
import Visitors.*;

import java.awt.Color;

import javax.swing.JLabel;

import Armas.*;
public class MejoraArmaDoble extends ObjetosPreciosos{

	//atributos
	
	ArmaJugador nuevaArma;
	
	//constructor
	
	public MejoraArmaDoble (double x, double y, double velCaida,Logica l) {
		
		//----parte logica de la mejora----
		
		super(x,y,velCaida,l);
		nuevaArma = new ArmaDobleJugador(log,0,0); //la vel. y fuerza seran seteados despues.
		
		//----parte grafica de la mejora----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.BLUE);
	}
	
	//metodos
	
	
	
	public void activarPremio(Jugador j) {
		ArmaJugador old = j.getArma();
		
		nuevaArma.setVelocidadDisparo(old.getVelocidadDisparo());
		nuevaArma.setFuerzaDisparo(old.getFuerzaDisparo());
		
		j.setArma(nuevaArma);
		
		morir();
	}
}
