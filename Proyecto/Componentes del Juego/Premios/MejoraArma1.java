package Premios;
import java.awt.Color;

import javax.swing.*;

import Armas.ArmaJugador;
import Logica.*;
import Personajes.Jugador;
import Visitors.*;

public class MejoraArma1 extends ObjetosPreciosos {

	//atributos
	
	//constructor
	
	public MejoraArma1(int x,int y,int velCaida,Logica l ) {
		
		//----parte logica de la mejora----
		
		super(x,y,velCaida,l);
		
		
		//----parte grafica de la mejora----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.ORANGE);
	}
	//metodos

	
	//---VISITOR---
	
	public void serVisitado(Visitor v) {
		
	}
	
	public void activarPremio(Jugador j) {
		ArmaJugador a = j.getArma();
		
		a.setVelocidadDisparo(a.getVelocidadDisparo() + 10);
		morir();
	}
	
}
