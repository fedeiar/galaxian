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

	protected ArmaEnemigo miArma;
	
	//constructor
	
	public Enemigo(Logica l,int x, int y,  int nivel) { 
		
		//----parte logica del enemigo----
		
		super(l);
		vis = new VisitorEnemigo(this);
		setNivel(nivel);
		
		HP = miNivel.getHP();
		
		
		//----parte grafica del enemigo----
		
		rec = new Rectangle(x,y,ANCHO,ALTO);
	}
	
	
	private void setNivel(int n) {
		if (n==1)
			miNivel = new NivelEnemigo_1();
		else {
			//mas adelante cuando esten implementados los otros nivelEnemigo_, iran aqui
		}
	}
	
	//metodos
	
	
	public int getPuntaje() {
		return miNivel.getPuntaje();
	}
	
	public int getVelocidadMovimiento() {
		return miNivel.getVelocidadMovimiento();
	}

	
	public int getFuerzaImpacto() {
		return miNivel.getFuerzaImpacto();
	}
	
	
	public void quitarHP(int n) {
		if( HP - n > 0)
			HP -= n;
		else {
			
			morir(); 
		}
	}
	
	
	//----forma de morir comun a todos los enemigos----
	
	public void morir() {
		int puntaje = miNivel.getPuntaje();
		log.setPuntaje(log.getPuntaje() + puntaje);
		log.setCantEnemigos(log.cantEnemigos() - 1);
		log.eliminarObjeto(this);
		
		//al morir un enemigo dropea un powerup, ¿que powerup? esto puede verse con PROTOYPE, lo de abajo es TEMPORAL
		//demasiado hardcodeado NO SEGUIR CON ESTO
		
		Premios P=null;
		Random ran = new Random();
		int r  = ran.nextInt(2);
		
		if(r==0)
			P = new MejoraArma1(getX(),getY(), miNivel.getVelocidadMovimiento() * 2 ,log , 5); //ver los atributos de este powerup, si conviene inicializarlos o que sean constantes.
		else
			P = new MejoraArma2(getX(),getY(), miNivel.getVelocidadMovimiento() * 2 ,log);
		
		log.agregarObjeto(P);
	
	}
	
	
	//------------COLISION-------------
	
	public void serVisitado(Visitor v) { // sería el "aceptar(Visitor v)"
		v.afectarEnemigo(this);
	}
	
	
	
	
}
