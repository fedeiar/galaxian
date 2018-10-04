package EnemigosConcretos;
import java.awt.Color;
import Armas.*;

import javax.swing.*;

import Disparos.DisparoEnemigo;
import Personajes.Enemigo;
import Inteligencias.*;
import Logica.*;
public class EnemigoConArma extends Enemigo {

	//atributos
	
	
	
	//constructor
	
	public EnemigoConArma(Logica l, int x, int y , int nivel) {
		super(l,x,y,nivel);
		inteligencia = new InteligenciaEnemigoConArma(this);
		
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(null); // cuando tengamos la imagen, cambiamos null por la direccion del .gif
		etiqueta.setOpaque(true);
		etiqueta.setBackground(Color.blue);
		
		miArma = new ArmaClasicaEnemigo(log , 15 , 2 ); //los 2 parametros enteros son la velocidad y fuerza del ARMA
	}
	
	//metodos
	
	//---DISPARO---
	

	
	public void crearDisparo() {
		int x = getX() + getAncho() / 2;
		int y = getY() + getAlto();
	
		miArma.disparar(x, y);
	}
	
}
