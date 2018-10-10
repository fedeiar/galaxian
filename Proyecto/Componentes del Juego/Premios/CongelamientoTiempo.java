package Premios;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.*;

public class CongelamientoTiempo extends MagiaTemporal{

	//atributos
	
	
	//constructor
	
	public CongelamientoTiempo(int x, int y, int velCaida, Logica l) {
		
		//---parte logica de CongelamientoTiempo---
		
		super(x, y, velCaida, l);
		
		
		//---parte grafica de CongelamientoTiempo---
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.GREEN);
	}

	
	
	//metodos
	
	
	public void serVisitado(Visitor v) {
		
	}
	
	public void activarPremio(Jugador j) {
		j.congelarTiempo();
		morir();
	}

}
