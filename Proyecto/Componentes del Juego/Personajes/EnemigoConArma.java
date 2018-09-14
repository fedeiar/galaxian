package Personajes;
import java.awt.Color;

import javax.swing.*;

import Logica.*;

public class EnemigoConArma extends Enemigo {

	//atributos
	
	
	
	//constructor
	
	public EnemigoConArma(int x, int y , Logica l , int nivel) {
		super(x,y,l,nivel);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(null); // cuando tengamos la imagen, cambiamos null por la direccion del .gif
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.blue);
		
		//habria que inicializar al inteligencia
	}
	
	
}
