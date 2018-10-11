package Premios;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.Visitor;
import Escudos.*;
public class Invulnerabilidad extends MagiaTemporal{

	//atributos
	
	EscudoInvulnerable shield_i;
	EscudoTemporal temp_shield;
	//constructor
	
	
	public Invulnerabilidad(int x, int y, int velCaida, Logica l) {
		
		//----parte logica del EscudoProtector----
		
		super(x, y, velCaida, l);
		shield_i = new EscudoInvulnerable();
		
		//----parte grafica del EscudoProtector----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.PINK);
	}

	//metodos
	
	
	public void activarPremio(Jugador j) {
		temp_shield = new EscudoTemporal(j , shield_i , 7000);
		Thread waiter = new Thread(temp_shield);
		waiter.start();
		morir();
	}

	
	public void serVisitado(Visitor v) {
		
	}
	
}
