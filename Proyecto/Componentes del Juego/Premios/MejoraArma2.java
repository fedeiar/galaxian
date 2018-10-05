package Premios;
import Logica.*;
import Visitors.*;

import java.awt.Color;

import javax.swing.JLabel;

import Armas.*;
public class MejoraArma2 extends ObjetosPreciosos{

	//atributos
	
	ArmaJugador premioArma;
	
	//constructor
	
	public MejoraArma2 (int x, int y, int velCaida,Logica l) {
		
		//----parte logica de la mejora----
		
		super(x,y,velCaida,l);
		vis = new VisitorMejoraArma2(this);
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
	
	
}
