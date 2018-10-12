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
	
	boolean ya_mori;
	//constructor
	
	public Enemigo(Logica l,int x, int y,  int nivel) { 
		
		//----parte logica del enemigo----
		
		super(l);
		vis = new VisitorEnemigo(this);
		setNivel(nivel);
		
		HP = miNivel.getHP();
		
		ya_mori = false;
		
		
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
		//al morir un enemigo dropea un powerup, ¿que powerup? esto puede verse con PROTOYPE, lo de abajo es TEMPORAL
		//demasiado hardcodeado NO SEGUIR CON ESTO
		
		Premio P=null;
		Random ran = new Random();
		int r  = ran.nextInt(4);
		
		if(r==0)
			P = new MejoraArma1(getX(),getY(), miNivel.getVelocidadMovimiento() * 2 ,log); //ver los atributos de este powerup, si conviene inicializarlos o que sean constantes.
		else
			if(r==1)
				P = new CongelamientoTiempo(getX(),getY(), miNivel.getVelocidadMovimiento() * 2 , log);
			else
				if(r==2)
					P = new MejoraArma2(getX(),getY(), miNivel.getVelocidadMovimiento() * 2 ,log);
				else
					P = new Invulnerabilidad(getX(),getY(), miNivel.getFuerzaImpacto() *2 , log);
		
		log.agregarObjeto(P);
	
	}
	
	
	//------------COLISION-------------
	
	public void serVisitado(Visitor v) { // sería el "aceptar(Visitor v)"
		v.afectarEnemigo(this);
	}
	
	
	
	
}
