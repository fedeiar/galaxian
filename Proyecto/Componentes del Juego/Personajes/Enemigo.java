package Personajes;

import Inteligencias.*;
import Logica.*;
import NivelPersonajes.NivelEnemigo_1;

public abstract class Enemigo extends Personajes {

	//atributos
	
	
	protected Inteligencia inteligencia;
	protected NivelEnemigo_1 miNivel; // redefine el atributo de personaje
	
	//constructor
	
	public Enemigo(int x, int y,  int nivel) { // parametro logica removido para probar
		super(x,y);
		setNivel(nivel);
		
		
		//no inicializamos los demas atributos porque estan en miNivel.
		//y como los enemigos no agarran powerups, van a permanecer constantes.
		//el nivel de un enemigo determina la dificultad del nivel.
	}
	
	//es privado ya que un enemigo no subirá de nivel, sino que se instanciara uno con un nivel determinado
	private void setNivel(int n) {
		if (n==1)
			miNivel = new NivelEnemigo_1();
		else {
			//mas adelante cuando esten implementados los otros nivelEnemigo_, iran aqui
		}
	}
	
	//metodos
	
	
	public Inteligencia getInteligencia() {
		return inteligencia;
	}
	
	
	public int getPuntaje() {
		return miNivel.getPuntaje();
	}
	
	public int getVelocidadMovimiento() {
		return miNivel.getVelocidadMovimiento();
	}
	
	public int getVelocidadDisparo() {
		return miNivel.getVelocidadDisparo();
	}
	
	public int getHP() {
		return miNivel.getHP();
	}
	
	public void setInteligencia(Inteligencia i) {
		inteligencia = i;
	}
	
	public void quitarHP(int n) {
		if( HP - n > 0)
			HP -= n;
		else {
			//habria que destruir al enemigo
		}
	}
	
	//movimiento comun a todos los enemigos
	
	public void mover(int n , int ancho) {
		if(n==0) {
			moverIzquierda(ancho);
		}
		else
			if(n==1)
				moverDerecha(ancho);
	}
	
	private void moverIzquierda(int ancho) {
		if(rec.x - miNivel.getVelocidadMovimiento() > 0) { 
			setX(rec.x - miNivel.getVelocidadMovimiento()); //  y aca *
		}
	}
	
	private void moverDerecha(int ancho) {
		if(rec.x + miNivel.getVelocidadMovimiento() < ancho - rec.getWidth()) { //ver rec.getWidth() para ver si entra bien
			setX(rec.x + miNivel.getVelocidadMovimiento()); // aca *
		}
		
	}
	
	
	
	
}
