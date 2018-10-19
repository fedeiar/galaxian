package Personajes;
import Visitors.*;

import java.awt.Rectangle;
import java.util.Random;

import Armas.*;
import Inteligencias.*;
import Logica.*;
import NivelEnemigos.*;
import ObjetoGeneral.Objeto;
import Premios.*;
public abstract class Enemigo extends Personajes {

	//atributos
	protected final static int ANCHO = 30;
	protected final static int ALTO = 30;
	
	
	protected NivelEnemigo miNivel; 
	protected Premio power_up;
	protected Arma miArma;
	
	boolean ya_mori;
	//constructor
	
	public Enemigo(Logica l,double x, double y,  int nivel , Premio P) { 
		
		//----parte logica del enemigo----
		
		super(l);
		visitor = new VisitorEnemigo(this);
		setNivel(nivel);
		
		HP = miNivel.getHP();
		power_up = P;
		
		ya_mori = false;
		
		
		//----parte grafica del enemigo----
		rec = crear_rectangulo(x,y,ANCHO,ALTO);
	}
	
	
	private void setNivel(int n) {
		switch(n) {
		case -1 : miNivel = new NivelSans();
				   break;
		case 1 :   miNivel = new NivelEnemigo_1();
				   break;
		case 2 :   miNivel = new NivelEnemigo_2();
				   break;
		default :  miNivel = new NivelEnemigo_1();
				   break;
		}
	}
	
	//metodos
	
	
	public int getPuntaje() {
		return miNivel.getPuntaje();
	}
	
	public double getVelocidadMovimiento() {
		return miNivel.getVelocidadMovimiento();
	}

	
	public int getFuerzaImpacto() {
		return miNivel.getFuerzaImpacto();
	}
	
	
	public void quitarHP(int n) {
		if( HP - n > 0)
			HP -= n;
		else {
			if(!ya_mori) { //este chequeo se hace porque cuando impacta un disparo del arma doble lo "mata" 2 veces
				morir();   //es decir, se ejecuta morir() 2 veces.
				ya_mori = true; 
			}
			
		}
	}
	
	
	//----forma de morir comun a todos los enemigos----
	
	public void morir() {
		int puntaje = miNivel.getPuntaje();
		log.setPuntaje(log.getPuntaje() + puntaje);
		log.setCantEnemigos(log.cantEnemigos() - 1);
		log.eliminarObjeto(this);
		
		Random ran = new Random();
		int r  = ran.nextInt(10);
		
		if(r<6) {
			power_up.setX( getX() );
			power_up.setY( getY() );
			power_up.setVelocidadCaida( this.getVelocidadMovimiento() * 2 );
			log.agregarObjeto(power_up);
		}
		
	
	}
	
	
	//------------COLISION-------------
	
	public void serVisitado(Visitor v) { // sería el "aceptar(Visitor v)"
		v.afectarEnemigo(this);
	}
	
	
	
	
}
