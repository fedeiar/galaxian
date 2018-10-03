package EnemigosConcretos;
import java.awt.Color;

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
		

	}
	
	//metodos
	
	//---DISPARO---
	
	public void crearDisparo() {
		DisparoEnemigo disparoE = new DisparoEnemigo(log,getVelocidadDisparo(),getFuerzaDisparo()
				  , getX() + getAncho() / 2 , getY() + getAlto() );
		log.agregarObjeto(disparoE);	
	}
	
}
