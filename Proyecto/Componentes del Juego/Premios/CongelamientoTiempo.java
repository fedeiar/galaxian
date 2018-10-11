package Premios;

import java.awt.Color;
import TDALista.*;

import javax.swing.JLabel;

import Logica.Logica;
import ObjetoGeneral.Objeto;
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
		PositionList<Objeto> lista_objetos = log.getListaObjetos();
		Visitor visitor = new VisitorCongelador();
		for(Objeto o : lista_objetos) {
			o.serVisitado(visitor);
		}
		
		morir();
	}

}
