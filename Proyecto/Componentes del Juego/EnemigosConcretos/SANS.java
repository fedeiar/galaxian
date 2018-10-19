package EnemigosConcretos;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Armas.ArmaSans;
import Disparos.DisparoSansEnemigo;
import Logica.Logica;
import Mapas.Mapa;
import Personajes.Enemigo;
import Premios.Premio;

public class SANS extends Enemigo{

	//atributos
	
	protected final static int ANCHO = 100;
	protected final static int ALTO = 100;
	
	
	
	//constructor
	
	public SANS(Logica l, double x, double y, int nivel, Premio P) {
		
		//----PARTE LOGICA DE SANS----
		
		super(l, x, y, nivel, P);
		miArma = new ArmaSans(log);
		
		//----PARTE GRAFICA DE SANS----
		
		rec = this.crear_rectangulo(x, y, ANCHO, ALTO);
		imagen = new ImageIcon("Sprites/Sans.png");
		etiqueta = new JLabel();
		etiqueta.setBounds(rec);
		etiqueta.setIcon(imagen);
		
		
	}

	//metodos
	
	public void crear_disparos() {
		double x = 0; //ya que el arma de sans se encarga de crearlos en X
		double y = this.getY() + this.getAncho();
		
		miArma.disparar(x, y);
	}
	
	public void lanzar_poder() {
		Random ran = new Random();
		int r_ataque = ran.nextInt(3);
		switch(r_ataque) {
		case 0 : shootFromBelow();
				 break;
		case 1 : blasters();
				 break;
		case 2 : multipleShots();
				 break;
		}
	}
	
	public void shootFromBelow() {
		Random ran = new Random();
		int r_disp = ran.nextInt(120);
			
		for(int i=1 ; i<9 ; i++) {
			DisparoSansEnemigo dispE = new DisparoSansEnemigo(log, 15 , 5 ,(r_disp * i) % Mapa.MAX_X, Mapa.MAX_Y / 2 ,90);
			log.agregarObjeto(dispE);
		}
		
	}
}
