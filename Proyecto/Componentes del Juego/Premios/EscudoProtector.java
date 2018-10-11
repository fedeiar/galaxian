package Premios;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.Visitor;

public class EscudoProtector extends ObjetosPreciosos{

	//atributos
	
	
	
	//constructor
	
	
	public EscudoProtector(int x, int y, int velCaida, Logica l) {
		
		//----parte logica del EscudoProtector----
		
		super(x, y, velCaida, l);
		
		
		//----parte grafica del EscudoProtector----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.PINK);
	}

	
	//metodos
	
	
	public void activarPremio(Jugador j) {
		j.activarEscudo();
		morir();
	}

	
	public void serVisitado(Visitor v) {
		
	}
	
}
