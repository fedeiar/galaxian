package Escudos;

import javax.swing.JLabel;

import Logica.Logica;

public class SinEscudo extends Escudo{

	//atributos
	
	//constructor
	
	public SinEscudo() {
		
		
		etiqueta = new JLabel();
	}
	
	//metodos
	
	public int getDaño(int daño_recibido) {
		return daño_recibido;
	}
}
