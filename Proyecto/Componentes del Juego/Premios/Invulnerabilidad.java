package Premios;

import java.awt.Color;

import javax.swing.JLabel;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.Visitor;
import Escudos.*;

public class Invulnerabilidad extends MagiaTemporal implements Runnable{

	//atributos
	protected final int durabilidad = 6000;
	
	protected EscudoInvulnerable escudo_invulnerable;
	protected Escudo escudo_viejo;
	protected Jugador jugador; //se inicializa cuando se active el premio
	
	//constructor
	
	
	public Invulnerabilidad(int x, int y, int velCaida, Logica l) {
		
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
	
	
	public void activarPremio(Jugador j) {
		jugador = j;
		escudo_viejo = j.getEscudo();
		Thread waiter = new Thread(this);
		waiter.start();
		morir();
	}

	public void run() {
		try {
			jugador.setEscudo(escudo_invulnerable);
			
			Thread.sleep(durabilidad);
			
			jugador.setEscudo(escudo_viejo);
			
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void serVisitado(Visitor v) {
		
	}
	
}
