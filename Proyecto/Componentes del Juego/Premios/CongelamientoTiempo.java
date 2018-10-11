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
	
	Visitor vis_2;
	//constructor
	
	public CongelamientoTiempo(int x, int y, int velCaida, Logica l) {
		
		//---parte logica de CongelamientoTiempo---
		
		super(x, y, velCaida, l);
		
		vis_2 = new VisitorCongelador();
		
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
		
		for(Objeto o : lista_objetos) {
			o.serVisitado(vis_2);
		}
		
		morir();
	}

}
