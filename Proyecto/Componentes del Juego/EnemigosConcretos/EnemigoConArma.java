package EnemigosConcretos;
import java.awt.Color;

import javax.swing.*;
import Personajes.Enemigo;
import Inteligencias.*;
import Logica.*;
public class EnemigoConArma extends Enemigo {

	//atributos
	
	
	
	//constructor
	
	public EnemigoConArma(Logica l, int x, int y , int nivel) { //parametro logica removido para probar
		super(l,x,y,nivel);
		inteligencia = new InteligenciaEnemigoConArma(this);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(null); // cuando tengamos la imagen, cambiamos null por la direccion del .gif
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.blue);
		
		//habria que inicializar la inteligencia
	}
	
	
	
}
