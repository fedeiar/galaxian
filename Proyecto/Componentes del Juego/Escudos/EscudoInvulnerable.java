package Escudos;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logica.Logica;
import Personajes.Jugador;
import Visitors.Visitor;

public class EscudoInvulnerable extends Escudo{

	//atributos
	
	//constructor
	
	public EscudoInvulnerable() {
		//---parte logica del EscudoInvulnerable---
		
		
		
		//---parte grafica del EscudoInvulnerable---
		rec = new Rectangle(POS_X , POS_Y , ANCHO , ALTO);
		imagen = new ImageIcon("Sprites/Shield_inv.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
	}
	
	//metodos
	
	public int getDaño(int daño_recibido) {
		return 0;
	}

	
}
