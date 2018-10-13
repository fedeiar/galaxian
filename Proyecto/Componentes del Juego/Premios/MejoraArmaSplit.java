package Premios;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.Visitor;

import java.awt.Color;

import javax.swing.JLabel;

import Armas.*;
public class MejoraArmaSplit extends ObjetosPreciosos{
	
	
	//atributos
	
	ArmaJugador nuevaArma;
	
	//constructor
	public MejoraArmaSplit(double x, double y, double velCaida, Logica l) {
		
		//---parte logica de la MejoraArmaSplit---
		super(x, y, velCaida, l);
		nuevaArma = new ArmaSplitJugador(log,0,0);
		
		
		//---parte grafica de la MejoraArmaSplit---
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.RED);
		
	}
	
	//metodos

	
	public void activarPremio(Jugador j) {
		ArmaJugador old = j.getArma();
		
		nuevaArma.setVelocidadDisparo(old.getVelocidadDisparo());
		nuevaArma.setFuerzaDisparo(old.getFuerzaDisparo());
		
		j.setArma(nuevaArma);
		
		morir();
	}

	
	public void serVisitado(Visitor v) {
		
	}

}
