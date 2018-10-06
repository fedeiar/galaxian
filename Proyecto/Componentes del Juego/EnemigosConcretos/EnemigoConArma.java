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
		
		//----parte logica del EnemigoConArma---
		
		super(l,x,y,nivel);
		inteligencia = new InteligenciaEnemigoConArma(this);
		miArma = new ArmaClasicaEnemigo(log , 15 , 2 ); //los 2 parametros enteros son la vel. y fuerza del disparo del ARMA
		
		
		
		//----parte grafica del EnemigoConArma----
		
		imagen = new ImageIcon("Sprites/Enemy_2.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen); // cuando tengamos la imagen, cambiamos null por la direccion del .gif
		//etiqueta.setOpaque(true);
		//etiqueta.setBackground(Color.blue);
		
	}
	
	//metodos
	
	//---DISPARO---
	
	public boolean puedo_shoot() {
		return miArma.puedo_shoot();
	}
	
	public void crearDisparo() {
		int x = getX() + getAncho() / 2;
		int y = getY() + getAlto();
	
		miArma.disparar(x, y);
	}
	
}
