package EnemigosConcretos;
import Logica.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Inteligencias.*;
import Personajes.*;
import Premios.Premio;

public class EnemigoKamikaze extends Enemigo{

	//atributos
	
	
	
	//constructor
	
	public EnemigoKamikaze(Logica l , double x , double y , int nivel , Premio P) {
		
		//----parte logica del EnemigoKamikaze----
		super(l,x,y,nivel,P);
		inteligencia = new InteligenciaEnemigoKamikaze(this);
		
		
		//----parte grafica del EnemigoKamikaze----
		
		imagen = new ImageIcon("Sprites/Enemy_1.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
	}
	
	//metodos
	
	
}
