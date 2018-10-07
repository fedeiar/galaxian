package EnemigosConcretos;
import Logica.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Inteligencias.*;
import Personajes.*;

public class EnemigoKamikaze extends Enemigo{

	//atributos
	
	
	
	//constructor
	
	public EnemigoKamikaze(Logica l , int x , int y , int nivel) {
		
		//----parte logica del EnemigoKamikaze----
		super(l,x,y,nivel);
		inteligencia = new InteligenciaEnemigoKamikaze(this);
		
		
		//----parte grafica del EnemigoKamikaze----
		
		imagen = new ImageIcon("Sprites/Enemy_1.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
	}
	
	//metodos
	
	
}
