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
	
	public EnemigoConArma(Logica l, double x, double y , int nivel) {
		
		//----parte logica del EnemigoConArma---
		
		super(l,x,y,nivel);
		inteligencia = new InteligenciaEnemigoConArma(this);
		miArma = new ArmaClasicaEnemigo(log , 15 , 2 ); //los 2 parametros enteros son la vel. y fuerza del disparo del ARMA
		
		
		
		//----parte grafica del EnemigoConArma----
		
		imagen = new ImageIcon("Sprites/Enemy_2.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen); 
	}
	
	//metodos
	
	//---DISPARO---
	
	public void crearDisparo() {
		double x = getX() + getAncho() / 2;
		double y = getY() + getAlto();
	
		miArma.disparar(x, y);
	}
	
}
