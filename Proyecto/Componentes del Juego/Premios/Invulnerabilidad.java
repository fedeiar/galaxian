package Premios;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.Visitor;
import Visitors.VisitorDummy;
import Escudos.*;
import Inteligencias.InteligenciaEscudoTemporal;

public class Invulnerabilidad extends MagiaTemporal{

	//atributos
	
	protected final int durabilidad = 6000;
	
	protected EscudoInvulnerable escudo_invulnerable;
	protected Escudo escudo_viejo;
	protected Jugador jugador; //se inicializa cuando se active el premio
	
	//constructor
	
	
	public Invulnerabilidad(double x, double y, double velCaida, Logica l) {
		
		//----parte logica del EscudoProtector----
		
		super(x, y, velCaida, l);
		escudo_invulnerable = new EscudoInvulnerable();
		
		//----parte grafica del EscudoProtector----
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.PINK);
	}

	//metodos
	
	public Premio clone() {
		return new Invulnerabilidad(this.getX() , this.getY() , this.velocidadDeCaida , log);
	}
	
	public void activarPremio(Jugador j) {
		vis = new VisitorDummy();
		inteligencia = new InteligenciaEscudoTemporal(this , escudo_invulnerable , j , 7000);
		
	}
	
}
