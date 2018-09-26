package Premios;
import java.awt.Color;

import javax.swing.*;

import Logica.*;
import Visitors.*;

public class MejoraArma1 extends ObjetosPreciosos {

	//atributos
	
	private int modifVelocidadDisparo;
	
	//constructor
	
	public MejoraArma1(int x,int y,int velCaida,Logica l , int modifVelDisp) {
		
		//----parte logica de la mejora----
		super(x,y,velCaida,l);
		modifVelocidadDisparo = modifVelDisp;
		vis = new VisitorMejoraArma1(l,this);
		
		//----parte grafica de la mejora----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.ORANGE);
	}
	//metodos

	public int getModificadorVelocidadDisparo() {
		return modifVelocidadDisparo;
	}
	
	
	
	
	
	//---VISITOR---
	public void serVisitado(Visitor v) {
		
	}
	
	
}
