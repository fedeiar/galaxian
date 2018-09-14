package EnemigosConcretos;
import java.awt.Color;

import javax.swing.*;

import Logica.*;
import Personajes.Enemigo;

public class EnemigoConArma extends Enemigo {

	//atributos
	
	
	
	//constructor
	
	public EnemigoConArma(int x, int y , int nivel) { //parametro logica removido para probar
		super(x,y,nivel);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(null); // cuando tengamos la imagen, cambiamos null por la direccion del .gif
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.blue);
		
		//habria que inicializar la inteligencia
	}
	
	
	
}
